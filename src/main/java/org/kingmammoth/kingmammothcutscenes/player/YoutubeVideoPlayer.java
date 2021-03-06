package org.kingmammoth.kingmammothcutscenes.player;

import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

import org.kingmammoth.kingmammothcutscenes.KingMammothCutScenes;
import org.kingmammoth.kingmammothcutscenes.player.node.SkipButton;
import org.kingmammoth.kingmammothcutscenes.youtube.VideoSettings;
import org.kingmammoth.kingmammothcutscenes.youtube.util.LinkUtils;
import org.lwjgl.opengl.Display;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
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
import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import javafx.event.EventHandler;

@Mod.EventBusSubscriber(Side.CLIENT)
public class YoutubeVideoPlayer extends Application {

	public int width = Minecraft.getMinecraft().displayWidth;
	public int height = Minecraft.getMinecraft().displayHeight;
	public int timeElapsedMilliseconds = -8; // Loadup Times

	public Stage primary;

	public WebEngine webEngine;

	public AtomicBoolean isDone = new AtomicBoolean(false);

	public VideoSettings settings;

	@Override
	public void start(Stage primaryStage) {

		this.primary = primaryStage;
		
		Platform.setImplicitExit(false);
		
		settings = KingMammothCutScenes.settings;

		Timeline resize = new Timeline(new KeyFrame(Duration.millis(1), new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				match();
				if (isDone.get()) {
					primaryStage.close();
					KingMammothCutScenes.current = null;
				}
				timeElapsedMilliseconds++;
			}
		}));
		resize.setCycleCount(Timeline.INDEFINITE);
		resize.play();

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
		
		if (KingMammothCutScenes.current.parameters.controls == 1) {
			
			webView.setDisable(true);
			
		}
		
		webEngine = webView.getEngine();
		webEngine.loadContent(LinkUtils.getContentURL(KingMammothCutScenes.current, width, height));

		StackPane root = new StackPane();
		root.getChildren().add(webView);
		root.setStyle("-fx-background-color: transparent ;");

		if (settings.showSkipButton) {

			SkipButton btn = new SkipButton();
			StackPane.setAlignment(btn, Pos.BOTTOM_RIGHT);
			root.getChildren().add(btn);

		}
		
		
		Scene scene = new Scene(root, width, height);
		
		primaryStage.setX(Display.getX() + 8);
		primaryStage.setY(Display.getY() + 30);
		primaryStage.setOpacity(settings.transperency);
		primaryStage.initStyle(StageStyle.UNDECORATED);
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent event) {

				if (settings.exitOnClose) {
					
					Platform.exit();
					resize.stop();
					primary.close();
					
					event.consume();

				} else {

					event.consume();

				}
			}
		});
		
		FadeTransition ft = new FadeTransition(Duration.millis(10000));
		ft.setFromValue(0.1);
		ft.setToValue(10);
		ft.setNode(webView);
		ft.play();

	}

	public void match() {

		if (settings.followMinecraftScreenDrag) {

			primary.setX(Display.getX() + 8);
			primary.setY(Display.getY() + 30);

		}

		if ((Minecraft.getMinecraft().displayHeight != height || Minecraft.getMinecraft().displayWidth != width)
				&& settings.followMinecraftScreenSize) {

			primary.setWidth(Display.getWidth());
			primary.setHeight(Display.getHeight() - 5);

			height = Minecraft.getMinecraft().displayHeight;
			width = Minecraft.getMinecraft().displayWidth;

			LinkUtils.setNewWindowLink(width, height, timeElapsedMilliseconds / 1000);
			webEngine.loadContent(LinkUtils.getContentURL(KingMammothCutScenes.current, width, height));

		}

		if (Display.isActive() && settings.focusOnScreen) {
			primary.requestFocus();
		}

	}

	public void launchApp() {

		launch(new String[] { null });

	}

}