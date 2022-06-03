package views;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import utils.SoundUtils;

import javax.swing.*;

public class Button extends javafx.scene.control.Button {

    public Button() {
        super();
        addEventFilter(ActionEvent.ACTION, Button::playSound);
    }

    public Button(String text) {
        super(text);
        addEventFilter(ActionEvent.ACTION, Button::playSound);
    }

    public static void playSound(ActionEvent e) {
        SoundUtils.playSound("/button.mp3");
    }
}
