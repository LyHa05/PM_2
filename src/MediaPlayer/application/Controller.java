package MediaPlayer.application;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.util.Duration;

/**
 * @author  Chris Thiele, Lydia Pflug
 * @date    17.06.2016
 *
 * Die Klasse 'Controller' erstellt die Objekte der fxml-Datei und definiert die Methoden fuer das Ausfuehren der Buttons.
 */

public class Controller implements Initializable{

	/**Variablendeklaration: Objekte aus xml Datei geparst*/
	Group root = new Group();
	@FXML BorderPane hinterGrundBorderPane;
	@FXML private MediaView mediaView;
	private MediaPlayer mediaPlayer;
	private Media medium;
	@FXML Slider s2LautstaerkeRegler;
	@FXML VBox menueBand;
	@FXML Slider s1LaufzeitRegler;
	@FXML Label l2AktuelleLaufzeit;
	@FXML Label l1MaximaleLaufzeit;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		/**Medienpfad
		 * Startmedium muss im Media-Ordner liegen, danach koennen andere Dateien geladen werden.*/
		String path = new File("src/MediaPlayer/medium/vid.mp4").getAbsolutePath();
		medium = new Media(new File(path).toURI().toString());
		
		/**Erstellung des MediaPlayers*/
		mediaPlayer = new MediaPlayer(medium);
		
		/**An MediaView wird MediaPLayer uebergeben*/
		mediaView.setMediaPlayer(mediaPlayer);
	
		/**Einstellung der Fenstergroeße*/
		DoubleProperty mvwidth = mediaView.fitWidthProperty();  
		DoubleProperty mvheight = mediaView.fitHeightProperty(); 
		mvwidth.bind(Bindings.selectDouble(mediaView.sceneProperty(), "width")); 
		mvheight.bind(Bindings.selectDouble(mediaView.sceneProperty(), "height"));

		
		/**Volumenanzeige*/
		s2LautstaerkeRegler.setValue(mediaPlayer.getVolume() * 100); 
		s2LautstaerkeRegler.valueProperty().addListener(new InvalidationListener() { 
			
			@Override
			public void invalidated(Observable observable) {
				mediaPlayer.setVolume(s2LautstaerkeRegler.getValue() / 100); 
				
			}
		});
		
		
		/**Laufzeitanzeige*/
		s1LaufzeitRegler.setMin(0.0);
		s1LaufzeitRegler.setValue(0.0);
		s1LaufzeitRegler.setMax(200);
		
		mediaPlayer.currentTimeProperty().addListener(new ChangeListener<Duration>() {
			@Override
			public void changed(ObservableValue<? extends Duration> observableValue, Duration duration, Duration current){
			s1LaufzeitRegler.setValue(current.toSeconds());
			}
			});
			s1LaufzeitRegler.setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent mouseevent) {
					mediaPlayer.seek(Duration.seconds(s1LaufzeitRegler.getValue()));
				}
				
			});
		
			
			/**Aktueller Zeitstatus*/
			mediaPlayer.currentTimeProperty().addListener((Observable ov) -> {
				werteAktualisieren();
			});
	}
	
	
	/**Methode zum Aktualisieren der Lautstaerkeanzeige*/
	protected void werteAktualisieren() {
			double aktuelleZeitDB = mediaPlayer.getCurrentTime().toSeconds();
			int aktuelleZeitInt = (int) aktuelleZeitDB;
			String maxZeit = String.format("%02d:%02d:%02d",aktuelleZeitInt / 3600, (aktuelleZeitInt % 3600) / 60, (aktuelleZeitInt % 60));
			l2AktuelleLaufzeit.setText(maxZeit);
	}
	
	/**Methode zur Dateiauswahl*/
	public void dateiAuswahl(ActionEvent event) {
		FileChooser fileChooserObj = new FileChooser();
		fileChooserObj.getExtensionFilters().add(new ExtensionFilter("*.flv", "*.mp4", "*.mpeg", "*.wav", "*.mp3"));
		File file = fileChooserObj.showOpenDialog(null);
		String path = file.getAbsolutePath();
		mediaPlayer.pause();

		medium = new Media(new File(path).toURI().toString());
		mediaPlayer = new MediaPlayer(medium);
		mediaView.setMediaPlayer(mediaPlayer);
		
		String mediumsName = medium.getMetadata().toString();
		Stage stageObj = (Stage) hinterGrundBorderPane.getScene().getWindow();
		stageObj.setTitle("SD Media Player" + mediumsName);
	}

	/**Methode fuer Play-Button*/
	public void play(ActionEvent event) {
		mediaPlayer.play();
		mediaPlayer.setRate(1);
		
		/**Anpassen des Laufzeitreglers an max Laufzeit*/
		s1LaufzeitRegler.setMax(mediaPlayer.getTotalDuration().toSeconds());
	
		/**Setzen des Labels fuer maximale Laufzeit des Mediums*/
		double tempTime = mediaPlayer.getTotalDuration().toSeconds();
		int temptTimeInt = (int) tempTime;
		String maxTime = String.format("%02d:%02d:%02d",temptTimeInt / 3600, (temptTimeInt % 3600) / 60, (temptTimeInt % 60));
		l1MaximaleLaufzeit.setText(maxTime);
	
	}
	
	/**Methode fuer Pause-Button*/
	public void pause(ActionEvent event) {
		mediaPlayer.pause();
	}
	
	/**Methode fuer Beschleunigungsbutton*/
	public void beschleunigen(ActionEvent event) {
		mediaPlayer.setRate(2);
	}
	
	/**Methode fuer Verlangsamungsbutton*/
	public void verlangsamen(ActionEvent event) {
		mediaPlayer.setRate(.5);
	}

	/**Methode fuer Stop-Button (Video wird auf Anfang zurueckgesetzt)*/
	public void stop(ActionEvent event) {
		mediaPlayer.seek(mediaPlayer.getStartTime()); 
		mediaPlayer.stop();
	}
	
	/**Methode fuer Informationsausgabe.*/
	@FXML
	private void informationen() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Unser Media Player");
		alert.setHeaderText("Ueber unseren Media Player");
		alert.setContentText(
				"Hier koennte auch Ihre Werbung stehen!");
		alert.showAndWait();
	}

		
	/**Methode zum Schliessen der Anwendung.*/
	@FXML
	private void schliessen() {
		System.exit(0);
	}
		
}