package de.vivienseligerlaraspadin.lernquiz.core;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


public class Karteikarte {
	private String frage;
    private String antwort;
    private String kategorie;
    private int schwierigkeitsgrad;

    public Karteikarte(String frage, String antwort, String kategorie, int schwierigkeitsgrad) {
        this.frage = frage;
        this.antwort = antwort;
        this.kategorie = kategorie;
        this.schwierigkeitsgrad = schwierigkeitsgrad;
    }

    public String getFrage() {
        return frage;
    }

    public void setFrage(String frage) {
        this.frage = frage;
    }

    public String getAntwort() {
        return antwort;
    }

    public void setAntwort(String antwort) {
        this.antwort = antwort;
    }

    public String getKategorie() {
        return kategorie;
    }

    public void setKategorie(String kategorie) {
        this.kategorie = kategorie;
    }

    public int getSchwierigkeitsgrad() {
        return schwierigkeitsgrad;
    }

    public void setSchwierigkeitsgrad(int schwierigkeitsgrad) {
        this.schwierigkeitsgrad = schwierigkeitsgrad;
    }
}

