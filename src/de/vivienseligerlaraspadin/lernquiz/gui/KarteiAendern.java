package de.vivienseligerlaraspadin.lernquiz.gui;

import javax.swing.*;

import de.vivienseligerlaraspadin.lernquiz.core.KarteiContainer;
import de.vivienseligerlaraspadin.lernquiz.core.Karteikarte;
import de.vivienseligerlaraspadin.lernquiz.core.KartenManager;
import de.vivienseligerlaraspadin.lernquiz.core.KategorieContainer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KarteiAendern {

	private JFrame frame;
	public static JTextField frageTextField;
	public JTextField antwortTextField;
	public JComboBox<String> kategorieComboBox;
	public JComboBox<String> schwierigkeitComboBox;
	private Karteikarte aktuelleKarteikarte;

	public KarteiAendern(Karteikarte karteikarte) {
		aktuelleKarteikarte = karteikarte;
		frame = new JFrame("Karteikarte ändern");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(400, 250);
		frame.setLayout(null);

		JLabel frageLabel = new JLabel("Frage:");
		frageLabel.setBounds(20, 20, 100, 20);
		frame.add(frageLabel);

		frageTextField = new JTextField(karteikarte.getFrage());
		frageTextField.setBounds(130, 20, 200, 20);
		frame.add(frageTextField);

		JLabel antwortLabel = new JLabel("Antwort:");
		antwortLabel.setBounds(20, 50, 100, 20);
		frame.add(antwortLabel);

		antwortTextField = new JTextField(karteikarte.getAntwort());
		antwortTextField.setBounds(130, 50, 200, 20);
		frame.add(antwortTextField);

		JLabel kategorieLabel = new JLabel("Kategorie:");
		kategorieLabel.setBounds(20, 80, 100, 20);
		frame.add(kategorieLabel);

		kategorieComboBox = new JComboBox<>();
		KategorieContainer kategorieContainer = new KategorieContainer();
		for (String kategorie : kategorieContainer.getKategorien()) {
			kategorieComboBox.addItem(kategorie);
		}
		kategorieComboBox.setSelectedItem(karteikarte.getKategorie());
		kategorieComboBox.setBounds(130, 80, 200, 20);
		frame.add(kategorieComboBox);

		JLabel schwierigkeitLabel = new JLabel("Schwierigkeit:");
		schwierigkeitLabel.setBounds(20, 110, 100, 20);
		frame.add(schwierigkeitLabel);

		schwierigkeitComboBox = new JComboBox<>(new String[] { "Leicht", "Mittel", "Schwer" });
		schwierigkeitComboBox.setSelectedItem(karteikarte.getSchwierigkeit());
		schwierigkeitComboBox.setBounds(130, 110, 200, 20);
		frame.add(schwierigkeitComboBox);

		JButton aendernButton = new JButton("Speichern");
		aendernButton.setBounds(150, 150, 100, 30);
		aendernButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				aktuelleKarteikarte.setFrage(frageTextField.getText());
				aktuelleKarteikarte.setAntwort(antwortTextField.getText());
				aktuelleKarteikarte.setKategorie((String) kategorieComboBox.getSelectedItem());
				aktuelleKarteikarte.setSchwierigkeit((String) schwierigkeitComboBox.getSelectedItem());

				JOptionPane.showMessageDialog(frame, "Karteikarte wurde erfolgreich geändert!", "Änderung erfolgreich",
						JOptionPane.INFORMATION_MESSAGE);
				frame.dispose();
				KarteiContainer.getInstance().speichern();
				KartenManager.reloadWindows();
			}
		});
		frame.add(aendernButton);

		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}
}