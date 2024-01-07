package de.vivienseligerlaraspadin.lernquiz.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Die Klasse "Abfrage" repräsentiert den Kern des Lernquiz-Systems. Sie
 * verwaltet Karteikarten, Benutzerantworten und führt Abfragen durch.
 */
public class Abfrage {
	private List<Karteikarte> karteikarten; // Liste der Karteikarten
	private List<String> benutzerantworten; // Liste der vom Benutzer gegebenen Antworten
	private KarteiContainer karteiContainer; // Ein Container für Karteikarten
	private static Abfrage instance; // Die einzige Instanz dieser Klasse
	private Karteikarte aktuelleKarteikarte; // Die aktuelle Karteikarte in der Abfrage

	/**
	 * Konstruktor für die Klasse "Abfrage". Initialisiert die Listen und den
	 * Karteikarten-Container.
	 */
	public Abfrage() {
		karteikarten = new ArrayList<>();
		benutzerantworten = new ArrayList<>();
		this.karteiContainer = KarteiContainer.getInstance();
	}

	/**
	 * Fügt eine Karteikarte zur Liste der Karteikarten hinzu.
	 *
	 * @param karteikarte Die hinzuzufügende Karteikarte.
	 */
	public void karteikarteHinzufuegen(Karteikarte karteikarte) {
		karteikarten.add(karteikarte);
	}

	/**
	 * Zieht zufällig eine Karteikarte aus dem Karteikarten-Container.
	 *
	 * @return Die zufällig ausgewählte Karteikarte oder null, wenn keine verfügbar
	 *         sind.
	 */
	public Karteikarte zieheZufaelligeKarteikarte() {
		List<Karteikarte> karteikarten = karteiContainer.getKarteikartenListe();
		if (!karteikarten.isEmpty()) {
			int index = new Random().nextInt(karteikarten.size());
			aktuelleKarteikarte = karteikarten.get(index);
			return aktuelleKarteikarte;
		}
		return null;
	}

	/**
	 * Gibt die aktuelle Karteikarte zurück.
	 *
	 * @return Die aktuelle Karteikarte.
	 */
	public Karteikarte getAktuelleKarteikarte() {
		return aktuelleKarteikarte;
	}

	/**
	 * Fügt eine Benutzerantwort zur Liste der Benutzerantworten hinzu.
	 *
	 * @param antwort Die hinzuzufügende Benutzerantwort.
	 */
	public void antwortHinzufuegen(String antwort) {
		benutzerantworten.add(antwort);
	}

	/**
	 * Bewertet die Abfrage, indem die Benutzerantworten mit den Karteikarten
	 * verglichen werden.
	 *
	 * @return Die Anzahl der korrekten Antworten.
	 */
	public int auswertenAbfrage() {
		int korrekteAntworten = 0;
		int minSize = Math.min(karteikarten.size(), benutzerantworten.size());

		for (int i = 0; i < minSize; i++) {
			Karteikarte karteikarte = karteikarten.get(i);
			String benutzerantwort = benutzerantworten.get(i);
			if (karteikarte.getAntwort().equalsIgnoreCase(benutzerantwort)) {
				korrekteAntworten++;
			}
		}

		return korrekteAntworten;
	}

	/**
	 * Gibt eine Kopie der Liste der Karteikarten zurück, um die Kapselung zu
	 * wahren.
	 *
	 * @return Eine Kopie der Liste der Karteikarten.
	 */
	public List<Karteikarte> getKarteikarten() {
		return new ArrayList<>(karteikarten);
	}

	/**
	 * Setzt die Liste der Karteikarten auf eine neue Liste (Kopie der übergebenen
	 * Liste).
	 *
	 * @param neueKarteikarten Die neue Liste der Karteikarten.
	 */
	public void setKarteikarten(List<Karteikarte> neueKarteikarten) {
		this.karteikarten = new ArrayList<>(neueKarteikarten);
	}

	/**
	 * Gibt die einzige Instanz dieser Klasse zurück oder erstellt sie, falls sie
	 * noch nicht existiert.
	 *
	 * @return Die Instanz der Klasse "Abfrage".
	 */
	public static Abfrage getInstance() {
		if (instance == null) {
			instance = new Abfrage();
		}
		return instance;
	}
}
