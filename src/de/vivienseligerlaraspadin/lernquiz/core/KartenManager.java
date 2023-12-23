package de.vivienseligerlaraspadin.lernquiz.core;

import java.util.ArrayList;
import java.util.List;

public class KartenManager {
    private List<Karteikarte> kartenListe;

    public KartenManager() {
        kartenListe = new ArrayList<>();
    }

    public void erstelleKarteikarte(String frage, String antwort, String kategorie, int schwierigkeitsgrad) {
        Karteikarte neueKarte = new Karteikarte(frage, antwort, kategorie, schwierigkeitsgrad);
        kartenListe.add(neueKarte);
        System.out.println("Neue Karteikarte erstellt: " + neueKarte);
    }

    public void bearbeiteKarteikarte(int index, String neueFrage, String neueAntwort, String neueKategorie, int neuerSchwierigkeitsgrad) {
        if (index >= 0 && index < kartenListe.size()) {
            Karteikarte zuBearbeiten = kartenListe.get(index);
            zuBearbeiten.setFrage(neueFrage);
            zuBearbeiten.setAntwort(neueAntwort);
            zuBearbeiten.setKategorie(neueKategorie);
            zuBearbeiten.setSchwierigkeitsgrad(neuerSchwierigkeitsgrad);
            System.out.println("Karteikarte aktualisiert: " + zuBearbeiten);
        } else {
            System.out.println("Ungültiger Index");
        }
    }

    public void loescheKarteikarte(int index) {
        if (index >= 0 && index < kartenListe.size()) {
            kartenListe.remove(index);
            System.out.println("Karteikarte gelöscht.");
        } else {
            System.out.println("Ungültiger Index");
        }
    }

    // Weitere Methoden, wie zum Beispiel zum Verschieben von Karteikarten, können hier hinzugefügt werden.

    // Methode zum Anzeigen aller Karteikarten
    public void zeigeAlleKarteikarten() {
        for (Karteikarte karte : kartenListe) {
            System.out.println(karte);
        }
    }
}
