package de.vivienseligerlaraspadin.lernquiz.core;

import java.util.List;

import de.vivienseligerlaraspadin.lernquiz.core.*;
import de.vivienseligerlaraspadin.lernquiz.gui.KarteiEinsehen;



public class KartenManager {
    

    public KartenManager() {
        
    }

    public void erstelleKarteikarte(String frage, String antwort, String kategorie, String schwierigkeit) {
        Karteikarte neueKarte = new Karteikarte(frage, antwort, kategorie, schwierigkeit);
        KarteiContainer.getInstance().getKarteikartenListe().add(neueKarte);
        KarteiContainer.getInstance().speichern();
        System.out.println("Neue Karteikarte erstellt: " + neueKarte);
    }

    public static void bearbeiteKarteikarte(int index, String neueFrage, String neueAntwort, String neueKategorie, String neuerSchwierigkeit) {
        List<Karteikarte> kartenListe = KarteiContainer.getInstance().getKarteikartenListe();
        if (index >= 0 && index < kartenListe.size()) {
            Karteikarte zuBearbeiten = kartenListe.get(index);
            zuBearbeiten.setFrage(neueFrage);
            zuBearbeiten.setAntwort(neueAntwort);
            zuBearbeiten.setKategorie(neueKategorie);
            zuBearbeiten.setSchwierigkeit(neuerSchwierigkeit);
            KarteiContainer.getInstance().speichern();
            System.out.println("Karteikarte aktualisiert: " + zuBearbeiten);
        } else {
            System.out.println("Konnte nicht bearbeitet werden");
            KarteiContainer.getInstance().speichern();
        }
    }

    public static Karteikarte getRow() {
        int selectedRow = KarteiEinsehen.karteikartenTabelle.getSelectedRow();
        if (selectedRow >= 0) {
            String frage = (String) KarteiEinsehen.karteikartenTabelle.getValueAt(selectedRow, 0);
            String antwort = (String) KarteiEinsehen.karteikartenTabelle.getValueAt(selectedRow, 1);
            String kategorie = (String) KarteiEinsehen.karteikartenTabelle.getValueAt(selectedRow, 2);
            String schwierigkeitsgrad = (String) KarteiEinsehen.karteikartenTabelle.getValueAt(selectedRow, 3);
    
            // Erstellen Sie eine neue Karteikarte mit den ausgelesenen Werten
            Karteikarte karteikarte = new Karteikarte(frage, antwort, kategorie, schwierigkeitsgrad);
    
            return karteikarte;
        }
    
        return null;
    }

    public static void loescheKarteikarte(int index) {
        List<Karteikarte> kartenListe = KarteiContainer.getInstance().getKarteikartenListe();
        if (index >= 0 && index < kartenListe.size()) {
            kartenListe.remove(index);
            KarteiContainer.getInstance().speichern();
            System.out.println("Karteikarte geloescht.");
        } else {
            System.out.println("Karteikarte konnte nicht geloescht werden");
        }
    }

    public static List<Karteikarte> zeigeAlleKarteikarten() {
        return KarteiContainer.getInstance().getKarteikartenListe();
    }

    public static void reloadWindows() {
        KarteiEinsehen karteiEinsehen = new KarteiEinsehen();
    }
}