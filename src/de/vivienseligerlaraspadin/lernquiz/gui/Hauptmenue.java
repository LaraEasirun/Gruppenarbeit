package de.vivienseligerlaraspadin.lernquiz.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Hauptmenue implements ActionListener {

    JFrame frame = new JFrame("StudySmarter");
    JButton btnKarteikartenEinsehen = new JButton("Karteikarten einsehen");
    JButton btnKategorien = new JButton("Kategorien");
    JButton btnKarteikartenLernen = new JButton("Karteikarten lernen/abfragen");
    JButton btnProgrammBeenden = new JButton("Programm beenden");

    Hauptmenue() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 336, 0, 0, 0};
        frame.getContentPane().setLayout(gridBagLayout);

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        int frameWidth = frame.getSize().width;
        int frameHeight = frame.getSize().height;
        int x = (screenWidth - frameWidth) / 2;
        int y = (screenHeight - frameHeight) / 2;
        frame.setLocation(x, y);

        GridBagConstraints gbcButtons = new GridBagConstraints();
        gbcButtons.fill = GridBagConstraints.HORIZONTAL;
        gbcButtons.insets = new Insets(5, 5, 5, 5);
        gbcButtons.gridx = 1;

        Box.Filler fillerTop = new Box.Filler(new Dimension(0, 0), new Dimension(0, 0), new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
        GridBagConstraints gbc_fillerTop = new GridBagConstraints();
        gbc_fillerTop.gridx = 4;
        gbc_fillerTop.gridy = 0; // Starten Sie das Füll-Element ganz oben
        gbc_fillerTop.weighty = 1.0; // Lassen Sie das Füll-Element den zusätzlichen vertikalen Platz einnehmen
        gbc_fillerTop.fill = GridBagConstraints.VERTICAL; // Lassen Sie das Füll-Element vertikal expandieren
        frame.getContentPane().add(fillerTop, gbc_fillerTop);

        JPanel buttonPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc_buttonPanel = new GridBagConstraints();
        gbc_buttonPanel.anchor = GridBagConstraints.NORTHWEST;
        gbc_buttonPanel.insets = new Insets(0, 0, 5, 5);
        gbc_buttonPanel.gridx = 0;
        gbc_buttonPanel.gridy = 0;
        frame.getContentPane().add(buttonPanel, gbc_buttonPanel);
        
        JLabel lblTitle = new JLabel("Herzlich Willkommen bei deiner Karteikarten Lernapp!");
        GridBagConstraints gbc_lblTitle = new GridBagConstraints();
        gbc_lblTitle.gridwidth = 5;
        gbc_lblTitle.anchor = GridBagConstraints.NORTH;
        gbc_lblTitle.insets = new Insets(5, 5, 60, 5);
        gbc_lblTitle.gridx = 2;
        gbc_lblTitle.gridy = 1;
        frame.getContentPane().add(lblTitle, gbc_lblTitle);

        GridBagConstraints gbc_btnKarteikartenEinsehen = new GridBagConstraints();
        gbc_btnKarteikartenEinsehen.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnKarteikartenEinsehen.insets = new Insets(0, 50, 5, 50);
        gbc_btnKarteikartenEinsehen.gridx = 4;
        gbc_btnKarteikartenEinsehen.gridy = 4;
        gbc_btnKarteikartenEinsehen.weightx = 1.0;
        gbc_btnKarteikartenEinsehen.weighty = 0.0;
        frame.getContentPane().add(btnKarteikartenEinsehen, gbc_btnKarteikartenEinsehen);

        btnKarteikartenEinsehen.addActionListener(this);

        GridBagConstraints gbc_btnKarteikartenLernen = new GridBagConstraints();
        gbc_btnKarteikartenLernen.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnKarteikartenLernen.insets = new Insets(0, 50, 5, 50);
        gbc_btnKarteikartenLernen.gridx = 4;
        gbc_btnKarteikartenLernen.gridy = 5;
        gbc_btnKarteikartenLernen.weightx = 1.0;
        gbc_btnKarteikartenLernen.weighty = 0.0;
        frame.getContentPane().add(btnKarteikartenLernen, gbc_btnKarteikartenLernen);

        GridBagConstraints gbc_btnKategorien = new GridBagConstraints();
        gbc_btnKategorien.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnKategorien.insets = new Insets(0, 50, 5, 50);
        gbc_btnKategorien.gridx = 4;
        gbc_btnKategorien.gridy = 6;
        gbc_btnKategorien.weightx = 1.0;
        gbc_btnKategorien.weighty = 0.0;
        frame.getContentPane().add(btnKategorien, gbc_btnKategorien);

        GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
        gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
        gbc_btnNewButton.insets = new Insets(0, 50, 0, 50);
        gbc_btnNewButton.gridx = 4;
        gbc_btnNewButton.gridy = 8;
        gbc_btnNewButton.weightx = 1.0;
        gbc_btnNewButton.weighty = 0.0;
        frame.getContentPane().add(btnProgrammBeenden, gbc_btnNewButton);

        // Erstellen Sie das JPanel und setzen Sie das Layout auf BorderLayout
        JPanel panel = new JPanel(new BorderLayout());
        GridBagConstraints gbc_panel = new GridBagConstraints();
        gbc_panel.gridx = 4;
        gbc_panel.gridy = 9;
        gbc_panel.weightx = 1.0; // Lassen Sie das JPanel die gesamte Breite einnehmen
        gbc_panel.weighty = 1.0; // Lassen Sie das JPanel den gesamten verbleibenden vertikalen Platz einnehmen
        gbc_panel.fill = GridBagConstraints.VERTICAL; // Lassen Sie das JPanel den gesamten verfügbaren Platz einnehmen
        frame.getContentPane().add(panel, gbc_panel);

        // Erstellen Sie das JLabel und fügen Sie es zum JPanel hinzu
        JLabel lblVersion = new JLabel("v1.0.1 - © Lara Spadin", SwingConstants.CENTER);
        panel.add(lblVersion, BorderLayout.PAGE_END); // Fügen Sie das JLabel am unteren Rand des JPanel hinzu

        frame.setVisible(true);

        btnKarteikartenLernen.addActionListener(this);
        btnProgrammBeenden.addActionListener(this);
        btnKategorien.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnKarteikartenEinsehen) {
            frame.dispose();
            KarteiEinsehen karteiEinsehen = new KarteiEinsehen();
            karteiEinsehen.setVisible(true);
        } else if (e.getSource() == btnKarteikartenLernen) {
            frame.dispose();
            KarteiAbfragen karteiAbfragen = new KarteiAbfragen();
            karteiAbfragen.setVisible(true);
        } else if (e.getSource() == btnKategorien) {
            frame.dispose();
            KategorieEinsehen kategorieEinsehen = new KategorieEinsehen();
            kategorieEinsehen.setVisible(true);
        } else if (e.getSource() == btnProgrammBeenden) {
             System.exit(0); // Exit the program
        }
    }
}