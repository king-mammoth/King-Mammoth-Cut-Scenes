package org.kingmammoth.kmcutscenes.video;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Set;

import org.kingmammoth.kmcutscenes.KingMammothCutScenes;

import javafx.application.Application;
import javafx.collections.ListChangeListener;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class VideoPlayer extends Application {

	@Override
	public void start(Stage primaryStage) {

		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) screenSize.getWidth();
		int height = (int) screenSize.getHeight();

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
		webEngine.loadContent(LinkUtils.getContentURL(KingMammothCutScenes.videolink, width, height));

		StackPane root = new StackPane();
		root.getChildren().add(webView);

		Scene scene = new Scene(root, width, height);

		primaryStage.initStyle(StageStyle.UNDECORATED);
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void launchApp() {

		launch(new String[] { null });

	}

}
