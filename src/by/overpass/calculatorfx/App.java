package by.overpass.calculatorfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class App extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("ui.fxml"));
		
		Scene scene = new Scene(root);
		scene.getStylesheets().add("style.css");
		
		stage.setScene(scene);
		stage.setTitle("CalculatorFX");
		stage.getIcons().add(new Image("file:resources/images/calculator_icon.png"));
		stage.show();
	}

}
