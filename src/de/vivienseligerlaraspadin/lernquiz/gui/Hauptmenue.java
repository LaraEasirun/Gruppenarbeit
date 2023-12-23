package de.vivienseligerlaraspadin.lernquiz.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Hauptmenue implements ActionListener {

    JFrame frame = new JFrame("Willkommen bei deiner Karteikarten Lernapp");
    JButton btnKarteikartenEinsehen = new JButton("Karteikarten einsehen");
    JButton btnKategorien = new JButton("Kategorien");
    JButton btnKarteikartenLernen = new JButton("Karteikarten lernen/abfragen");
    
    Hauptmenue (){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(new GridBagLayout());
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        JLabel lblTitle = new JLabel("Willkommen bei deiner Karteikarten Lernapp");
        gbc.insets = new Insets(10, 0, 20, 0);
        frame.add(lblTitle, gbc);
        
        JPanel buttonPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbcButtons = new GridBagConstraints();
        gbcButtons.fill = GridBagConstraints.HORIZONTAL;
        gbcButtons.insets = new Insets(5, 5, 5, 5);
        
        gbcButtons.gridx = 0;
        gbcButtons.gridy = 0;
        buttonPanel.add(btnKarteikartenEinsehen, gbcButtons);
        
        gbcButtons.gridx = 1;
        gbcButtons.gridy = 0;
        buttonPanel.add(btnKategorien, gbcButtons);
        
        gbc.gridx = 0;
        gbc.gridy = 1;
        frame.add(buttonPanel, gbc);
        
        gbc.gridy = 2;
        gbc.insets = new Insets(10, 0, 0, 0);
        frame.add(btnKarteikartenLernen, gbc);
        
        btnKarteikartenEinsehen.addActionListener(this);
        
        frame.setVisible(true);
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnKarteikartenEinsehen) {
			frame.dispose();
			new KarteiEinsehen();
		}
	}
}

