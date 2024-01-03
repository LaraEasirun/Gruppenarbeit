package de.vivienseligerlaraspadin.lernquiz.gui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import de.vivienseligerlaraspadin.lernquiz.core.KategorieManager;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class KategorieEinsehen extends JFrame implements ActionListener {
	private KategorieManager kategorieManager;
	private DefaultTableModel tableModel;
	private JTable kategorienTabelle;
	private JButton btnKategorieHinzufügen, btnKategorieÄndern, btnKategorieLöschen, btnNeuLaden, btnHauptmenue; // Added
																													// btnHauptmenue

	public KategorieEinsehen() {
		kategorieManager = new KategorieManager();
		setTitle("Kategorien verwalten");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		String[] columnNames = { "Kategorie" };
		tableModel = new DefaultTableModel(columnNames, 0);
		kategorienTabelle = new JTable(tableModel);

		ladeKategorienInTabelle();
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 137, 0, 0, 0, 0, 0 };
		gridBagLayout.rowHeights = new int[] { 56, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);
		btnKategorieHinzufügen = new JButton("Hinzufügen ➕");
		GridBagConstraints gbc_btnKategorieHinzufügen = new GridBagConstraints();
		gbc_btnKategorieHinzufügen.insets = new Insets(0, 0, 5, 5);
		gbc_btnKategorieHinzufügen.gridx = 0;
		gbc_btnKategorieHinzufügen.gridy = 0;
		getContentPane().add(btnKategorieHinzufügen, gbc_btnKategorieHinzufügen);

		// ActionListener setzen
		btnKategorieHinzufügen.addActionListener(this);
		btnKategorieÄndern = new JButton("Ändern ✏️");
		GridBagConstraints gbc_btnKategorieÄndern = new GridBagConstraints();
		gbc_btnKategorieÄndern.insets = new Insets(0, 0, 5, 5);
		gbc_btnKategorieÄndern.gridx = 1;
		gbc_btnKategorieÄndern.gridy = 0;
		getContentPane().add(btnKategorieÄndern, gbc_btnKategorieÄndern);
		btnKategorieÄndern.addActionListener(this);
		btnKategorieLöschen = new JButton("Löschen 🗑️");
		GridBagConstraints gbc_btnKategorieLöschen = new GridBagConstraints();
		gbc_btnKategorieLöschen.insets = new Insets(0, 0, 5, 5);
		gbc_btnKategorieLöschen.gridx = 2;
		gbc_btnKategorieLöschen.gridy = 0;
		getContentPane().add(btnKategorieLöschen, gbc_btnKategorieLöschen);
		btnKategorieLöschen.addActionListener(this);
		btnNeuLaden = new JButton("Neu Laden");
		GridBagConstraints gbc_btnNeuLaden = new GridBagConstraints();
		gbc_btnNeuLaden.insets = new Insets(0, 0, 5, 5);
		gbc_btnNeuLaden.gridx = 3;
		gbc_btnNeuLaden.gridy = 0;
		getContentPane().add(btnNeuLaden, gbc_btnNeuLaden);
		btnNeuLaden.addActionListener(this);
		btnHauptmenue = new JButton("Hauptmenü");
		GridBagConstraints gbc_btnHauptmenue = new GridBagConstraints();
		gbc_btnHauptmenue.insets = new Insets(0, 0, 5, 0);
		gbc_btnHauptmenue.gridx = 4;
		gbc_btnHauptmenue.gridy = 0;
		getContentPane().add(btnHauptmenue, gbc_btnHauptmenue);
		btnHauptmenue.addActionListener(this); // Added btnHauptmenue

		JScrollPane scrollPane = new JScrollPane(kategorienTabelle);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.gridwidth = 5;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		getContentPane().add(scrollPane, gbc_scrollPane);

		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void ladeKategorienInTabelle() {
		List<String> kategorien = kategorieManager.getKategorien();
		DefaultTableModel model = (DefaultTableModel) kategorienTabelle.getModel();
		model.setRowCount(0);
		for (String kategorie : kategorien) {
			model.addRow(new Object[] { kategorie });
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnKategorieHinzufügen) {
			String neueKategorie = JOptionPane.showInputDialog(this, "Neue Kategorie:");
			if (neueKategorie != null && !neueKategorie.trim().isEmpty()) {
				kategorieManager.kategorieHinzufuegen(neueKategorie);
				ladeKategorienInTabelle();
				this.revalidate();
				this.repaint();
			}
		} else if (e.getSource() == btnKategorieÄndern) {
			int selectedRow = kategorienTabelle.getSelectedRow();
			if (selectedRow >= 0) {
				String aktuelleKategorie = (String) kategorienTabelle.getValueAt(selectedRow, 0);
				String neueKategorie = JOptionPane.showInputDialog(this, "Kategorie ändern:", aktuelleKategorie);
				if (neueKategorie != null && !neueKategorie.trim().isEmpty()
						&& !neueKategorie.equals(aktuelleKategorie)) {
					kategorieManager.kategorieAendern(aktuelleKategorie, neueKategorie);
					ladeKategorienInTabelle();
				}
			} else {
				JOptionPane.showMessageDialog(this, "Bitte wählen Sie eine Kategorie aus, um sie zu ändern.",
						"Keine Auswahl", JOptionPane.WARNING_MESSAGE);
			}
		} else if (e.getSource() == btnKategorieLöschen) {
			int selectedRow = kategorienTabelle.getSelectedRow();
			if (selectedRow >= 0) {
				String kategorie = (String) kategorienTabelle.getValueAt(selectedRow, 0);
				int antwort = JOptionPane.showConfirmDialog(this,
						"Wollen Sie die Kategorie '" + kategorie + "' wirklich löschen?", "Kategorie löschen",
						JOptionPane.YES_NO_OPTION);
				if (antwort == JOptionPane.YES_OPTION) {
					kategorieManager.kategorieLoeschen(kategorie);
					ladeKategorienInTabelle();
				}
			} else {
				JOptionPane.showMessageDialog(this, "Bitte wählen Sie eine Kategorie aus, um sie zu löschen.",
						"Keine Auswahl", JOptionPane.WARNING_MESSAGE);
			}
		} else if (e.getSource() == btnNeuLaden) {
			ladeKategorienInTabelle();
		} else if (e.getSource() == btnHauptmenue) { // Added btnHauptmenue
			this.dispose();
			new Hauptmenue();
		}
	}
}