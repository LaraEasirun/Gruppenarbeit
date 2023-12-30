package de.vivienseligerlaraspadin.lernquiz.gui;


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.FlowLayout;

public class Hauptmenue implements ActionListener {

    JFrame frame = new JFrame("StudySmarter");
    JButton btnKarteikartenEinsehen = new JButton("Karteikarten einsehen");
    JButton btnKategorien = new JButton("Kategorien");
    JButton btnKarteikartenLernen = new JButton("Karteikarten lernen/abfragen");
    JButton btnProgrammBeenden = new JButton("Programm beenden");

    Hauptmenue() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 392);
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
                gbc_lblTitle.insets = new Insets(0, 0, 5, 5);
                gbc_lblTitle.gridx = 2;
                gbc_lblTitle.gridy = 1;
                frame.getContentPane().add(lblTitle, gbc_lblTitle);

        GridBagConstraints gbc_btnKarteikartenEinsehen = new GridBagConstraints();
        gbc_btnKarteikartenEinsehen.insets = new Insets(0, 0, 5, 5);
        gbc_btnKarteikartenEinsehen.gridx = 4;
        gbc_btnKarteikartenEinsehen.gridy = 4;
        gbc_btnKarteikartenEinsehen.weightx = 1.0;
        gbc_btnKarteikartenEinsehen.weighty = 0.0; // Set weighty to 0.0 to prevent vertical expansion
        gbc_btnKarteikartenEinsehen.fill = GridBagConstraints.HORIZONTAL; // Use HORIZONTAL fill
        frame.getContentPane().add(btnKarteikartenEinsehen, gbc_btnKarteikartenEinsehen);

        btnKarteikartenEinsehen.addActionListener(this);

        GridBagConstraints gbc_btnKarteikartenLernen = new GridBagConstraints();
        gbc_btnKarteikartenLernen.anchor = GridBagConstraints.NORTH;
        gbc_btnKarteikartenLernen.insets = new Insets(0, 0, 5, 5);
        gbc_btnKarteikartenLernen.gridx = 4;
        gbc_btnKarteikartenLernen.gridy = 5;
        gbc_btnKarteikartenLernen.weightx = 1.0;
        gbc_btnKarteikartenLernen.weighty = 0.0; // Set weighty to 0.0 to prevent vertical expansion
        gbc_btnKarteikartenLernen.fill = GridBagConstraints.HORIZONTAL; // Use HORIZONTAL fill
        frame.getContentPane().add(btnKarteikartenLernen, gbc_btnKarteikartenLernen);

        GridBagConstraints gbc_btnKategorien = new GridBagConstraints();
        gbc_btnKategorien.insets = new Insets(0, 0, 5, 5);
        gbc_btnKategorien.gridx = 4;
        gbc_btnKategorien.gridy = 6;
        gbc_btnKategorien.weightx = 1.0;
        gbc_btnKategorien.weighty = 0.0; // Set weighty to 0.0 to prevent vertical expansion
        gbc_btnKategorien.fill = GridBagConstraints.HORIZONTAL; // Use HORIZONTAL fill
        frame.getContentPane().add(btnKategorien, gbc_btnKategorien);

        GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
        gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
        gbc_btnNewButton.gridx = 4;
        gbc_btnNewButton.gridy = 8;
        gbc_btnNewButton.weightx = 1.0;
        gbc_btnNewButton.weighty = 0.0; // Set weighty to 0.0 to prevent vertical expansion
        gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL; // Use HORIZONTAL fill
        frame.getContentPane().add(btnProgrammBeenden, gbc_btnNewButton);

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