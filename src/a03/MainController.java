package a03;

import java.time.LocalDateTime;
import java.time.LocalTime;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;

public class MainController {

	@FXML
	TextField ort;
	@FXML
	DatePicker ankunftsDatum;
	@FXML
	DatePicker abreiseDatum;
	@FXML
	TextField abreiseZeit;
	@FXML
	TextField ankunftsZeit;
	@FXML
	Button stationNeuBtn;

	Reise reise;
	@FXML
	TableView<Station> tabelle;
	@FXML
	TableColumn<Station, LocalDateTime> abfahrtSpalte;
	@FXML
	TableColumn<Station, LocalDateTime> ankunftSpalte;
	@FXML
	TableColumn<Station, String> stationSpalte;

	@FXML
	public void initialize() {
		abreiseZeit.setPromptText("hh:mm");
		ankunftsZeit.setPromptText("hh:mm");
		reise = new Reise();
		stationSpalte.setCellValueFactory(new PropertyValueFactory<Station, String>("ort"));
		ankunftSpalte.setCellValueFactory(new PropertyValueFactory<Station, LocalDateTime>("ankunftsZeit"));

		abfahrtSpalte.setCellValueFactory(new PropertyValueFactory<Station, LocalDateTime>("abfahrtsZeit"));
		
		stationNeuBtn.setOnMouseClicked(evnt -> {
			LocalTime abreiseZeit = LocalTime.parse(this.abreiseZeit.getText());
			LocalTime ankunftsZeit = LocalTime.parse(this.ankunftsZeit.getText());
			LocalDateTime abreise = LocalDateTime.of(abreiseDatum.getValue(), abreiseZeit);
			LocalDateTime ankunft = LocalDateTime.of(ankunftsDatum.getValue(), ankunftsZeit);
			Station station = new Station(ort.getText(), ankunft, abreise);
			reise.addStation(station);
			tabelle.setItems(reise.getStationen());
			
			
			
			
		});
	}

//	@FXML
//	public void stationNeuKlickEvent(MouseEvent event) {
//		LocalTime abreiseZeit = LocalTime.parse(this.abreiseZeit.getText());
//		LocalTime ankunftsZeit = LocalTime.parse(this.ankunftsZeit.getText());
//		LocalDateTime abreise = LocalDateTime.of(abreiseDatum.getValue(), abreiseZeit);
//		LocalDateTime ankunft = LocalDateTime.of(ankunftsDatum.getValue(), ankunftsZeit);
//		Station station = new Station(ort.getText(), ankunft, abreise);
//		reise.addStation(station);
//		tabelle.setItems(reise.getStationen());
//	}
}
