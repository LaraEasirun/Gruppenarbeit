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

public class KategorieContainer implements Serializable {
	private static KategorieContainer instance;
	private List<String> kategorien;

	public KategorieContainer() {
		kategorien = new ArrayList<>();

		File file = new File("kategorien.ser");
		if (file.exists() && !file.isDirectory()) {
			laden();
		} else {
			speichern();
		}
	}

	public void kategorieHinzufuegen(String kategorie) {
		if (!kategorien.contains(kategorie)) {
			kategorien.add(kategorie);
			speichern();
		}
	}

	public void kategorieLoeschen(String kategorie) {
		kategorien.remove(kategorie);
		speichern();
	}

	public List<String> getKategorien() {
		return new ArrayList<>(kategorien);
	}

	public void setKategorien(List<String> neueKategorien) {
		this.kategorien = new ArrayList<>(neueKategorien);
		speichern(); // Speichern nach dem Setzen der Kategorienliste
	}

	public void speichern() {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("kategorien.ser"))) {
			oos.writeObject(kategorien);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void laden() {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("kategorien.ser"))) {
			kategorien = (List<String>) ois.readObject();
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static KategorieContainer getInstance() {
		if (instance == null) {
			instance = new KategorieContainer();
		}
		return instance;
	}
}