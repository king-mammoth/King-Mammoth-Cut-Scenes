package org.kingmammoth.kmcutscenes.test;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class ButtonTest extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setTitle("Hello World!");
		Button btn = new Button();
		btn.setText("'Hello World'");
		btn.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				System.out.println("Hello World!");
			}
		});
		
		primaryStage.setWidth(1000);
		primaryStage.setHeight(1000);
		
		System.out.println(primaryStage.getWidth());
		System.out.println(primaryStage.getHeight());
		
		StackPane root = new StackPane();
		btn.setMinHeight(60);
		btn.setMinWidth(120);
		btn.setLayoutX(0.8 * primaryStage.getWidth());
		btn.setLayoutY(0.8 * primaryStage.getHeight());
		root.getChildren().add(btn);
		primaryStage.setScene(new Scene(root, primaryStage.getWidth(), primaryStage.getHeight()));
		primaryStage.show();
		
		primaryStage.heightProperty().addListener(e -> {
			btn.setLayoutX(0.8 * primaryStage.getWidth());
			btn.setLayoutY(0.8 * primaryStage.getHeight());
		});

		primaryStage.widthProperty().addListener(e -> {
			btn.setLayoutX(0.8 * primaryStage.getWidth());
			btn.setLayoutY(0.8 * primaryStage.getHeight());
		});
		
	}

}
