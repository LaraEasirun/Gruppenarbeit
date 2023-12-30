package de.vivienseligerlaraspadin.lernquiz.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class KarteiContainer {
    private static KarteiContainer instance;
    private List<Karteikarte> karteikartenListe;

    private KarteiContainer() {
        karteikartenListe = new ArrayList<>();
        File file = new File("karteikarten.ser");
        if (file.exists() && !file.isDirectory()) {
        laden();
        }
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

    public void aktualisiereKarteikarte(Karteikarte alteKarte, Karteikarte neueKarte) {
        for (int i = 0; i < karteikartenListe.size(); i++) {
            Karteikarte vorhandeneKarte = karteikartenListe.get(i);
            // Hier verwenden wir die Frage als eindeutiges Attribut zur Identifikation der Karteikarte
            if (vorhandeneKarte.getFrage().equals(alteKarte.getFrage())) {
                karteikartenListe.set(i, neueKarte);
                break;
            }
        }
    }

    public void speichern() {
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("karteikarten.ser"))) {
        oos.writeObject(karteikartenListe);
    } catch (IOException e) {
        e.printStackTrace();
    }
}

public void laden() {
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("karteikarten.ser"))) {
        karteikartenListe = (List<Karteikarte>) ois.readObject();
    } catch (IOException | ClassNotFoundException e) {
        e.printStackTrace();
    }
}
}