package de.vivienseligerlaraspadin.lernquiz.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Die Klasse "Hauptmenue" erstellt ein Hauptmenüfenster für die Karteikarten-Lernanwendung.
 * Sie bietet Schaltflächen, um verschiedene Funktionen der Anwendung aufzurufen, wie das Einsehen von Karteikarten,
 * das Lernen/Abfragen von Karteikarten, das Verwalten von Kategorien, das Anzeigen der Auswertung und das Beenden des Programms.
 */
public class Hauptmenue extends JFrame {

    private JPanel contentPane;

    /**
     * Konstruktor für die Klasse "Hauptmenue". Erstellt das Hauptmenüfenster mit den verschiedenen Schaltflächen.
     */
    public Hauptmenue() {
        setTitle("StudySmarter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 379);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        GridBagLayout gbl_contentPane = new GridBagLayout();
        gbl_contentPane.columnWidths = new int[] { 162, 85, 162, 0 };
        gbl_contentPane.rowHeights = new int[] { 31, 13, 38, 21, 21, 21, 33, 21, 73, 13, 0 };
        gbl_contentPane.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
        gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
                Double.MIN_VALUE };
        contentPane.setLayout(gbl_contentPane);

        JLabel lblNewLabel = new JLabel("Herzlich Willkommen bei deiner Karteikarten Lernapp!");
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.anchor = GridBagConstraints.NORTH;
        gbc_lblNewLabel.fill = GridBagConstraints.HORIZONTAL;
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel.gridx = 1;
        gbc_lblNewLabel.gridy = 1;
        contentPane.add(lblNewLabel, gbc_lblNewLabel);

        // Schaltfläche zum Einsehen von Karteikarten
        JButton btnKarteikartenEinsehen = new JButton("Karteikarte einsehen");
        btnKarteikartenEinsehen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                KarteiEinsehen karteiEinsehen = new KarteiEinsehen();
                karteiEinsehen.setVisible(true);
            }
        });
        GridBagConstraints gbc_btnKarteikartenEinsehen = new GridBagConstraints();
        gbc_btnKarteikartenEinsehen.anchor = GridBagConstraints.NORTH;
        gbc_btnKarteikartenEinsehen.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnKarteikartenEinsehen.insets = new Insets(0, 50, 5, 50);
        gbc_btnKarteikartenEinsehen.gridx = 1;
        gbc_btnKarteikartenEinsehen.gridy = 3;
        contentPane.add(btnKarteikartenEinsehen, gbc_btnKarteikartenEinsehen);

        // Schaltfläche zum Lernen/Abfragen von Karteikarten
        JButton btnKarteikartenLernen = new JButton("Karteikarten lernen/abfragen");
        btnKarteikartenLernen.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                KarteiAbfragen karteiAbfragen = new KarteiAbfragen();
                karteiAbfragen.setVisible(true);
            }
        });
        GridBagConstraints gbc_btnKarteikartenLernen = new GridBagConstraints();
        gbc_btnKarteikartenLernen.anchor = GridBagConstraints.NORTH;
        gbc_btnKarteikartenLernen.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnKarteikartenLernen.insets = new Insets(0, 50, 5, 50);
        gbc_btnKarteikartenLernen.gridx = 1;
        gbc_btnKarteikartenLernen.gridy = 4;
        contentPane.add(btnKarteikartenLernen, gbc_btnKarteikartenLernen);

        // Schaltfläche zum Verwalten von Kategorien
        JButton btnKategorien = new JButton("Kategorien");
        btnKategorien.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                KategorieEinsehen kategorieEinsehen = new KategorieEinsehen();
                kategorieEinsehen.setVisible(true);
            }
        });
        GridBagConstraints gbc_btnKategorien = new GridBagConstraints();
        gbc_btnKategorien.anchor = GridBagConstraints.NORTH;
        gbc_btnKategorien.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnKategorien.insets = new Insets(0, 50, 5, 50);
        gbc_btnKategorien.gridx = 1;
        gbc_btnKategorien.gridy = 5;
        contentPane.add(btnKategorien, gbc_btnKategorien);

        // Schaltfläche zur Anzeige der Auswertung
        JButton btnAuswertung = new JButton("Auswertung");
        btnAuswertung.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Auswertung();
            }
        });
        GridBagConstraints gbc_btnAuswertung = new GridBagConstraints();
        gbc_btnAuswertung.anchor = GridBagConstraints.NORTH;
        gbc_btnAuswertung.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnAuswertung.insets = new Insets(0, 50, 5, 50);
        gbc_btnAuswertung.gridx = 1;
        gbc_btnAuswertung.gridy = 6;
        contentPane.add(btnAuswertung, gbc_btnAuswertung);

        // Schaltfläche zum Beenden des Programms
        JButton btnProgrammBeenden = new JButton("Programm beenden");
        btnProgrammBeenden.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Beende das Programm
            }
        });
        GridBagConstraints gbc_btnProgrammBeenden = new GridBagConstraints();
        gbc_btnProgrammBeenden.anchor = GridBagConstraints.NORTH;
        gbc_btnProgrammBeenden.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnProgrammBeenden.insets = new Insets(0, 50, 5, 50);
        gbc_btnProgrammBeenden.gridx = 1;
        gbc_btnProgrammBeenden.gridy = 8;
        contentPane.add(btnProgrammBeenden, gbc_btnProgrammBeenden);

        JLabel lblNewLabel_1 = new JLabel("© Vivien Seliger, Lara Spadin - v1.0");
        GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
        gbc_lblNewLabel_1.insets = new Insets(0, 0, 0, 5);
        gbc_lblNewLabel_1.anchor = GridBagConstraints.NORTH;
        gbc_lblNewLabel_1.gridx = 1;
        gbc_lblNewLabel_1.gridy = 9;
        contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);

        // Zentriere das Fenster auf dem Bildschirm
        this.setLocationRelativeTo(null);
        setVisible(true);
    }
}
