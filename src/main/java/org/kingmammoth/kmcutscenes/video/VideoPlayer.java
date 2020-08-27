package org.kingmammoth.kmcutscenes.video;

import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

import org.kingmammoth.kmcutscenes.KingMammothCutScenes;
import org.kingmammoth.kmcutscenes.event.WorldGenerationEvent;
import org.kingmammoth.kmcutscenes.video.component.SkipButton;
import org.lwjgl.opengl.Display;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.Mod;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

@Mod.EventBusSubscriber(Side.CLIENT)
public class VideoPlayer extends Application {

	public int width = Minecraft.getMinecraft().displayWidth;
	public int height = Minecraft.getMinecraft().displayHeight;
	public int timeElapsedMilliseconds = 0;

	public Stage primary;
	
	public WebEngine webEngine;
	
	public AtomicBoolean isDone;

	@Override
	public void start(Stage primaryStage) {
		
		this.primary = primaryStage;
		
		Timeline resize = new Timeline(new KeyFrame(Duration.millis(1), new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				match();
				if (isDone.get()) {
					primaryStage.close();
				}
				timeElapsedMilliseconds++;
			}
		}));
		resize.setCycleCount(Timeline.INDEFINITE);
		resize.play();
		
		Platform.setImplicitExit(false);
		
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

		webEngine = webView.getEngine();
		webEngine.loadContent(LinkUtils.getContentURL(KingMammothCutScenes.video, width, height));

		StackPane root = new StackPane();
		root.getChildren().add(webView);
		root.setStyle("-fx-background-color: transparent ;");

		SkipButton btn = new SkipButton();
		StackPane.setAlignment(btn, Pos.BOTTOM_RIGHT);
		root.getChildren().add(btn);

		Scene scene = new Scene(root, width, height);

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
				resize.stop();

			}
		});

	}

	public void match() {

		if (WorldGenerationEvent.subscribed) {

			primary.setX(Display.getX() + 8);
			primary.setY(Display.getY() + 30);

			if ((Minecraft.getMinecraft().displayHeight != height || Minecraft.getMinecraft().displayWidth != width)) {

				// Implement Window Change Here Actual video size is not changing
				primary.setWidth(Display.getWidth());
				primary.setHeight(Display.getHeight());
				
				LinkUtils.setNewWindowLink(width, height, timeElapsedMilliseconds/1000);
				webEngine.loadContent(LinkUtils.getContentURL(KingMammothCutScenes.video, width, height));


			}
			
			if (Display.isActive()) {
				primary.requestFocus();
			}
			
		}

	}

	public void launchApp() {

		launch(new String[] { null });

	}

}