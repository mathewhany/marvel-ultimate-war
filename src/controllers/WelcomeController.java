package controllers;

import javafx.scene.input.KeyCode;
import views.WelcomeView;

public class WelcomeController extends BaseController<WelcomeView> {
    @Override
    public WelcomeView createView() {
        return new WelcomeView();
    }

    @Override
    public void onKeyPress() {
        if (keys.contains(KeyCode.SPACE)) {
            switchTo(new ChooseNamesController());
        }
    }
}
