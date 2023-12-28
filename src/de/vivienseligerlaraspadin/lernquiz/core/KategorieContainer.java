package de.vivienseligerlaraspadin.lernquiz.core;

import java.util.ArrayList;
import java.util.List;

public class KategorieContainer {
    private List<String> kategorien;

    public KategorieContainer() {
        kategorien = new ArrayList<>();
        kategorien.add("Mathematik");
        kategorien.add("Biologie");
        kategorien.add("Informatik");
         kategorien.add("Chemie");
          kategorien.add("Deutsch");
           kategorien.add("Englisch");
    }

    public void kategorieHinzufuegen(String kategorie) {
        if (!kategorien.contains(kategorie)) {
            kategorien.add(kategorie);
        }
    }

    public void kategorieLoeschen(String kategorie) {
        kategorien.remove(kategorie);
    }

    public List<String> getKategorien() {
        return new ArrayList<>(kategorien);
    }
}

