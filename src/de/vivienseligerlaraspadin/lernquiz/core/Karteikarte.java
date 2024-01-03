package de.vivienseligerlaraspadin.lernquiz.core;

import java.io.Serializable;

public class Karteikarte implements Serializable {
	private String frage;
	private String antwort;
	private String kategorie;
	private String schwierigkeit;

	public Karteikarte(String frage, String antwort, String kategorie, String schwierigkeit) {
		this.frage = frage;
		this.antwort = antwort;
		this.kategorie = kategorie;
		this.schwierigkeit = schwierigkeit;
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

	public String getSchwierigkeit() {
		return schwierigkeit;
	}

	public void setSchwierigkeit(String schwierigkeit) {
		this.schwierigkeit = schwierigkeit;
	}
}
