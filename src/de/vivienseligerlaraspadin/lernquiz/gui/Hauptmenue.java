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
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 1, 40, 52, 217, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 1, 62, 16, 36, 29, 29, 29, 35, 29, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		frame.getContentPane().setLayout(gridBagLayout);

		JPanel buttonPanel = new JPanel(new GridBagLayout());
		GridBagConstraints gbc_buttonPanel = new GridBagConstraints();
		gbc_buttonPanel.anchor = GridBagConstraints.NORTHWEST;
		gbc_buttonPanel.insets = new Insets(0, 0, 5, 5);
		gbc_buttonPanel.gridx = 0;
		gbc_buttonPanel.gridy = 0;
		frame.getContentPane().add(buttonPanel, gbc_buttonPanel);
		
				JLabel lblTitle = new JLabel("Herzlich Willkommen bei deiner Karteikarten Lernapp!");
				GridBagConstraints gbc_lblTitle = new GridBagConstraints();
				gbc_lblTitle.gridwidth = 3;
				gbc_lblTitle.fill = GridBagConstraints.HORIZONTAL;
				gbc_lblTitle.gridx = 2;
				gbc_lblTitle.gridy = 1;
				gbc_lblTitle.insets = new Insets(0, 0, 5, 5);
				frame.getContentPane().add(lblTitle, gbc_lblTitle);
		GridBagConstraints gbc_btnKarteikartenEinsehen = new GridBagConstraints();
		gbc_btnKarteikartenEinsehen.gridx = 3;
		gbc_btnKarteikartenEinsehen.gridy = 4;
		gbc_btnKarteikartenEinsehen.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnKarteikartenEinsehen.insets = new Insets(0, 0, 5, 5);
		frame.getContentPane().add(btnKarteikartenEinsehen, gbc_btnKarteikartenEinsehen);
		
				btnKarteikartenEinsehen.addActionListener(this);
		GridBagConstraints gbc_btnKarteikartenLernen = new GridBagConstraints();
		gbc_btnKarteikartenLernen.anchor = GridBagConstraints.NORTH;
		gbc_btnKarteikartenLernen.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnKarteikartenLernen.insets = new Insets(0, 0, 5, 5);
		gbc_btnKarteikartenLernen.gridx = 3;
		gbc_btnKarteikartenLernen.gridy = 5;
		frame.getContentPane().add(btnKarteikartenLernen, gbc_btnKarteikartenLernen);

		btnKarteikartenLernen.addActionListener(this);
		GridBagConstraints gbc_btnKategorien = new GridBagConstraints();
		gbc_btnKategorien.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnKategorien.insets = new Insets(0, 0, 5, 5);
		gbc_btnKategorien.gridx = 3;
		gbc_btnKategorien.gridy = 6;
		frame.getContentPane().add(btnKategorien, gbc_btnKategorien);
		btnKategorien.addActionListener(this);
		GridBagConstraints gbc_btnProgrammBeenden = new GridBagConstraints();
		gbc_btnProgrammBeenden.insets = new Insets(0, 0, 0, 5);
		gbc_btnProgrammBeenden.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnProgrammBeenden.gridx = 3;
		gbc_btnProgrammBeenden.gridy = 8;
		frame.getContentPane().add(btnProgrammBeenden, gbc_btnProgrammBeenden);
		btnProgrammBeenden.addActionListener(this);

		frame.setVisible(true);
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