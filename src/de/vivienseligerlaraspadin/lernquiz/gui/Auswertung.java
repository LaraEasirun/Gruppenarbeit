package de.vivienseligerlaraspadin.lernquiz.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import de.vivienseligerlaraspadin.lernquiz.core.KarteiContainer;
import de.vivienseligerlaraspadin.lernquiz.core.Karteikarte;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

/**
 * Die Klasse "Auswertung" erstellt ein Fenster zur Anzeige der Auswertung des Lernstands.
 * Sie berechnet den Prozentsatz der beherrschten Karteikarten und zeigt ihn in einem JFrame an.
 * Der Benutzer kann das Fenster schließen und zum Hauptmenü zurückkehren.
 */
public class Auswertung {

    /**
     * Konstruktor für die Klasse "Auswertung". Erstellt das Auswertungsfenster und zeigt den Lernstand an.
     */
    public Auswertung() {
        // Erstelle ein neues JFrame
        final JFrame frame = new JFrame("Auswertung");
        frame.setSize(471, 211);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Berechne den Lernstand
        List<Karteikarte> karteikarten = KarteiContainer.getInstance().getKarteikartenListe();
        int beherrschteKarten = 0;
        for (Karteikarte karte : karteikarten) {
            if (karte.getBeherrscht()) {
                beherrschteKarten++;
            }
        }
        int gesamtKarten = karteikarten.size();
        double prozent = (double) beherrschteKarten / gesamtKarten * 100;

        // Erstelle ein GridBagLayout für die Komponenten im Fenster
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[] { 0, 0, 109, 169, 142, 0, 0 };
        gridBagLayout.rowHeights = new int[] { 60, 0, 29, 0, 0, 0, 0 };
        gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE, 0.0 };
        gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
        frame.getContentPane().setLayout(gridBagLayout);

        // Erstelle den "OK" Button
        JButton okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                new Hauptmenue();
            }
        });

        // Erstelle das JLabel zur Anzeige des Lernstands
        JLabel label = new JLabel(
                String.format("Du beherrschst bereits %d von %d Karteikarten.\nDas entspricht %.2f%%!",
                        beherrschteKarten, gesamtKarten, prozent),
                SwingConstants.CENTER);

        // Definiere die Position der Komponenten im GridBagLayout
        GridBagConstraints gbc_label = new GridBagConstraints();
        gbc_label.gridwidth = 5;
        gbc_label.insets = new Insets(0, 0, 5, 5);
        gbc_label.gridx = 1;
        gbc_label.gridy = 1;
        frame.getContentPane().add(label, gbc_label);

        GridBagConstraints gbc_okButton = new GridBagConstraints();
        gbc_okButton.insets = new Insets(0, 0, 5, 5);
        gbc_okButton.anchor = GridBagConstraints.NORTH;
        gbc_okButton.fill = GridBagConstraints.HORIZONTAL;
        gbc_okButton.gridx = 3;
        gbc_okButton.gridy = 4;
        frame.getContentPane().add(okButton, gbc_okButton);

        // Positioniere das Fenster in der Mitte des Bildschirms
        frame.setLocationRelativeTo(null);

        // Zeige das Fenster an
        frame.setVisible(true);
    }
}
