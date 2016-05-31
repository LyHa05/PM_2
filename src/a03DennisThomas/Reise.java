package a03DennisThomas;

import java.time.Duration;
import java.time.LocalDateTime;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Reise {

	final ObservableList<Station> stationen;
	private Station startStation;
	private Station endStation;

	public Reise(Station start, Station ziel) {
		stationen = FXCollections.observableArrayList();
		startStation = start;
		endStation = ziel;
	}

	public ObservableList<Station> getStationen() {
		return stationen;
	}

	public Reise() {
		stationen = FXCollections.observableArrayList();
	}

	public void addStation(Station stationNeu, Station stationVor) {
		int index = stationen.indexOf(stationVor);
		index++;
		stationen.add(index, stationNeu);
	}

	public void addStation(Station stationNeu) {
		if (startStation == null) {
			startStation = stationNeu;
			
			stationen.add(stationNeu);
		} else {
			if (endStation == null) {
				endStation = stationNeu;
				stationen.add(stationNeu);
			} else {
				stationen.add(stationen.size()-1,stationNeu);
			}
		}
	}

	public void stationErsetzen(Station stationNeu, Station stationAlt) {
		int index = stationen.indexOf(stationAlt);
		stationen.set(index, stationNeu);
	}

	public Duration reiseDauerBrutto() {
		LocalDateTime startzeit = startStation.getAbfahrtsZeit();
		LocalDateTime endzeit = endStation.getAnkunftsZeit();
		return Duration.between(startzeit, endzeit);
	}

	public Duration reiseDauerNetto() {
		Duration gesamtAufenthalt = Duration.ZERO;
		for (Station station : stationen) {
			LocalDateTime ankunftsZeit = station.getAnkunftsZeit();
			LocalDateTime abfahrtsZeit = station.getAbfahrtsZeit();
			Duration aufenthalt = Duration.between(ankunftsZeit, abfahrtsZeit);
			gesamtAufenthalt = gesamtAufenthalt.plus(aufenthalt);
		}
		return this.reiseDauerBrutto().minus(gesamtAufenthalt);
	}

	public String toString() {
		String ausgabe = "";
		ausgabe += startStation.getOrt() + "\tAbfahrt:" + startStation.getAbfahrtsZeit().toString() + "\n";
		for (Station station : stationen) {
			ausgabe += station.getOrt() + "\tAnkunft:" + station.getAnkunftsZeit().toString() + "\tAbfahrt:"
					+ station.getAbfahrtsZeit().toString() + "\n";
		}
		ausgabe += endStation.getOrt() + "\tAnkunft:\t" + endStation.getAnkunftsZeit().toString() + "\n";
		ausgabe += "Reisedauer Brutto: " + this.reiseDauerBrutto().toString() + "\n";
		ausgabe += "Reisedauer Netto: " + this.reiseDauerNetto().toString() + "\n";
		return ausgabe;
	}

	public static void main(String[] args) {
		Station start = new Station("Hamburg", null, LocalDateTime.of(2016, 3, 29, 13, 20));
		Station end = new Station("Lübeck", LocalDateTime.of(2016, 5, 29, 15, 20), null);
		Reise r = new Reise(start, end);
		System.out.println(r.toString());
	}

}
