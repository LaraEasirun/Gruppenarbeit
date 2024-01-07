package de.vivienseligerlaraspadin.lernquiz.gui;

import javax.swing.*;

import de.vivienseligerlaraspadin.lernquiz.core.Abfrage;
import de.vivienseligerlaraspadin.lernquiz.core.KarteiContainer;
import de.vivienseligerlaraspadin.lernquiz.core.Karteikarte;
import de.vivienseligerlaraspadin.lernquiz.core.KartenManager;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KarteiAbfragen extends JFrame {
	private JLabel frageLabel;
	private JLabel antwortLabel;
	private JButton antwortButton;
	private JButton naechsteButton;
	private JButton hauptmenueButton; 
	private JButton kannIchButton;
	private JButton kannIchNichtButton;
	public Abfrage abfrage;

	public KarteiAbfragen() {
		//abfrage = new Abfrage();
		abfrage = Abfrage.getInstance();
		setTitle("Kartei Lernen");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(332, 311);
		setLocationRelativeTo(null); 
		getContentPane().setLayout(new BorderLayout());

		// Hauptmenü-Button
		hauptmenueButton = new JButton("Hauptmenü");
		hauptmenueButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Hauptmenue();
			}
		});

		Abfrage.getInstance().zieheZufaelligeKarteikarte();

		kannIchButton = new JButton("Kann ich");
		kannIchButton.addActionListener(new ActionListener() {
    	@Override
    	public void actionPerformed(ActionEvent e) {
        	Karteikarte aktuelleKarte = Abfrage.getInstance().getAktuelleKarteikarte();
        		if (aktuelleKarte != null) {
            		KartenManager.bearbeiteKarteikarte(
                	KarteiContainer.getInstance().getKarteikartenListe().indexOf(aktuelleKarte),
                	aktuelleKarte.getFrage(),
                	aktuelleKarte.getAntwort(),
                	aktuelleKarte.getKategorie(),
                	aktuelleKarte.getSchwierigkeitsgrad(),
                	true
            );
            // Ziehen Sie die nächste Karteikarte
            Karteikarte naechsteKarte = Abfrage.getInstance().zieheZufaelligeKarteikarte();
            // Aktualisieren Sie die Anzeige mit der nächsten Karteikarte
        }
    }
});

		kannIchNichtButton = new JButton("Kann ich nicht");
		kannIchNichtButton.addActionListener(new ActionListener() {
    		@Override
    		public void actionPerformed(ActionEvent e) {
        	Karteikarte aktuelleKarte = Abfrage.getInstance().getAktuelleKarteikarte();
        	if (aktuelleKarte != null) {
            	KartenManager.bearbeiteKarteikarte(
                	KarteiContainer.getInstance().getKarteikartenListe().indexOf(aktuelleKarte),
                	aktuelleKarte.getFrage(),
                	aktuelleKarte.getAntwort(),
                	aktuelleKarte.getKategorie(),
                	aktuelleKarte.getSchwierigkeitsgrad(),
                	false
            	);
            // Ziehen Sie die nächste Karteikarte
            Karteikarte naechsteKarte = Abfrage.getInstance().zieheZufaelligeKarteikarte();
            // Aktualisieren Sie die Anzeige mit der nächsten Karteikarte
        }
    }
});

		naechsteButton = new JButton("Nächste");
		naechsteButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Karteikarte naechsteKarte = abfrage.zieheZufaelligeKarteikarte();
				if (naechsteKarte != null) {
					frageLabel.setText("Frage: " + naechsteKarte.getFrage());
					antwortLabel.setText("Antwort: " + naechsteKarte.getAntwort());
					antwortLabel.setVisible(false);
				}
			}
		});

		JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		topPanel.add(hauptmenueButton);

		JPanel middlePanel = new JPanel();
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.CENTER;
		GridBagLayout gbl_middlePanel = new GridBagLayout();
		gbl_middlePanel.columnWidths = new int[] { 44, 85, 154, 58, 0 };
		gbl_middlePanel.rowHeights = new int[] { 38, 29, 0, 0, 0, 0 };
		gbl_middlePanel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_middlePanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		middlePanel.setLayout(gbl_middlePanel);

		JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		bottomPanel.add(naechsteButton);
		bottomPanel.add(kannIchButton);
		bottomPanel.add(kannIchNichtButton);

		getContentPane().add(topPanel, BorderLayout.NORTH);
		getContentPane().add(middlePanel, BorderLayout.CENTER);

		getContentPane().add(topPanel, BorderLayout.NORTH);
		getContentPane().add(middlePanel, BorderLayout.CENTER);
		getContentPane().add(bottomPanel, BorderLayout.SOUTH);

		frageLabel = new JLabel("Frage: ");
		GridBagConstraints gbc_frageLabel = new GridBagConstraints();
		gbc_frageLabel.insets = new Insets(0, 0, 5, 5);
		gbc_frageLabel.gridx = 1;
		gbc_frageLabel.gridy = 0;
		middlePanel.add(frageLabel, gbc_frageLabel);

		antwortButton = new JButton("Antwort anzeigen");
		antwortButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				antwortLabel.setVisible(true); // Antwort anzeigen, wenn der Button gedrückt wird
			}
		});
		antwortLabel = new JLabel("Antwort: ");
		antwortLabel.setVisible(false); // Antwort ist zunächst nicht sichtbar
		GridBagConstraints gbc_antwortLabel = new GridBagConstraints();
		gbc_antwortLabel.insets = new Insets(0, 0, 5, 5);
		gbc_antwortLabel.gridx = 1;
		gbc_antwortLabel.gridy = 3;
		middlePanel.add(antwortLabel, gbc_antwortLabel);

		GridBagConstraints gbc_antwortButton = new GridBagConstraints();
		gbc_antwortButton.insets = new Insets(0, 0, 5, 5);
		gbc_antwortButton.gridx = 2;
		gbc_antwortButton.gridy = 3;
		middlePanel.add(antwortButton, gbc_antwortButton);
		getContentPane().add(bottomPanel, BorderLayout.SOUTH);

		setVisible(true);
	}

}