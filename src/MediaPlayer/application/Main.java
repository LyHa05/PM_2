package MediaPlayer.application;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author  Chris Thiele, Lydia Pflug
 * @date    17.06.2016
 *
 * Die Klasse Main initialisiert die sample.fxml-Datei und startet damit die Anwendung.
 */

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("sample.fxml")); 
			Scene scene = new Scene(root);  
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.show();
				primaryStage.setMinHeight(scene.getHeight() + 50);
				primaryStage.setMinWidth(scene.getWidth());
				primaryStage.setTitle("Unser Media Player");
			} catch(Exception e) {
				e.printStackTrace();
			}
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
