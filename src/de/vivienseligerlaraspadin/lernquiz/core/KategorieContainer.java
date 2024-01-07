package de.vivienseligerlaraspadin.lernquiz.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Die Klasse "KategorieContainer" verwaltet eine Liste von Kategorien und bietet Methoden zum Hinzufügen, Löschen und Abrufen von Kategorien.
 * Sie implementiert das Serializable-Interface, um die Serialisierung von Objekten zu ermöglichen.
 */
public class KategorieContainer implements Serializable {
    private static KategorieContainer instance; // Die einzige Instanz dieser Klasse
    private List<String> kategorien; // Liste der Kategorien

    /**
     * Konstruktor für die Klasse "KategorieContainer".
     * Initialisiert die Liste der Kategorien und lädt vorhandene Kategorien aus einer Serialisierungsdatei, falls vorhanden.
     * Wenn die Datei nicht existiert, wird sie beim ersten Start erstellt und gespeichert.
     */
    public KategorieContainer() {
        kategorien = new ArrayList<>();

        File file = new File("kategorien.ser");
        if (file.exists() && !file.isDirectory()) {
            laden(); // Kategorien aus einer Serialisierungsdatei laden, falls vorhanden
        } else {
            speichern(); // Speichern beim ersten Start, wenn die Datei noch nicht existiert
        }
    }

    /**
     * Fügt eine neue Kategorie zur Liste der Kategorien hinzu und speichert die Änderungen.
     *
     * @param kategorie Die hinzuzufügende Kategorie.
     */
    public void kategorieHinzufuegen(String kategorie) {
        if (!kategorien.contains(kategorie)) {
            kategorien.add(kategorie);
            speichern();
        }
    }

    /**
     * Löscht eine vorhandene Kategorie aus der Liste der Kategorien und speichert die Änderungen.
     *
     * @param kategorie Die zu löschende Kategorie.
     */
    public void kategorieLoeschen(String kategorie) {
        kategorien.remove(kategorie);
        speichern();
    }

    /**
     * Gibt eine Kopie der Liste der Kategorien zurück, um die Kapselung zu wahren.
     *
     * @return Eine Kopie der Liste der Kategorien.
     */
    public List<String> getKategorien() {
        return new ArrayList<>(kategorien);
    }

    /**
     * Setzt die Liste der Kategorien auf eine neue Liste (Kopie der übergebenen Liste) und speichert die Änderungen.
     *
     * @param neueKategorien Die neue Liste der Kategorien.
     */
    public void setKategorien(List<String> neueKategorien) {
        this.kategorien = new ArrayList<>(neueKategorien);
        speichern(); // Speichern nach dem Setzen der Kategorienliste
    }

    /**
     * Speichert die Liste der Kategorien in einer Serialisierungsdatei.
     */
    public void speichern() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("kategorien.ser"))) {
            oos.writeObject(kategorien);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Lädt die Liste der Kategorien aus einer Serialisierungsdatei.
     */
    public void laden() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("kategorien.ser"))) {
            kategorien = (List<String>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Gibt die einzige Instanz dieser Klasse zurück oder erstellt sie, falls sie noch nicht existiert.
     *
     * @return Die Instanz der Klasse "KategorieContainer".
     */
    public static KategorieContainer getInstance() {
        if (instance == null) {
            instance = new KategorieContainer();
        }
        return instance;
    }
}
