package Aufgabe03;

import java.time.LocalDate;
import java.util.Iterator;
import java.time.temporal.ChronoUnit;

/**
 * @author  Chris Thiele, Lydia Pflug
 * @date    24.05.2016
 *
 * Die Klasse 'Logik' repraesentiert die Logikschicht des Programms.
 */

public class Logik{
    private Controller conObj;
    private boolean startUndEnde = false;
    double bruttoZeit = 0.0; // gesamte Reisezeit in Minuten
    double nettoZeit = 0.0; // Reisezeit ohne Aufenthalte in Minuten

    public Logik(Controller conObj){
        this.conObj = conObj;
    }


    /** Die Methode "startHinzufuegen" fuegt einen Startpunkt in die Liste ein, sofern noch keiner in der Liste ist */
    public void startHinzufuegen(LocalDate dp,Integer std,Integer min, String name, int stationFlag) throws Exception{
        if(!(conObj.getListView().getItems().size() == 0)){
            throw new IllegalArgumentException("Es ist bereits ein Startort vorhanden");
        }
        if(name.equals("")){
            throw new IllegalArgumentException("Bitte geben Sie einen Startort ein!");
        }

        Ort temp_ort = new Ort(name, std, min, std, min, dp, dp, stationFlag);

        conObj.getListView().getItems().add(temp_ort);
        temp_ort.setIndex(conObj.getListView().getItems().indexOf(temp_ort));
    }

    /**Die Methode "zwischenStationHinzufuegen fuegt nacht Ueberpruefung, ob die Daten korrekt sind und
     * chronologisch Sinn ergeben, eine Zwischenstation in die Liste ein. */
    public void zwischenStationHinzufuegen(LocalDate dpAnkunft, LocalDate dpAbfahrt, int stdAnk, int minAnk, int stdAbf,int minAbf, String name, int stationFlag) throws Exception{
        Ort temp_ort = new Ort(name, stdAnk, minAnk, stdAbf, minAbf, dpAnkunft, dpAbfahrt, stationFlag);

        if(conObj.getListView().getItems().size() == 0){
            throw new IllegalArgumentException("Zuerst muss ein Startort eingefuegt werden.");
        }

        if(conObj.getListView().getItems().get((conObj.getListView().getItems().size()-1)).compareTo(temp_ort) != -1){
            throw new IllegalArgumentException("Der Ankunftszeitpunkt darf nicht vor dem letzten Abfahrtszeitpunkt liegen.");
        }

        if(name.equals("")){
            throw new IllegalArgumentException("Bitte geben Sie einen Zwischenort ein!");
        }

        conObj.getListView().getItems().add(temp_ort);
        temp_ort.setIndex(conObj.getListView().getItems().indexOf(temp_ort));
    }

    /** Die Methode "endeHinzufuegen" ueberprueft, ob bereits ein Endort in der Liste ist. Ist dies nicht der Fall,
     *  wird ueberprueft, ob das letzte Abfahrtsdatum spaeter ist, als das Anreisedatum am Endzeitpunkt, ist auch
     *  dies nicht der Fall, wird der Endort zur Liste hinzugefuegt und die Boolean "startUndEnde" auf true gesetzt.
     * */
    public void endeHinzufuegen(LocalDate dp,Integer std,Integer min, String name,int stationFlag) throws Exception{

        if(conObj.getListView().getItems().size() == 0){
            throw new IllegalArgumentException("Zuerst muss ein Startort eingefuegt werden.");
        }

        if(startUndEnde){
            throw new IllegalArgumentException("Es ist bereits ein Endort hinzugefuegt");
        }

        if(name.equals("")){
            throw new IllegalArgumentException("Bitte geben Sie einen Endort ein!");
        }

        Ort temp_ort = new Ort(name, std, min, std, min, dp, dp, stationFlag);

        if(conObj.getListView().getItems().get((conObj.getListView().getItems().size()-1)).compareTo(temp_ort) != -1){
            throw new IllegalArgumentException("Der Ankunftszeitpunkt darf nicht vor dem letzten Abfahrtszeitpunkt liegen.");
        }

        conObj.getListView().getItems().add(temp_ort);
        startUndEnde = true;
        temp_ort.setIndex(conObj.getListView().getItems().indexOf(temp_ort));
    }

    /** Methode erstellt Zwischenstation und fuegt diese vor der ausgewaehlten Station ein*/
    public void zwischenStationDavorEinfuegen(LocalDate dpAnkunft, LocalDate dpAbfahrt, int stdAnk, int minAnk, int stdAbf,int minAbf, String name, int stationFlag, int index) throws Exception{
        indexInRange(index);

        if(conObj.getListView().getItems().get(index).getStationFlag() == 1){
            throw new IllegalArgumentException("Es kann keine Zwischenstation vor dem Startort eingefuegt werden.");
        }

        Ort temp_ort = new Ort(name, stdAnk, minAnk, stdAbf, minAbf, dpAnkunft, dpAbfahrt, stationFlag);

        checkUhrZeitDavor(temp_ort, index);

        conObj.getListView().getItems().add((index-1), temp_ort);

        conObj.updateIndex();
    }

    /** Methode erstellt Zwischenstation und fuegt diese nach der ausgewaehlten Station ein*/
    public void zwischenStationDanachEinfuegen(LocalDate dpAnkunft, LocalDate dpAbfahrt, int stdAnk, int minAnk, int stdAbf,int minAbf, String name, int stationFlag, int index) throws Exception{
        indexInRange(index);

        if(conObj.getListView().getItems().get(index).getStationFlag() == -1){
            throw new IllegalArgumentException("Es kann keine Zwischenstation hinter dem Endort eingefuegt werden.");
        }

        Ort temp_ort = new Ort(name, stdAnk, minAnk, stdAbf, minAbf, dpAnkunft, dpAbfahrt, stationFlag);

        checkUhrZeitDanach(temp_ort, index);

        conObj.getListView().getItems().add((index+1), temp_ort);

        conObj.updateIndex();
    }

    /** Methode erstellt Zwischenstation und tauscht diese mit der ausgewaehlten Station aus.*/
    public void changeZwischenStation(LocalDate dpAnkunft, LocalDate dpAbfahrt, int stdAnk, int minAnk, int stdAbf,int minAbf, String name, int stationFlag, int index) throws Exception{
        indexInRange(index);
        checkStationFlag(index);

        Ort temp_ort = new Ort(name, stdAnk, minAnk, stdAbf, minAbf, dpAnkunft, dpAbfahrt, stationFlag);

        if(conObj.getListView().getItems().get(index-1).compareTo(temp_ort) != -1){
            throw new IllegalArgumentException("Der Ankunftszeitpunkt darf nicht vor dem letzten Abfahrtszeitpunkt liegen. //Objekt dahinter");
        }

        if(temp_ort.compareTo(conObj.getListView().getItems().get(index+1)) != -1){
            throw new IllegalArgumentException("Der Ankunftszeitpunkt darf nicht vor dem letzten Abfahrtszeitpunkt liegen. //Objekt davor");
        }

        conObj.getListView().getItems().remove(index);
        conObj.getListView().getItems().add(index, temp_ort);
        conObj.updateIndex();
    }

    /** Methode berechnet Netto- und Bruttozeit der erstellten Reise.*/
    public void berechnenZeit() throws Exception {

        double aufenthaltsZeit = 0.0; // Aufenthaltzeit bei Zwischenstationen in Minuten
        Ort temp_start_ort = null;
        Ort temp_ende_ort = null;

        if (!startUndEnde) {
            throw new IllegalArgumentException("Es fehlt noch ein Start- oder Endort");
        }
        System.out.println();
        for (Iterator<Ort> iteratorListe = conObj.getListView().getItems().iterator(); iteratorListe.hasNext();) {
            Ort ort = iteratorListe.next();
            if (ort.getStationFlag() == 1) {
                temp_start_ort = ort;
            } else if (ort.getStationFlag() == -1) {
                temp_ende_ort = ort;
            } else if (ort.getStationFlag() == 0) {
                aufenthaltsZeit += zeitDifferenzRechner(ort, ort);
            }
        }
        bruttoZeit = zeitDifferenzRechner(temp_start_ort, temp_ende_ort);
        nettoZeit = bruttoZeit - aufenthaltsZeit;

        setLabel(bruttoZeit, nettoZeit);
    }

    /**Hilfsmethode, um Reisezeit zu berechnen.*/
    private double zeitDifferenzRechner(Ort ort1, Ort ort2) {

        double zeitTage = 0.0;
        double zeitStunden = 0.0;
        double zeitMinuten = 0.0;


        zeitTage = Math.abs((ChronoUnit.DAYS.between(ort1.getAbfahrt(), ort2.getAnkunft())) * 24 * 60);
        if(ort2.getStdAnkunft() == 0  ){
            zeitTage = zeitTage - 1440;
        }
        zeitStunden = Math.abs((ort1.getStdAnkunft() - ort2.getStdAbfahrt()) * 60);
        zeitMinuten = Math.abs((ort1.getMinAnkunft() - ort2.getMinAbfahrt()));
        return (zeitTage + zeitStunden + zeitMinuten);
    }

    /**Methode beschreibt Label fuer Reisezeit*/
    private void setLabel(double minutenBrutto, double minutenNetto){
        double stundenBrutto, stundenNetto, tageBrutto, tageNetto;

        /** Berechnen Minuten auf Stunden */
        stundenBrutto = (minutenBrutto/60);
        stundenNetto = (minutenNetto/60);

        /** Berechnen Stunden auf Tage */
        tageBrutto = (stundenBrutto/24);
        tageNetto = (stundenNetto/24);

        /** StringBuilder erstellt die darzustellenden Strings */
        StringBuilder strBrutto = new StringBuilder();
        strBrutto.append("Tage: ");
        strBrutto.append(tageBrutto);
        strBrutto.append(" | Stunden: ");
        strBrutto.append(stundenBrutto);
        strBrutto.append(" | Minuten: ");
        strBrutto.append(minutenBrutto);

        StringBuilder strNetto = new StringBuilder();
        strNetto.append("Tage: ");
        strNetto.append(tageNetto);
        strNetto.append(" | Stunden: ");
        strNetto.append(stundenNetto);
        strNetto.append(" | Minuten: ");
        strNetto.append(minutenNetto);

        conObj.getBruttoLabel().setText(strBrutto.toString());
        conObj.getNettoLabel().setText(strNetto.toString());
    }

    /** Ausgelagerte Hilfsmethoden, um Zeitangaben bei 'Zwischenstation davor einfuegen' zu pruefen. */
    private void checkUhrZeitDavor(Ort tempOrt, int index) throws Exception{
        if(conObj.getListView().getItems().get(index-1).compareTo(tempOrt) != -1){
            throw new IllegalArgumentException("Der Ankunftszeitpunkt darf nicht vor dem letzten Abfahrtszeitpunkt liegen. //Objekt dahinter");
        }

        if(tempOrt.compareTo(conObj.getListView().getItems().get(index)) != -1){
            throw new IllegalArgumentException("Der Ankunftszeitpunkt darf nicht vor dem letzten Abfahrtszeitpunkt liegen. //Objekt davor");
        }
    }

    /** Ausgelagerte Hilfsmethoden, um Zeitangaben bei 'Zwischenstation danach einfuegen' zu pruefen. */
    private void checkUhrZeitDanach(Ort tempOrt, int index) throws Exception{
        if(conObj.getListView().getItems().get(index).compareTo(tempOrt) != -1){
            throw new IllegalArgumentException("Der Ankunftszeitpunkt darf nicht vor dem letzten Abfahrtszeitpunkt liegen. //Objekt dahinter");
        }

        if(tempOrt.compareTo(conObj.getListView().getItems().get(index+1)) != -1){
            throw new IllegalArgumentException("Der Ankunftszeitpunkt darf nicht vor dem letzten Abfahrtszeitpunkt liegen. //Objekt davor");
        }
    }

    /**Hilfsmethode, um Index bei Zwischenstation einfuegen zu pruefen.*/
    private void indexInRange(int index) throws Exception{
        if((conObj.getListView().getItems().size()-1) < index){
            throw new ArrayIndexOutOfBoundsException("Der ist Ort nicht vorhanden");
        }
    }

    /**Hilfsmethode, um stationFlag bei Zwischenstation einfuegen zu pruefen.*/
    private void checkStationFlag(int index) throws Exception{
        if(conObj.getListView().getItems().get(index).getStationFlag() == 1){
            throw new IllegalArgumentException("Der Startort kann nicht ausgetauscht werden.");
        }

        if((conObj.getListView().getItems().get(index).getStationFlag() == -1)){
            throw new IllegalArgumentException("Der Endort kann nicht ausgetauscht werden.");
        }
    }
}
