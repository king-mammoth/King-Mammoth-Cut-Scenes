package org.kingmammoth.kingmammothcutscenes.test;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class WebViewBrowser extends Application {
	@Override
	public void start(Stage stage) throws Exception {
		stage.setScene(new Scene(new WebViewPane("http://google.com")));
		stage.setFullScreen(true);
		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}

class WebViewPane extends Pane {
	final WebView view = new WebView();
	final Button goButton = createGoButton(view.getEngine());

	public WebViewPane(String initURL) {
		view.getEngine().load(initURL);

		getChildren().addAll(view, goButton);

		initLayout();
	}

	private Button createGoButton(final WebEngine eng) {
		Button go = new Button("Refresh");
		go.setDefaultButton(true);
		go.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				eng.reload();
			}
		});

		return go;
	}

	private void initLayout() {
		setMinSize(500, 400);
		setPrefSize(1024, 768);

		view.prefWidthProperty().bind(widthProperty());
		view.prefHeightProperty().bind(heightProperty());

		goButton.setLayoutX(10);
		goButton.layoutYProperty().bind(heightProperty().subtract(20).subtract(goButton.heightProperty()));
	}
}
