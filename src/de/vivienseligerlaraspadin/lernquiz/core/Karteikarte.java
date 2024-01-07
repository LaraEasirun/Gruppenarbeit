package de.vivienseligerlaraspadin.lernquiz.core;

import java.io.Serializable;

public class Karteikarte implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String frage;
    private String antwort;
    private String kategorie;
    private String schwierigkeitsgrad;
    private boolean beherrscht;

    public Karteikarte(String frage, String antwort, String kategorie, String schwierigkeitsgrad, boolean beherrscht) {
        this.frage = frage;
        this.antwort = antwort;
        this.kategorie = kategorie;
        this.schwierigkeitsgrad = schwierigkeitsgrad;
        this.beherrscht = beherrscht;
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

    public String getSchwierigkeitsgrad() {
        return schwierigkeitsgrad;
    }

    public void setSchwierigkeitsgrad(String schwierigkeitsgrad) {
        this.schwierigkeitsgrad = schwierigkeitsgrad;
    }

    public void setBeherrscht(boolean beherrscht) {
        this.beherrscht = beherrscht;
    }

    public boolean getBeherrscht() {
        return this.beherrscht;
    }
}
