package a03DennisThomas;

import java.time.LocalDateTime;

import javafx.beans.property.SimpleStringProperty;

public class Station {
	private SimpleStringProperty ort;
	private LocalDateTime ankunftsZeit;
	private LocalDateTime abfahrtsZeit;

	public Station(String ort, LocalDateTime ankunftsZeit, LocalDateTime abfahrtsZeit) {
		this.ort = new SimpleStringProperty(ort);
		this.ankunftsZeit = ankunftsZeit;
		this.abfahrtsZeit = abfahrtsZeit;
	}

	public String getOrt() {
		return ort.get();
	}

	public LocalDateTime getAnkunftsZeit() {
		return ankunftsZeit;
	}

	public LocalDateTime getAbfahrtsZeit() {
		return abfahrtsZeit;
	}

}
