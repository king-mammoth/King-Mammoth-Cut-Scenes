package org.kingmammoth.kingmammothcutscenes.player.node;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class SkipButton extends Button {

	public SkipButton() {

		setText("Skip the Video");
		setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				setText("Skipped");
				Stage stage = (Stage) getScene().getWindow();
				stage.close();

			}
		});
		DropShadow shadow = new DropShadow();
		addEventHandler(MouseEvent.MOUSE_ENTERED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				setEffect(shadow);
			}
		});
		addEventHandler(MouseEvent.MOUSE_EXITED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				setEffect(null);

			}
		});

		setDefaultButton(true);
		setVisible(true);

	}
}
