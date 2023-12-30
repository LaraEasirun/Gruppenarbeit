package de.vivienseligerlaraspadin.lernquiz.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import de.vivienseligerlaraspadin.lernquiz.core.KategorieManager;

public class KategorieEinsehen extends JFrame {
	private KategorieManager kategorieManager;
	private DefaultListModel<String> kategorienListModel;
	private JList<String> kategorienList;
	private JTextField kategorieTextField;
	private JButton hinzufuegenButton;
	private JButton bearbeitenButton;
	private JButton loeschenButton;

	public KategorieEinsehen() {
		kategorieManager = new KategorieManager();
		kategorienListModel = new DefaultListModel<>();
		kategorienList = new JList<>(kategorienListModel);
		kategorieTextField = new JTextField();
		hinzufuegenButton = new JButton("Hinzufügen");
		bearbeitenButton = new JButton("Bearbeiten");
		loeschenButton = new JButton("Löschen");

		// Set layout
		setLayout(new BorderLayout());

		// Add components to the frame
		add(new JScrollPane(kategorienList), BorderLayout.CENTER);
		add(kategorieTextField, BorderLayout.NORTH);

		// Create a panel for the buttons
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(1, 3));
		buttonPanel.add(hinzufuegenButton);
		buttonPanel.add(bearbeitenButton);
		buttonPanel.add(loeschenButton);
		add(buttonPanel, BorderLayout.SOUTH);

		// Add action listeners
		hinzufuegenButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String kategorie = kategorieTextField.getText();
				kategorieManager.kategorieHinzufuegen(kategorie);
				kategorienListModel.addElement(kategorie);
				kategorieTextField.setText("");
			}
		});

		bearbeitenButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedIndex = kategorienList.getSelectedIndex();
				if (selectedIndex != -1) {
					String kategorie = kategorieTextField.getText();
					kategorieManager.kategorieLoeschen(kategorie);
					kategorienListModel.setElementAt(kategorie, selectedIndex);
					kategorieTextField.setText("");
				}
			}
		});

		loeschenButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectedIndex = kategorienList.getSelectedIndex();
				if (selectedIndex != -1) {
					String kategorie = kategorienListModel.getElementAt(selectedIndex);
					kategorieManager.kategorieLoeschen(kategorie);
					kategorienListModel.remove(selectedIndex);
					kategorieTextField.setText("");
				}
			}
		});

		// Set frame properties
		setTitle("Kategorien verwalten");
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}
}