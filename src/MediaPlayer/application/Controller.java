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
import javafx.scene.control.Button;
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
	@FXML BorderPane bgWindowPane;
	@FXML private MediaView mediaView;
	private MediaPlayer mediaPlayer;
	private Media media;
	@FXML Slider volumeSlider;
	@FXML VBox uiBox;
	@FXML Slider runTimeSlider;
	@FXML Label labelActualRuntime;
	@FXML Label labelMaxRuntime;
	@FXML Button vollBildModus;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		/**Medienpfad
		 * Startmedium muss im Media-Ordner liegen, danach koennen andere Dateien geladen werden.*/
		String path = new File("src/MediaPlayer/media/vid.mp4").getAbsolutePath();
		media = new Media(new File(path).toURI().toString());
		
		/**Erstellung des MediaPlayers*/
		mediaPlayer = new MediaPlayer(media);
		
		/**An MediaView wird MediaPLayer uebergeben*/
		mediaView.setMediaPlayer(mediaPlayer);
		
		vollBildModus.getStyleClass().add("vollBildButton"); /** Quelle: http://images.google.de/imgres?imgurl=http%3A%2F%2Fwww.tenforums.com%2Fgeek%2Fgars%2Fimages%2F2%2Ftypes%2Fthumb_full-screen.png&imgrefurl=http%3A%2F%2Fwww.tenforums.com%2Ftutorials%2F2435-apps-display-full-screen-view-windows-10-a.html&h=250&w=250&tbnid=gRl-7x9fBHnl0M%3A&docid=uoU5OfJ6GT9p-M&ei=rVNkV7DEAoqMsAG9r5TQBw&tbm=isch&client=firefox-b&iact=rc&uact=3&dur=858&page=1&start=0&ndsp=22&ved=0ahUKEwjwzqzu6a_NAhUKBiwKHb0XBXoQMwggKAIwAg&bih=565&biw=1280*/
		
		/**Einstellung der Fenstergroeße*/
		DoubleProperty mvwidth = mediaView.fitWidthProperty();  
		DoubleProperty mvheight = mediaView.fitHeightProperty(); 
		mvwidth.bind(Bindings.selectDouble(mediaView.sceneProperty(), "width")); 
		mvheight.bind(Bindings.selectDouble(mediaView.sceneProperty(), "height"));

		
		/**Volumenanzeige*/
		volumeSlider.setValue(mediaPlayer.getVolume() * 100); //*100 so that getvolume and slidervalue will match
		volumeSlider.valueProperty().addListener(new InvalidationListener() { //Volume Slider
			
			@Override
			public void invalidated(Observable observable) {
				mediaPlayer.setVolume(volumeSlider.getValue() / 100); //Give us the Value in relation to 100 so /100 is needed
				
			}
		});
		
		
		/**Laufzeitanzeige*/
		runTimeSlider.setMin(0.0);
		runTimeSlider.setValue(0.0);
		runTimeSlider.setMax(200);
		
		mediaPlayer.currentTimeProperty().addListener(new ChangeListener<Duration>() {
			@Override
			public void changed(ObservableValue<? extends Duration> observableValue, Duration duration, Duration current){
			runTimeSlider.setValue(current.toSeconds());
			}
			});
			runTimeSlider.setOnMouseClicked(new EventHandler<MouseEvent>() {
				@Override
				public void handle(MouseEvent mouseevent) {
					mediaPlayer.seek(Duration.seconds(runTimeSlider.getValue()));
				}
				
			});
		
			
			/**Aktueller Zeitstatus*/
			mediaPlayer.currentTimeProperty().addListener((Observable ov) -> {
				updateValues();
			});
	}
	
	
	/**Methode zum Aktualisieren der Lautstaerkeanzeige*/
	protected void updateValues() {
			double tempActTime = mediaPlayer.getCurrentTime().toSeconds();
			int temptActTimeInt = (int) tempActTime;
			String maxActTime = String.format("%02d:%02d:%02d",temptActTimeInt / 3600, (temptActTimeInt % 3600) / 60, (temptActTimeInt % 60));
			labelActualRuntime.setText(maxActTime);

	}
	
	/**Methode zur Dateiauswahl*/
	public void fileChooser(ActionEvent event) {
		FileChooser fc = new FileChooser();
		fc.getExtensionFilters().add(new ExtensionFilter("*.flv", "*.mp4", "*.mpeg", "*.wav", "*.mp3"));
		File file = fc.showOpenDialog(null);
		String path = file.getAbsolutePath();
		mediaPlayer.pause();

		media = new Media(new File(path).toURI().toString());
		mediaPlayer = new MediaPlayer(media);
		mediaView.setMediaPlayer(mediaPlayer);
		
		String mediaName = media.getMetadata().toString();
		Stage stage = (Stage) bgWindowPane.getScene().getWindow();
		stage.setTitle("SD Media Player" + mediaName);
	}

	/**Methode fuer Play-Button*/
	public void play(ActionEvent event) {
		mediaPlayer.play();
		mediaPlayer.setRate(1);
		
		//Set RunTimeSlider to Max RunTime
		runTimeSlider.setMax(mediaPlayer.getTotalDuration().toSeconds()); //set the max length of runtimeslider at play/start of video
	
		//Set Label to Max Runtime
		double tempTime = mediaPlayer.getTotalDuration().toSeconds();
		int temptTimeInt = (int) tempTime;
		String maxTime = String.format("%02d:%02d:%02d",temptTimeInt / 3600, (temptTimeInt % 3600) / 60, (temptTimeInt % 60));
		labelMaxRuntime.setText(maxTime);
	
	}
	
	/**Methode fuer Pause-Button*/
	public void pause(ActionEvent event) {
		mediaPlayer.pause();
	}
	
	/**Methode fuer Beschleunigungs-Button*/
	public void fast(ActionEvent event) {
		mediaPlayer.setRate(2); //double the speed of the media
	}
	
	/**Methode fuer Verlangsamungsbutton*/
	public void slow(ActionEvent event) {
		mediaPlayer.setRate(.5); //half speed
	}

	/**Methode fuer Stop-Button*/
	public void stop(ActionEvent event) {
		mediaPlayer.seek(mediaPlayer.getStartTime()); //only move video to start but will not play
		mediaPlayer.stop();
	}
	
	/**Methode fuer Informationsausgabe.*/
	@FXML
	private void handleAbout() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Unser Media Player");
		alert.setHeaderText("Ueber unseren Media Player");
		alert.setContentText(
				"Hier koennte auch Ihre Werbung stehen!");
		alert.showAndWait();
	}

	/**Methode fuer Vollbildmodus.*/
	@FXML
	private void handleFullscreen() {
		Stage stage = (Stage) bgWindowPane.getScene().getWindow();
		stage.setFullScreen(true);
	}
	
	/**Methode zum Schliessen der Anwendung.*/
	@FXML
	private void handleExit() {
		System.exit(0);
	}
		
}