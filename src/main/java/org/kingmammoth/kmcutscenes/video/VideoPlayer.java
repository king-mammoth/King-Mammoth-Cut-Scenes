package org.kingmammoth.kmcutscenes.video;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class VideoPlayer extends Application {
	
	public String link;
	public int height;
	public int width;
	
	@Override
	public void start(Stage primaryStage) {
		WebView webView = new WebView();
		WebEngine webEngine = webView.getEngine();
		webEngine.loadContent(LinkUtils.getContentURL("https://www.youtube.com/embed/M7lc1UVf-VE?autoplay=1&autohide=1&controls=0"));

		StackPane root = new StackPane();
		root.getChildren().add(webView);

		Scene scene = new Scene(root, width, height);

		primaryStage.setScene(scene);
		primaryStage.show();
	}

}

