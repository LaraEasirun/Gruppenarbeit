package de.vivienseligerlaraspadin.lernquiz.core;
import java.util.ArrayList;
import java.util.List;

public class KategorieManager {
    private static KategorieContainer kategorieContainer;

    static {
        kategorieContainer = new KategorieContainer(); // Initialisieren beim Laden der Klasse
    }

    public KategorieManager() {
    }

    public void kategorieHinzufuegen(String kategorie) {
        kategorieContainer.kategorieHinzufuegen(kategorie);
        kategorieContainer.speichern();
    }
    
    public void kategorieLoeschen(String kategorie) {
        kategorieContainer.kategorieLoeschen(kategorie);
        kategorieContainer.speichern();
    }
    
    public void kategorieAendern(String alteKategorie, String neueKategorie) {
        if (!kategorieContainer.getKategorien().contains(neueKategorie)) {
            List<String> neueListe = new ArrayList<>();
            for (String kategorie : kategorieContainer.getKategorien()) {
                if (kategorie.equals(alteKategorie)) {
                    neueListe.add(neueKategorie);
                } else {
                    neueListe.add(kategorie);
                }
            }
            kategorieContainer.setKategorien(neueListe);
            kategorieContainer.speichern();
        }
    }

    public static List<String> getKategorien() {
        return kategorieContainer.getKategorien();
    }

    public void zeigeAlleKategorien() {
        for (String kategorie : kategorieContainer.getKategorien()) {
            System.out.println(kategorie);
        }
    }

    public static KategorieContainer getKategorieContainer() {
        return kategorieContainer;
    }
}