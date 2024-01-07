package de.vivienseligerlaraspadin.lernquiz.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Die Klasse "KarteiContainer" verwaltet eine Liste von Karteikarten und
 * ermöglicht das Speichern und Laden dieser Karteikarten. Sie implementiert das
 * Singleton-Muster, um sicherzustellen, dass nur eine Instanz der Klasse
 * existiert.
 */
public class KarteiContainer {
	private static KarteiContainer instance; // Die einzige Instanz dieser Klasse
	private List<Karteikarte> karteikartenListe; // Liste der Karteikarten

	/**
	 * Privater Konstruktor für die Klasse "KarteiContainer". Initialisiert die
	 * Liste der Karteikarten und lädt vorhandene Karteikarten aus einer
	 * Serialisierungsdatei, falls vorhanden.
	 */
	private KarteiContainer() {
		karteikartenListe = new ArrayList<>();
		File file = new File("karteikarten.ser");
		if (file.exists() && !file.isDirectory()) {
			laden(); // Karteikarten aus einer Serialisierungsdatei laden, falls vorhanden
		}
	}

	/**
	 * Gibt die einzige Instanz der Klasse "KarteiContainer" zurück oder erstellt
	 * sie, falls sie noch nicht existiert.
	 *
	 * @return Die Instanz der Klasse "KarteiContainer".
	 */
	public static KarteiContainer getInstance() {
		if (instance == null) {
			instance = new KarteiContainer();
		}
		return instance;
	}

	/**
	 * Gibt die Liste der Karteikarten zurück.
	 *
	 * @return Die Liste der Karteikarten.
	 */
	public List<Karteikarte> getKarteikartenListe() {
		return karteikartenListe;
	}

	/**
	 * Speichert die Liste der Karteikarten in einer Serialisierungsdatei.
	 */
	public void speichern() {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("karteikarten.ser"))) {
			oos.writeObject(karteikartenListe);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Lädt die Liste der Karteikarten aus einer Serialisierungsdatei.
	 */
	public void laden() {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("karteikarten.ser"))) {
			karteikartenListe = (List<Karteikarte>) ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
