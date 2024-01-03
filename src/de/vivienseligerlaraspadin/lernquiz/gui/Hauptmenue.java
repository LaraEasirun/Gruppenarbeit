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

public class Hauptmenue extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

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

		JButton btnProgrammBeenden = new JButton("Programm beenden");
		btnProgrammBeenden.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0); // Exit the program
			}
		});
		GridBagConstraints gbc_btnProgrammBeenden = new GridBagConstraints();
		gbc_btnProgrammBeenden.anchor = GridBagConstraints.NORTH;
		gbc_btnProgrammBeenden.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnProgrammBeenden.insets = new Insets(0, 50, 5, 50);
		gbc_btnProgrammBeenden.gridx = 1;
		gbc_btnProgrammBeenden.gridy = 7;
		contentPane.add(btnProgrammBeenden, gbc_btnProgrammBeenden);

		JLabel lblNewLabel_1 = new JLabel("Vivien Seliger, Lara Spadin v.1.0");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_1.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel_1.gridx = 1;
		gbc_lblNewLabel_1.gridy = 9;
		contentPane.add(lblNewLabel_1, gbc_lblNewLabel_1);

		setVisible(true);
	}
}
