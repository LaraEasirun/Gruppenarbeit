package de.vivienseligerlaraspadin.lernquiz.gui;


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import javax.swing.JPanel;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;

public class Hauptmenue implements ActionListener {

    JFrame frame = new JFrame("Willkommen bei deiner Karteikarten Lernapp");
    JButton btnKarteikartenEinsehen = new JButton("Karteikarten einsehen");
    JButton btnKategorien = new JButton("Kategorien");
    JButton btnKarteikartenLernen = new JButton("Karteikarten lernen/abfragen");
    private final JButton btnNewButton = new JButton("Programm beenden");
    
    Hauptmenue (){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        GridBagConstraints gbcButtons = new GridBagConstraints();
        gbcButtons.fill = GridBagConstraints.HORIZONTAL;
        gbcButtons.insets = new Insets(5, 5, 5, 5);
        gbcButtons.gridx = 1;
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[]{1, 69, 278, 76, 0};
        gridBagLayout.rowHeights = new int[]{1, 58, 16, 103, 29, 29, 29, 35, 29, 0, 0};
        gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        frame.getContentPane().setLayout(gridBagLayout);
           
           JPanel buttonPanel = new JPanel(new GridBagLayout());
           GridBagConstraints gbc_buttonPanel = new GridBagConstraints();
           gbc_buttonPanel.anchor = GridBagConstraints.NORTHWEST;
           gbc_buttonPanel.insets = new Insets(0, 0, 5, 5);
           gbc_buttonPanel.gridx = 0;
           gbc_buttonPanel.gridy = 0;
           frame.getContentPane().add(buttonPanel, gbc_buttonPanel);
        
        JLabel lblTitle = new JLabel("Willkommen bei deiner Karteikarten Lernapp");
        GridBagConstraints gbc_lblTitle = new GridBagConstraints();
        gbc_lblTitle.anchor = GridBagConstraints.NORTH;
        gbc_lblTitle.insets = new Insets(0, 0, 5, 5);
        gbc_lblTitle.gridx = 2;
        gbc_lblTitle.gridy = 2;
        frame.getContentPane().add(lblTitle, gbc_lblTitle);
        GridBagConstraints gbc_btnKarteikartenEinsehen = new GridBagConstraints();
        gbc_btnKarteikartenEinsehen.insets = new Insets(0, 0, 5, 5);
        gbc_btnKarteikartenEinsehen.gridx = 2;
        gbc_btnKarteikartenEinsehen.gridy = 4;
        frame.getContentPane().add(btnKarteikartenEinsehen, gbc_btnKarteikartenEinsehen);
        
        btnKarteikartenEinsehen.addActionListener(this);
        GridBagConstraints gbc_btnKarteikartenLernen = new GridBagConstraints();
        gbc_btnKarteikartenLernen.anchor = GridBagConstraints.NORTH;
        gbc_btnKarteikartenLernen.insets = new Insets(0, 0, 5, 5);
        gbc_btnKarteikartenLernen.gridx = 2;
        gbc_btnKarteikartenLernen.gridy = 5;
        frame.getContentPane().add(btnKarteikartenLernen, gbc_btnKarteikartenLernen);
        GridBagConstraints gbc_btnKategorien = new GridBagConstraints();
        gbc_btnKategorien.insets = new Insets(0, 0, 5, 5);
        gbc_btnKategorien.gridx = 2;
        gbc_btnKategorien.gridy = 6;
        frame.getContentPane().add(btnKategorien, gbc_btnKategorien);
        GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
        gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
        gbc_btnNewButton.gridx = 2;
        gbc_btnNewButton.gridy = 8;
        frame.getContentPane().add(btnNewButton, gbc_btnNewButton);
        
        frame.setVisible(true);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnKarteikartenEinsehen) {
            frame.dispose();
			KarteiEinsehen karteiEinsehen = new KarteiEinsehen();
			karteiEinsehen.setVisible(true);
		}
	}
}

