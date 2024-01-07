package de.vivienseligerlaraspadin.lernquiz.core;

	import java.util.ArrayList;
	import java.util.List;
	import java.util.Random;

	public class Abfrage {
	    private List<Karteikarte> karteikarten;
	    private List<String> benutzerantworten;
		private KarteiContainer karteiContainer;
		private static Abfrage instance;
		private Karteikarte aktuelleKarteikarte;

	    public Abfrage() {
	        karteikarten = new ArrayList<>();
	        benutzerantworten = new ArrayList<>();
			this.karteiContainer = KarteiContainer.getInstance();
	    }

	    public void karteikarteHinzufuegen(Karteikarte karteikarte) {
	        karteikarten.add(karteikarte);
	    }

	    public Karteikarte zieheZufaelligeKarteikarte() {
			List<Karteikarte> karteikarten = karteiContainer.getKarteikartenListe();
			if (!karteikarten.isEmpty()) {
				int index = new Random().nextInt(karteikarten.size());
				aktuelleKarteikarte = karteikarten.get(index);
				return aktuelleKarteikarte;
			}
			return null;
		}

		public Karteikarte getAktuelleKarteikarte() {
			return aktuelleKarteikarte;
		}

	    public void antwortHinzufuegen(String antwort) {
	        benutzerantworten.add(antwort);
	    }

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


		public List<Karteikarte> getKarteikarten() {
			return new ArrayList<>(karteikarten); // Gibt eine Kopie der Liste zurück, um die Kapselung zu wahren
		}
		
		public void setKarteikarten(List<Karteikarte> neueKarteikarten) {
			this.karteikarten = new ArrayList<>(neueKarteikarten); // Erstellt eine Kopie der übergebenen Liste
		}

		public static Abfrage getInstance() {
			if (instance == null) {
				instance = new Abfrage();
			}
			return instance;
		}
		
	}
