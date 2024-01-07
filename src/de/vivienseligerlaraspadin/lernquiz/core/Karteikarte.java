package de.vivienseligerlaraspadin.lernquiz.core;

import java.io.Serializable;

/**
 * Die Klasse "Karteikarte" repräsentiert eine einzelne Karteikarte mit einer Frage, einer Antwort, einer Kategorie, einem Schwierigkeitsgrad und einem Beherrschtheitsstatus.
 * Sie implementiert das Serializable-Interface, um die Serialisierung von Objekten zu ermöglichen.
 */
public class Karteikarte implements Serializable {
    private static final long serialVersionUID = 1L; // Versionsnummer für die Serialisierung

    private String frage; // Die Frage auf der Karteikarte
    private String antwort; // Die Antwort auf die Frage
    private String kategorie; // Die Kategorie, zu der die Karteikarte gehört
    private String schwierigkeitsgrad; // Der Schwierigkeitsgrad der Karteikarte
    private boolean beherrscht; // Der Beherrschtheitsstatus der Karteikarte

    /**
     * Konstruktor für die Klasse "Karteikarte".
     *
     * @param frage            Die Frage auf der Karteikarte.
     * @param antwort          Die Antwort auf die Frage.
     * @param kategorie        Die Kategorie, zu der die Karteikarte gehört.
     * @param schwierigkeitsgrad Der Schwierigkeitsgrad der Karteikarte.
     * @param beherrscht       Der Beherrschtheitsstatus der Karteikarte.
     */
    public Karteikarte(String frage, String antwort, String kategorie, String schwierigkeitsgrad, boolean beherrscht) {
        this.frage = frage;
        this.antwort = antwort;
        this.kategorie = kategorie;
        this.schwierigkeitsgrad = schwierigkeitsgrad;
        this.beherrscht = beherrscht;
    }

    /**
     * Gibt die Frage auf der Karteikarte zurück.
     *
     * @return Die Frage auf der Karteikarte.
     */
    public String getFrage() {
        return frage;
    }

    /**
     * Setzt die Frage auf der Karteikarte.
     *
     * @param frage Die zu setzende Frage.
     */
    public void setFrage(String frage) {
        this.frage = frage;
    }

    /**
     * Gibt die Antwort auf die Frage zurück.
     *
     * @return Die Antwort auf die Frage.
     */
    public String getAntwort() {
        return antwort;
    }

    /**
     * Setzt die Antwort auf die Frage.
     *
     * @param antwort Die zu setzende Antwort.
     */
    public void setAntwort(String antwort) {
        this.antwort = antwort;
    }

    /**
     * Gibt die Kategorie zurück, zu der die Karteikarte gehört.
     *
     * @return Die Kategorie der Karteikarte.
     */
    public String getKategorie() {
        return kategorie;
    }

    /**
     * Setzt die Kategorie der Karteikarte.
     *
     * @param kategorie Die zu setzende Kategorie.
     */
    public void setKategorie(String kategorie) {
        this.kategorie = kategorie;
    }

    /**
     * Gibt den Schwierigkeitsgrad der Karteikarte zurück.
     *
     * @return Der Schwierigkeitsgrad der Karteikarte.
     */
    public String getSchwierigkeitsgrad() {
        return schwierigkeitsgrad;
    }

    /**
     * Setzt den Schwierigkeitsgrad der Karteikarte.
     *
     * @param schwierigkeitsgrad Der zu setzende Schwierigkeitsgrad.
     */
    public void setSchwierigkeitsgrad(String schwierigkeitsgrad) {
        this.schwierigkeitsgrad = schwierigkeitsgrad;
    }

    /**
     * Setzt den Beherrschtheitsstatus der Karteikarte.
     *
     * @param beherrscht Der zu setzende Beherrschtheitsstatus.
     */
    public void setBeherrscht(boolean beherrscht) {
        this.beherrscht = beherrscht;
    }

    /**
     * Gibt den Beherrschtheitsstatus der Karteikarte zurück.
     *
     * @return Der Beherrschtheitsstatus der Karteikarte.
     */
    public boolean getBeherrscht() {
        return this.beherrscht;
    }
}
