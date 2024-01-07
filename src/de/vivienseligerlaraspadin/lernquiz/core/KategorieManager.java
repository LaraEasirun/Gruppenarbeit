package de.vivienseligerlaraspadin.lernquiz.core;

import java.util.ArrayList;
import java.util.List;

/**
 * Die Klasse "KategorieManager" bietet Methoden zur Verwaltung von Kategorien und interagiert mit dem "KategorieContainer".
 */
public class KategorieManager {
    private static KategorieContainer kategorieContainer; // Container für die Kategorien

    static {
        kategorieContainer = new KategorieContainer(); // Initialisieren beim Laden der Klasse
    }

    /**
     * Konstruktor für die Klasse "KategorieManager".
     */
    public KategorieManager() {
        // Konstruktor benötigt keine zusätzlichen Aktionen.
    }

    /**
     * Fügt eine neue Kategorie hinzu und speichert die Änderungen im Container.
     *
     * @param kategorie Die hinzuzufügende Kategorie.
     */
    public void kategorieHinzufuegen(String kategorie) {
        kategorieContainer.kategorieHinzufuegen(kategorie);
        kategorieContainer.speichern();
    }

    /**
     * Löscht eine vorhandene Kategorie und speichert die Änderungen im Container.
     *
     * @param kategorie Die zu löschende Kategorie.
     */
    public void kategorieLoeschen(String kategorie) {
        kategorieContainer.kategorieLoeschen(kategorie);
        kategorieContainer.speichern();
    }

    /**
     * Ändert den Namen einer vorhandenen Kategorie und speichert die Änderungen im Container.
     *
     * @param alteKategorie Die zu ändernde Kategorie.
     * @param neueKategorie Die neue Bezeichnung für die Kategorie.
     */
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

    /**
     * Gibt eine Liste aller Kategorien zurück.
     *
     * @return Eine Liste aller Kategorien.
     */
    public static List<String> getKategorien() {
        return kategorieContainer.getKategorien();
    }

    /**
     * Gibt alle Kategorien aus.
     */
    public void zeigeAlleKategorien() {
        for (String kategorie : kategorieContainer.getKategorien()) {
            System.out.println(kategorie);
        }
    }

    /**
     * Gibt den "KategorieContainer" zurück.
     *
     * @return Der "KategorieContainer".
     */
    public static KategorieContainer getKategorieContainer() {
        return kategorieContainer;
    }
}
