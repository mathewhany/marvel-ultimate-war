package views;

import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.HashMap;
import java.util.LinkedHashMap;

public class KeyboardShortcutGuideView extends BaseView {
    private Listener listener;

    public KeyboardShortcutGuideView(Listener listener) {
        this.listener = listener;
    }

    @Override
    public Pane createContent() {
        HashMap<String, Object> shortcuts = new LinkedHashMap<>();
        shortcuts.put("Move", "Arrow Keys");
        shortcuts.put("Attack", "Arrow Keys + Shift");
        shortcuts.put("End Turn", "X");
        shortcuts.put("Use Ability 1", "Q");
        shortcuts.put("Use Ability 2", "W");
        shortcuts.put("Use Ability 3", "E");
        shortcuts.put("Use Ability 4", "T");
        shortcuts.put("Directional Abilities", "Ability Key + Arrow Keys");
        shortcuts.put("Single Target Abilities", "Ability Key + Mouse Click");
        shortcuts.put("Use Leader Ability", "R");

        Pane guide = ViewHelper.detailsBox("Controls", shortcuts);

        Button nextBtn = new Button("I understand, start game!");
        nextBtn.setOnAction(e -> {
            listener.onConfirm();
        });

        VBox container = new VBox(guide, nextBtn);
        container.setId("keyboard-shortcuts-guide-view");

        return container;
    }

    public interface Listener {
        void onConfirm();
    }
}
