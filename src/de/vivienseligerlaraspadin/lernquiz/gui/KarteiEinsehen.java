package de.vivienseligerlaraspadin.lernquiz.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import de.vivienseligerlaraspadin.lernquiz.core.*;

import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;

public class KarteiEinsehen implements ActionListener {

	private JFrame frame;
	private JTable karteikartenTabelle;
	private DefaultTableModel tableModel;
	private JButton btnNeueKarteikarteErstellen;
	private JButton btnKarteikartenBearbeiten;
	private JButton btnKarteikartenLoeschen;
	private List<Karteikarte> karteikartenListe;
	private JPanel topPanel; // Deklariere topPanel als Instanzvariable
	private JButton btnHauptmenue; // Deklariere btnHauptmenue als Instanzvariable

	public KarteiEinsehen() {
		frame = new JFrame("Karteikarten Einsehen");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel rightPanel = new JPanel(new BorderLayout());

		String[] columnNames = { "Frage", "Antwort", "Kategorie", "Schwierigkeit" };
		karteikartenListe = KartenManager.zeigeAlleKarteikarten(); // Angenommen, es gibt eine Klasse KartenManager
		Object[][] data = new Object[karteikartenListe.size()][columnNames.length];
		for (int i = 0; i < karteikartenListe.size(); i++) {
			Karteikarte karte = karteikartenListe.get(i);
			data[i][0] = karte.getFrage();
			data[i][1] = karte.getAntwort();
			data[i][2] = karte.getKategorie();
			data[i][3] = karte.getSchwierigkeit();
		}
		tableModel = new DefaultTableModel(data, columnNames);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 1, 130, 196, 75, 75, 75, 0 };
		gridBagLayout.rowHeights = new int[] { 1, 29, 420, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		frame.getContentPane().setLayout(gridBagLayout);

		JPanel topPanel_1 = new JPanel(new BorderLayout());
		GridBagConstraints gbc_topPanel_1 = new GridBagConstraints();
		gbc_topPanel_1.anchor = GridBagConstraints.NORTHWEST;
		gbc_topPanel_1.insets = new Insets(0, 0, 5, 5);
		gbc_topPanel_1.gridx = 0;
		gbc_topPanel_1.gridy = 0;
		frame.getContentPane().add(topPanel_1, gbc_topPanel_1);

		btnNeueKarteikarteErstellen = new JButton("➕");
		GridBagConstraints gbc_btnNeueKarteikarteErstellen = new GridBagConstraints();
		gbc_btnNeueKarteikarteErstellen.anchor = GridBagConstraints.WEST;
		gbc_btnNeueKarteikarteErstellen.insets = new Insets(0, 0, 5, 5);
		gbc_btnNeueKarteikarteErstellen.gridx = 1;
		gbc_btnNeueKarteikarteErstellen.gridy = 1;
		frame.getContentPane().add(btnNeueKarteikarteErstellen, gbc_btnNeueKarteikarteErstellen);
		btnNeueKarteikarteErstellen.setBackground(new Color(251, 251, 246));
		btnNeueKarteikarteErstellen.addActionListener(this);
		btnKarteikartenLoeschen = new JButton("🗑️");
		GridBagConstraints gbc_btnKarteikartenLoeschen = new GridBagConstraints();
		gbc_btnKarteikartenLoeschen.insets = new Insets(0, 0, 5, 5);
		gbc_btnKarteikartenLoeschen.gridx = 3;
		gbc_btnKarteikartenLoeschen.gridy = 1;
		frame.getContentPane().add(btnKarteikartenLoeschen, gbc_btnKarteikartenLoeschen);
		btnKarteikartenBearbeiten = new JButton("✏️");
		GridBagConstraints gbc_btnKarteikartenBearbeiten = new GridBagConstraints();
		gbc_btnKarteikartenBearbeiten.insets = new Insets(0, 0, 5, 5);
		gbc_btnKarteikartenBearbeiten.gridx = 4;
		gbc_btnKarteikartenBearbeiten.gridy = 1;
		frame.getContentPane().add(btnKarteikartenBearbeiten, gbc_btnKarteikartenBearbeiten);

		btnHauptmenue = new JButton(" Hauptmenü");
		GridBagConstraints gbc_btnHauptmenue = new GridBagConstraints();
		gbc_btnHauptmenue.insets = new Insets(0, 0, 5, 0);
		gbc_btnHauptmenue.gridx = 5;
		gbc_btnHauptmenue.gridy = 1;
		frame.getContentPane().add(btnHauptmenue, gbc_btnHauptmenue);
		btnHauptmenue.addActionListener(this);
		karteikartenTabelle = new JTable(tableModel);
		JScrollPane scrollPane = new JScrollPane(karteikartenTabelle);
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.anchor = GridBagConstraints.NORTH;
		gbc_scrollPane.fill = GridBagConstraints.HORIZONTAL;
		gbc_scrollPane.gridwidth = 6;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 2;
		frame.getContentPane().add(scrollPane, gbc_scrollPane);

		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNeueKarteikarteErstellen) {
			frame.dispose();
			new KarteiErstellen();
		} else if (e.getSource() == btnHauptmenue) {
			frame.dispose();
			new Hauptmenue(); // Erstelle ein neues Hauptmenü-Fenster
		}
		// Fügen Sie hier weitere else-if-Blöcke für andere Buttons hinzu
	}

	public void setVisible(boolean b) {
	}

	// Neuer Button für Rückkehr zum Hauptmenü

	public void addBtnHauptmenueListener(ActionListener listener) {
		btnHauptmenue.addActionListener(listener);
	}

	public void setBtnHauptmenueVisible(boolean visible) {
		btnHauptmenue.setVisible(visible);
	}
}