package views;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class CreditsView extends BaseView{

	public CreditsView() {
		
	}
	public Pane createContent() {
		HashMap<String,String[]> map = new LinkedHashMap<>();
		VBox container = new VBox();
		container.setId("credits-view");
		
		map.put("Developers", new String[] { "Rafeek", "Mathew", "Nariman" });
		map.put("special thanks" , new String[] {"Mathew","Rafeek","Nariman"});
		
		for(Map.Entry<String, String[]> entry : map.entrySet()) {
			String title = entry.getKey();
			String[] body = entry.getValue();
			Label l1 = new Label(title);
			l1.getStyleClass().add("title");
			
			VBox temp = new VBox(l1);
			temp.getStyleClass().add("credits-box");
			
			for(String text : body) {
				Label l2 = new Label(text);
				l2.getStyleClass().add("item");
				
				temp.getChildren().add(l2);
			}
			
			container.getChildren().add(temp);
		}
		
		return container;
	}

}
