package de.vivienseligerlaraspadin.lernquiz.gui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import de.vivienseligerlaraspadin.lernquiz.core.KartenManager;
import de.vivienseligerlaraspadin.lernquiz.core.KategorieContainer;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class KarteiErstellen {

	private JFrame frame;
	private JTextField frageTextField;
	private JTextField antwortTextField;
	private JComboBox<String> kategorieComboBox;
	private JComboBox<String> schwierigkeitComboBox;

	public KarteiErstellen() {
		frame = new JFrame("Karteikarte erstellen");
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 30, 95, 200, 80, 0 };
		gbl_panel.rowHeights = new int[] { 30, 26, 26, 27, 27, 30, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		schwierigkeitComboBox = new JComboBox<>();
		schwierigkeitComboBox.addItem("Leicht");
		schwierigkeitComboBox.addItem("Mittel");
		schwierigkeitComboBox.addItem("Schwer");

		JLabel frageLabel = new JLabel("Frage:");
		GridBagConstraints gbc_frageLabel = new GridBagConstraints();
		gbc_frageLabel.fill = GridBagConstraints.BOTH;
		gbc_frageLabel.insets = new Insets(0, 0, 5, 5);
		gbc_frageLabel.gridx = 1;
		gbc_frageLabel.gridy = 1;
		panel.add(frageLabel, gbc_frageLabel);

		frageTextField = new JTextField();
		GridBagConstraints gbc_frageTextField = new GridBagConstraints();
		gbc_frageTextField.fill = GridBagConstraints.BOTH;
		gbc_frageTextField.insets = new Insets(0, 0, 5, 5);
		gbc_frageTextField.gridx = 2;
		gbc_frageTextField.gridy = 1;
		panel.add(frageTextField, gbc_frageTextField);

		JLabel antwortLabel = new JLabel("Antwort:");
		GridBagConstraints gbc_antwortLabel = new GridBagConstraints();
		gbc_antwortLabel.fill = GridBagConstraints.BOTH;
		gbc_antwortLabel.insets = new Insets(0, 0, 5, 5);
		gbc_antwortLabel.gridx = 1;
		gbc_antwortLabel.gridy = 2;
		panel.add(antwortLabel, gbc_antwortLabel);

		antwortTextField = new JTextField();
		GridBagConstraints gbc_antwortTextField = new GridBagConstraints();
		gbc_antwortTextField.fill = GridBagConstraints.BOTH;
		gbc_antwortTextField.insets = new Insets(0, 0, 5, 5);
		gbc_antwortTextField.gridx = 2;
		gbc_antwortTextField.gridy = 2;
		panel.add(antwortTextField, gbc_antwortTextField);

		JLabel kategorieLabel = new JLabel("Kategorie:");
		GridBagConstraints gbc_kategorieLabel = new GridBagConstraints();
		gbc_kategorieLabel.fill = GridBagConstraints.BOTH;
		gbc_kategorieLabel.insets = new Insets(0, 0, 5, 5);
		gbc_kategorieLabel.gridx = 1;
		gbc_kategorieLabel.gridy = 3;
		panel.add(kategorieLabel, gbc_kategorieLabel);

		kategorieComboBox = new JComboBox<>();
		GridBagConstraints gbc_kategorieComboBox = new GridBagConstraints();
		gbc_kategorieComboBox.fill = GridBagConstraints.BOTH;
		gbc_kategorieComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_kategorieComboBox.gridx = 2;
		gbc_kategorieComboBox.gridy = 3;
		panel.add(kategorieComboBox, gbc_kategorieComboBox);

		JLabel schwierigkeitLabel = new JLabel("Schwierigkeit:");
		GridBagConstraints gbc_schwierigkeitLabel = new GridBagConstraints();
		gbc_schwierigkeitLabel.fill = GridBagConstraints.BOTH;
		gbc_schwierigkeitLabel.insets = new Insets(0, 0, 5, 5);
		gbc_schwierigkeitLabel.gridx = 1;
		gbc_schwierigkeitLabel.gridy = 4;
		panel.add(schwierigkeitLabel, gbc_schwierigkeitLabel);
		GridBagConstraints gbc_schwierigkeitComboBox = new GridBagConstraints();
		gbc_schwierigkeitComboBox.fill = GridBagConstraints.BOTH;
		gbc_schwierigkeitComboBox.insets = new Insets(0, 0, 5, 5);
		gbc_schwierigkeitComboBox.gridx = 2;
		gbc_schwierigkeitComboBox.gridy = 4;
		panel.add(schwierigkeitComboBox, gbc_schwierigkeitComboBox);

		JButton erstellenButton = new JButton("Erstellen");
		erstellenButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Hier werden die Karteikarten erstellt und gespeichert
				String frage = frageTextField.getText();
				String antwort = antwortTextField.getText();
				String kategorie = (String) kategorieComboBox.getSelectedItem();
				String schwierigkeit = (String) schwierigkeitComboBox.getSelectedItem();

				// Karteikarte in der Liste in der Klasse KarteiContainer.java speichern
				KartenManager kartenManager = new KartenManager();
				kartenManager.erstelleKarteikarte(frage, antwort, kategorie, schwierigkeit, false);

				frame.dispose();
				JOptionPane.showMessageDialog(null, "Karteikarte wurde erfolgreich erstellt!", "Erfolg",
						JOptionPane.INFORMATION_MESSAGE);

				KarteiEinsehen karteiEinsehen = new KarteiEinsehen();
				karteiEinsehen.setVisible(true);
			}
		});
		GridBagConstraints gbc_erstellenButton = new GridBagConstraints();
		gbc_erstellenButton.insets = new Insets(0, 0, 0, 5);
		gbc_erstellenButton.anchor = GridBagConstraints.WEST;
		gbc_erstellenButton.fill = GridBagConstraints.VERTICAL;
		gbc_erstellenButton.gridx = 2;
		gbc_erstellenButton.gridy = 5;
		panel.add(erstellenButton, gbc_erstellenButton);
		KategorieContainer kategorieContainer = new KategorieContainer();
		for (String kategorie : kategorieContainer.getKategorien()) {
			kategorieComboBox.addItem(kategorie);
		}

		frame.getContentPane().add(panel);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(400, 250);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public void setvisible(boolean b) {
	}
}