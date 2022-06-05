package views;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Test extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		stage.setScene(new Scene(new StackPane(new Text("Rafeek is an idiot"))));
		stage.show();
	}
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
