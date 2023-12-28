package de.vivienseligerlaraspadin.lernquiz.core;


import java.util.List;

public class KartenManager {
    

    public KartenManager() {
        
    }

    public void erstelleKarteikarte(String frage, String antwort, String kategorie, String schwierigkeitsgrad) {
        Karteikarte neueKarte = new Karteikarte(frage, antwort, kategorie, schwierigkeitsgrad);
        KarteiContainer.getInstance().getKarteikartenListe().add(neueKarte);
        System.out.println("Neue Karteikarte erstellt: " + neueKarte);
    }

    public void bearbeiteKarteikarte(int index, String neueFrage, String neueAntwort, String neueKategorie, String neuerSchwierigkeitsgrad) {
        List<Karteikarte> kartenListe = KarteiContainer.getInstance().getKarteikartenListe();
        if (index >= 0 && index < kartenListe.size()) {
            Karteikarte zuBearbeiten = kartenListe.get(index);
            zuBearbeiten.setFrage(neueFrage);
            zuBearbeiten.setAntwort(neueAntwort);
            zuBearbeiten.setKategorie(neueKategorie);
            zuBearbeiten.setSchwierigkeit(neuerSchwierigkeitsgrad);
            System.out.println("Karteikarte aktualisiert: " + zuBearbeiten);
        } else {
            System.out.println("Konnte nicht bearbeitet werden");
        }
    }

    public void loescheKarteikarte(int index) {
        List<Karteikarte> kartenListe = KarteiContainer.getInstance().getKarteikartenListe();
        if (index >= 0 && index < kartenListe.size()) {
            kartenListe.remove(index);
            System.out.println("Karteikarte geloescht.");
        } else {
            System.out.println("Karteikarte konnte nicht geloescht werden");
        }
    }

    public static List<Karteikarte> zeigeAlleKarteikarten() {
        return KarteiContainer.getInstance().getKarteikartenListe();
    }

    
}

