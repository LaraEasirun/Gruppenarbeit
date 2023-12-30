package de.vivienseligerlaraspadin.lernquiz.core;

import java.util.List;

public class KategorieManager {
    private KategorieContainer kategorieContainer;

    public KategorieManager() {
        kategorieContainer = new KategorieContainer();
    }

    public void kategorieHinzufuegen(String kategorie) {
        kategorieContainer.kategorieHinzufuegen(kategorie);
    }

    public void kategorieLoeschen(String kategorie) {
        kategorieContainer.kategorieLoeschen(kategorie);
    }

    public List<String> getKategorien() {
        return kategorieContainer.getKategorien();
    }
}