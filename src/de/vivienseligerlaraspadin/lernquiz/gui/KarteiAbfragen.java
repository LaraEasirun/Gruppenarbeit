package de.vivienseligerlaraspadin.lernquiz.gui;

import javax.swing.*;

import de.vivienseligerlaraspadin.lernquiz.core.*;

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
		
		abfrage = Abfrage.getInstance();
		setTitle("Kartei Lernen");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(522, 311);
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

		JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		topPanel.add(hauptmenueButton);

		JPanel middlePanel = new JPanel();
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridwidth = GridBagConstraints.REMAINDER;
		gbc.fill = GridBagConstraints.HORIZONTAL;
		gbc.anchor = GridBagConstraints.CENTER;
		GridBagLayout gbl_middlePanel = new GridBagLayout();
		gbl_middlePanel.columnWidths = new int[] { 44, 170, 138, 151, 0 };
		gbl_middlePanel.rowHeights = new int[] { 38, 29, 0, 0, 0, 0, 0, 0 };
		gbl_middlePanel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_middlePanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		middlePanel.setLayout(gbl_middlePanel);

		JPanel bottomPanel = new JPanel();
		GridBagLayout gbl_bottomPanel = new GridBagLayout();
		gbl_bottomPanel.columnWidths = new int[]{94, 95, 98, 134, 0};
		gbl_bottomPanel.rowHeights = new int[]{29, 0};
		gbl_bottomPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_bottomPanel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		bottomPanel.setLayout(gbl_bottomPanel);
				
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
						GridBagConstraints gbc_kannIchButton = new GridBagConstraints();
						gbc_kannIchButton.fill = GridBagConstraints.HORIZONTAL;
						gbc_kannIchButton.anchor = GridBagConstraints.NORTH;
						gbc_kannIchButton.insets = new Insets(0, 0, 0, 5);
						gbc_kannIchButton.gridx = 0;
						gbc_kannIchButton.gridy = 0;
						bottomPanel.add(kannIchButton, gbc_kannIchButton);
						
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
            
            Karteikarte naechsteKarte = Abfrage.getInstance().zieheZufaelligeKarteikarte();
        }
    }
});
								GridBagConstraints gbc_kannIchNichtButton = new GridBagConstraints();
								gbc_kannIchNichtButton.fill = GridBagConstraints.HORIZONTAL;
								gbc_kannIchNichtButton.insets = new Insets(0, 0, 0, 5);
								gbc_kannIchNichtButton.anchor = GridBagConstraints.NORTH;
								gbc_kannIchNichtButton.gridx = 1;
								gbc_kannIchNichtButton.gridy = 0;
								bottomPanel.add(kannIchNichtButton, gbc_kannIchNichtButton);

		getContentPane().add(topPanel, BorderLayout.NORTH);
		getContentPane().add(middlePanel, BorderLayout.CENTER);

		getContentPane().add(topPanel, BorderLayout.NORTH);
		getContentPane().add(middlePanel, BorderLayout.CENTER);
		getContentPane().add(bottomPanel, BorderLayout.SOUTH);
		
	    frageLabel = new JLabel("Frage: ");
	    GridBagConstraints gbc_frageLabel = new GridBagConstraints();
		gbc_frageLabel.anchor = GridBagConstraints.WEST;
	    gbc_frageLabel.gridwidth = 3;
		gbc_frageLabel.insets = new Insets(0, 0, 5, 5);
		gbc_frageLabel.gridx = 1;
		gbc_frageLabel.gridy = 1;
		middlePanel.add(frageLabel, gbc_frageLabel);
				
		antwortLabel = new JLabel("Antwort: ");
		antwortLabel.setVisible(false); // Antwort ist zunächst nicht sichtbar
		GridBagConstraints gbc_antwortLabel = new GridBagConstraints();
		gbc_antwortLabel.gridwidth = 3;
		gbc_antwortLabel.anchor = GridBagConstraints.WEST;
		gbc_antwortLabel.insets = new Insets(0, 0, 5, 5);
		gbc_antwortLabel.gridx = 1;
		gbc_antwortLabel.gridy = 4;
		middlePanel.add(antwortLabel, gbc_antwortLabel);
														
		antwortButton = new JButton("Antwort anzeigen");
	    antwortButton.addActionListener(new ActionListener() {
																	
		@Override
	    public void actionPerformed(ActionEvent e) {
		antwortLabel.setVisible(true); // Antwort anzeigen, wenn der Button gedrückt wird
		}
		});
																
		GridBagConstraints gbc_antwortButton = new GridBagConstraints();
		gbc_antwortButton.insets = new Insets(0, 0, 5, 5);
		gbc_antwortButton.gridx = 2;
		gbc_antwortButton.gridy = 5;
		middlePanel.add(antwortButton, gbc_antwortButton);
		getContentPane().add(bottomPanel, BorderLayout.SOUTH);
		
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
				
				GridBagConstraints gbc_naechsteButton = new GridBagConstraints();
				gbc_naechsteButton.fill = GridBagConstraints.HORIZONTAL;
				gbc_naechsteButton.anchor = GridBagConstraints.NORTH;
				gbc_naechsteButton.gridx = 3;
				gbc_naechsteButton.gridy = 0;
				bottomPanel.add(naechsteButton, gbc_naechsteButton);

		setVisible(true);
	}

}