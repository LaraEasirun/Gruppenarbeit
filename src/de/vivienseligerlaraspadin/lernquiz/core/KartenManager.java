package de.vivienseligerlaraspadin.lernquiz.core;

import java.util.List;

import de.vivienseligerlaraspadin.lernquiz.gui.KarteiEinsehen;

/**
 * Die Klasse "KartenManager" dient zur Verwaltung von Karteikarten und bietet Methoden zum Erstellen, Bearbeiten, Löschen und Anzeigen von Karteikarten.
 * Sie interagiert mit der GUI-Klasse "KarteiEinsehen" und dem Datencontainer "KarteiContainer".
 */
public class KartenManager {

    /**
     * Konstruktor für die Klasse "KartenManager".
     */
    public KartenManager() {
        // Konstruktor benötigt keine zusätzlichen Aktionen.
    }

    /**
     * Erstellt eine neue Karteikarte und fügt sie dem Karteikarten-Container hinzu.
     * Anschließend wird der Container gespeichert.
     *
     * @param frage            Die Frage für die neue Karteikarte.
     * @param antwort          Die Antwort für die neue Karteikarte.
     * @param kategorie        Die Kategorie für die neue Karteikarte.
     * @param schwierigkeitsgrad Der Schwierigkeitsgrad für die neue Karteikarte.
     * @param beherrscht       Der Beherrschtheitsstatus für die neue Karteikarte.
     */
    public void erstelleKarteikarte(String frage, String antwort, String kategorie, String schwierigkeitsgrad, boolean beherrscht) {
        Karteikarte neueKarte = new Karteikarte(frage, antwort, kategorie, schwierigkeitsgrad, beherrscht);
        KarteiContainer.getInstance().getKarteikartenListe().add(neueKarte);
        KarteiContainer.getInstance().speichern();
        System.out.println("Neue Karteikarte erstellt: " + neueKarte);
    }

    /**
     * Bearbeitet eine vorhandene Karteikarte anhand ihres Index in der Liste.
     * Die geänderten Informationen werden im Container aktualisiert, und dieser wird gespeichert.
     *
     * @param index             Der Index der zu bearbeitenden Karteikarte.
     * @param neueFrage         Die neue Frage für die Karteikarte.
     * @param neueAntwort       Die neue Antwort für die Karteikarte.
     * @param neueKategorie     Die neue Kategorie für die Karteikarte.
     * @param neuerSchwierigkeitsgrad Der neue Schwierigkeitsgrad für die Karteikarte.
     * @param beherrscht        Der neue Beherrschtheitsstatus für die Karteikarte.
     */
    public static void bearbeiteKarteikarte(int index, String neueFrage, String neueAntwort, String neueKategorie, String neuerSchwierigkeitsgrad, boolean beherrscht) {
        List<Karteikarte> kartenListe = KarteiContainer.getInstance().getKarteikartenListe();
        if (index >= 0 && index < kartenListe.size()) {
            Karteikarte zuBearbeiten = kartenListe.get(index);
            zuBearbeiten.setFrage(neueFrage);
            zuBearbeiten.setAntwort(neueAntwort);
            zuBearbeiten.setKategorie(neueKategorie);
            zuBearbeiten.setSchwierigkeitsgrad(neuerSchwierigkeitsgrad);
            zuBearbeiten.setBeherrscht(beherrscht);
            KarteiContainer.getInstance().speichern();
            System.out.println("Karteikarte aktualisiert: " + zuBearbeiten);
        } else {
            System.out.println("Karteikarte konnte nicht bearbeitet werden");
            KarteiContainer.getInstance().speichern();
        }
    }

    /**
     * Gibt die ausgewählte Karteikarte aus der GUI zurück.
     *
     * @return Die ausgewählte Karteikarte aus der GUI.
     */
    public static Karteikarte getRow() {
        int selectedRow = KarteiEinsehen.karteikartenTabelle.getSelectedRow();
        if (selectedRow >= 0) {
            String frage = (String) KarteiEinsehen.karteikartenTabelle.getValueAt(selectedRow, 0);
            String antwort = (String) KarteiEinsehen.karteikartenTabelle.getValueAt(selectedRow, 1);
            String kategorie = (String) KarteiEinsehen.karteikartenTabelle.getValueAt(selectedRow, 2);
            String schwierigkeitsgrad = (String) KarteiEinsehen.karteikartenTabelle.getValueAt(selectedRow, 3);

            // Erstellen Sie eine neue Karteikarte mit den ausgelesenen Werten
            Karteikarte karteikarte = new Karteikarte(frage, antwort, kategorie, schwierigkeitsgrad, false);

            return karteikarte;
        }

        return null;
    }

    /**
     * Löscht eine Karteikarte anhand ihres Index in der Liste.
     * Die Änderungen werden im Container gespeichert.
     *
     * @param index Der Index der zu löschenden Karteikarte.
     */
    public static void loescheKarteikarte(int index) {
        List<Karteikarte> kartenListe = KarteiContainer.getInstance().getKarteikartenListe();
        if (index >= 0 && index < kartenListe.size()) {
            kartenListe.remove(index);
            KarteiContainer.getInstance().speichern();
            System.out.println("Karteikarte gelöscht.");
        } else {
            System.out.println("Karteikarte konnte nicht gelöscht werden");
        }
    }

    /**
     * Gibt alle Karteikarten aus dem Karteikarten-Container zurück.
     *
     * @return Eine Liste aller Karteikarten.
     */
    public static List<Karteikarte> zeigeAlleKarteikarten() {
        return KarteiContainer.getInstance().getKarteikartenListe();
    }

    /**
     * Aktualisiert die GUI, indem ein neues Fenster für die Anzeige der Karteikarten erstellt wird.
     */
    public static void reloadWindows() {
        KarteiEinsehen karteiEinsehen = new KarteiEinsehen();
    }
}
