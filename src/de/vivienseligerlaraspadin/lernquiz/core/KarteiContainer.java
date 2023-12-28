package de.vivienseligerlaraspadin.lernquiz.core;

import java.util.ArrayList;
import java.util.List;

public class KarteiContainer {
    private static KarteiContainer instance;
    private List<Karteikarte> karteikartenListe;

    private KarteiContainer() {
        karteikartenListe = new ArrayList<>();
    }

    public static KarteiContainer getInstance() {
        if (instance == null) {
            instance = new KarteiContainer();
        }
        return instance;
    }

    public List<Karteikarte> getKarteikartenListe() {
        return karteikartenListe;
    }

}

