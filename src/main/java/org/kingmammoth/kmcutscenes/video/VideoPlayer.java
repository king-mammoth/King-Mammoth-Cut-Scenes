package org.kingmammoth.kmcutscenes.video;

import java.util.Set;

import org.kingmammoth.kmcutscenes.KingMammothCutScenes;
import org.kingmammoth.kmcutscenes.event.WorldGenerationEvent;
import org.lwjgl.opengl.Display;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class VideoPlayer extends Application {

	public int width;
	public int height;

	public static StackPane root;
	public static Button skip;

	@Override
	public void start(Stage primaryStage) {

		Platform.setImplicitExit(false);

		width = Minecraft.getMinecraft().displayWidth;
		height = Minecraft.getMinecraft().displayHeight;

		WebView webView = new WebView();
		webView.getChildrenUnmodifiable().addListener(new ListChangeListener<Node>() {
			@Override
			public void onChanged(Change<? extends Node> change) {
				Set<Node> deadSeaScrolls = webView.lookupAll(".scroll-bar");
				for (Node scroll : deadSeaScrolls) {
					scroll.setVisible(false);
				}
			}
		});

		WebEngine webEngine = webView.getEngine();
		webEngine.loadContent(LinkUtils.getContentURL(KingMammothCutScenes.video, width, height));

		root = new StackPane();
		root.getChildren().add(webView);
		root.setStyle("-fx-background-color: transparent ;");

		skip = new Button();
		skip.setText("Skip the Video");
		skip.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				skip.setText("Skipped");

			}
		});
		DropShadow shadow = new DropShadow();
		skip.addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				skip.setEffect(shadow);
			}
		});
		skip.addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				skip.setEffect(null);
			}
		});

		skip.setDefaultButton(true);
		skip.setVisible(true);
		StackPane.setAlignment(skip, Pos.BOTTOM_RIGHT);
		root.getChildren().add(skip);

		Scene scene = new Scene(root, width, height);

		primaryStage.setAlwaysOnTop(true);
		primaryStage.setX(Display.getX() + 8);
		primaryStage.setY(Display.getY() + 30);
		primaryStage.setOpacity(0.9);
		primaryStage.initStyle(StageStyle.UNDECORATED);
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent event) {
				Platform.exit();
				event.consume();
			}
		});
		primaryStage.heightProperty().addListener(e -> {
			skip.setLayoutX(0.8 * primaryStage.getWidth());
			skip.setLayoutY(0.8 * primaryStage.getHeight());
		});

		primaryStage.widthProperty().addListener(e -> {
			skip.setLayoutX(0.8 * primaryStage.getWidth());
			skip.setLayoutY(0.8 * primaryStage.getHeight());
		});

	}

	@SubscribeEvent
	public void playerTick(TickEvent.PlayerTickEvent event) {

		if (WorldGenerationEvent.subscribed && (Minecraft.getMinecraft().displayHeight != height
				|| Minecraft.getMinecraft().displayWidth != width)) {

//			primaryStage.setHeight(height);
//			primaryStage.setWidth(width);

			// Implement Window Change Here

		}

	}

	@SubscribeEvent
	public static void onPlayerJoin(PlayerEvent.PlayerLoggedInEvent event) throws Exception {
		skip.setVisible(true);
	}

	public void launchApp() {

		launch(new String[] { null });

	}

}
