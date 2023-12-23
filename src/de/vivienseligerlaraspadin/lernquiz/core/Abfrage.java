package de.vivienseligerlaraspadin.lernquiz.core;

	import java.util.ArrayList;
	import java.util.List;
	import java.util.Random;

	public class Abfrage {
	    private List<Karteikarte> karteikarten;
	    private List<String> benutzerantworten;

	    public Abfrage() {
	        karteikarten = new ArrayList<>();
	        benutzerantworten = new ArrayList<>();
	    }

	    public void karteikarteHinzufuegen(Karteikarte karteikarte) {
	        karteikarten.add(karteikarte);
	    }

	    public Karteikarte zieheZufaelligeKarteikarte() {
	        if (!karteikarten.isEmpty()) {
	            Random random = new Random();
	            int index = random.nextInt(karteikarten.size());
	            return karteikarten.get(index);
	        }
	        return null;
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
	}


