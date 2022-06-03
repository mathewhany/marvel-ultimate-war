package controllers;

import views.GameView;
import views.KeyboardShortcutGuideView;

public class KeyboardShortcutGuideController extends BaseController<KeyboardShortcutGuideView> implements KeyboardShortcutGuideView.Listener {
    @Override
    public KeyboardShortcutGuideView createView() {
        return new KeyboardShortcutGuideView(this);
    }

    @Override
    public void onConfirm() {
        switchTo(new GameController());
    }
}
