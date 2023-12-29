package de.vivienseligerlaraspadin.lernquiz.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import de.vivienseligerlaraspadin.lernquiz.core.*;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class KarteiEinsehen implements ActionListener {

	private JFrame frame;
	public static JTable karteikartenTabelle;
	private DefaultTableModel tableModel;
	private JButton btnNeueKarteikarteErstellen;
	private JButton btnKarteikartenBearbeiten;
	private JButton btnKarteikartenLoeschen;
	private List<Karteikarte> karteikartenListe;
	private JButton btnHauptmenue; // Deklariere btnHauptmenue als Instanzvariable
	private JButton btnNeuLaden; // Deklariere btnNeuLaden als Instanzvariable

	public KarteiEinsehen() {
		frame = new JFrame("Karteikarten Einsehen");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		String[] columnNames = {"ID", "Frage", "Antwort", "Kategorie", "Schwierigkeit" };
		karteikartenListe = KartenManager.zeigeAlleKarteikarten(); // Angenommen, es gibt eine Klasse KartenManager
		Object[][] data = new Object[karteikartenListe.size()][columnNames.length];
		for (int i = 0; i < karteikartenListe.size(); i++) {
			Karteikarte karte = karteikartenListe.get(i);
			data[i][0] = i;
			data[i][1] = karte.getFrage();
			data[i][2] = karte.getAntwort();
			data[i][3] = karte.getKategorie();
			data[i][4] = karte.getSchwierigkeit();
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

		btnNeueKarteikarteErstellen = new JButton("Hinzufügen ➕");
		GridBagConstraints gbc_btnNeueKarteikarteErstellen = new GridBagConstraints();
		gbc_btnNeueKarteikarteErstellen.anchor = GridBagConstraints.WEST;
		gbc_btnNeueKarteikarteErstellen.insets = new Insets(0, 0, 5, 5);
		gbc_btnNeueKarteikarteErstellen.gridx = 1;
		gbc_btnNeueKarteikarteErstellen.gridy = 1;
		frame.getContentPane().add(btnNeueKarteikarteErstellen, gbc_btnNeueKarteikarteErstellen);
		btnNeueKarteikarteErstellen.setBackground(new Color(251, 251, 246));
		btnNeueKarteikarteErstellen.addActionListener(this);

		btnNeuLaden = new JButton("Neu Laden");
		GridBagConstraints gbc_btnNeuLaden = new GridBagConstraints();
		gbc_btnNeuLaden.anchor = GridBagConstraints.WEST;
		gbc_btnNeuLaden.insets = new Insets(0, 0, 5, 5);
		gbc_btnNeuLaden.gridx = 2;
		gbc_btnNeuLaden.gridy = 1;
		frame.getContentPane().add(btnNeuLaden, gbc_btnNeuLaden);
		btnNeuLaden.addActionListener(this);
		btnNeuLaden.setVisible(true); // Setze den Button auf sichtbar

		btnKarteikartenLoeschen = new JButton("🗑️");
		btnKarteikartenLoeschen.addActionListener(this);
		GridBagConstraints gbc_btnKarteikartenLoeschen = new GridBagConstraints();
		gbc_btnKarteikartenLoeschen.insets = new Insets(0, 0, 5, 5);
		gbc_btnKarteikartenLoeschen.gridx = 3;
		gbc_btnKarteikartenLoeschen.gridy = 1;
		frame.getContentPane().add(btnKarteikartenLoeschen, gbc_btnKarteikartenLoeschen);

		btnKarteikartenBearbeiten = new JButton("Ändern ✏️");
		btnKarteikartenBearbeiten.addActionListener(this);
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
			new Hauptmenue();
		} else if (e.getSource() == btnKarteikartenBearbeiten) {

			int selectedRow = karteikartenTabelle.getSelectedRow();
			if (selectedRow >= 0) {
				Karteikarte karte = karteikartenListe.get(selectedRow);
				frame.dispose();
				new KarteiAendern(karte);
			} else {
				JOptionPane.showMessageDialog(frame, "Bitte wählen Sie eine Karteikarte aus, um sie zu bearbeiten.", "Keine Auswahl", JOptionPane.WARNING_MESSAGE);
	}

		} else if (e.getSource() == btnKarteikartenLoeschen) {
			int selectedRow = karteikartenTabelle.getSelectedRow();
			if (selectedRow >= 0) {
				Karteikarte karte = karteikartenListe.get(selectedRow);
				int antwort = JOptionPane.showConfirmDialog(frame, "Wollen Sie die Karteikarte wirklich löschen?", "Karteikarte löschen", JOptionPane.YES_NO_OPTION);
				if (antwort == JOptionPane.YES_OPTION) {
					KartenManager.loescheKarteikarte(selectedRow);
					aktualisiereTabelle();
					frame.dispose();
					KartenManager.reloadWindows();
				}
			} else {
				JOptionPane.showMessageDialog(frame, "Bitte wählen Sie eine Karteikarte aus, um sie zu löschen.", "Keine Auswahl", JOptionPane.WARNING_MESSAGE);
			}
			
		} else if (e.getSource() == btnNeuLaden) {
			frame.dispose();
			aktualisiereTabelle();
			KartenManager.reloadWindows();
		}
	}


	private void aktualisiereTabelle() {
		karteikartenListe = KartenManager.zeigeAlleKarteikarten();
		DefaultTableModel model = (DefaultTableModel) karteikartenTabelle.getModel();
		model.setRowCount(0);
		for (Karteikarte karte : karteikartenListe) {
			model.addRow(new Object[]{karte.getFrage(), karte.getAntwort(), karte.getKategorie(), karte.getSchwierigkeit()});
		}
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

			public void addBtnNeueKarteikarteErstellenListener(ActionListener listener) {
				btnNeueKarteikarteErstellen.addActionListener(listener);
			}

			public void setBtnNeueKarteikarteErstellenVisible(boolean visible) {
				btnNeueKarteikarteErstellen.setVisible(visible);
			}

			public void addBtnKarteikartenBearbeitenListener(ActionListener listener) {
				btnKarteikartenBearbeiten.addActionListener(listener);
			}

			public void setBtnKarteikartenBearbeitenVisible(boolean visible) {
				btnKarteikartenBearbeiten.setVisible(visible);
			}

			public void addBtnKarteikartenLoeschenListener(ActionListener listener) {
				btnKarteikartenLoeschen.addActionListener(listener);
			}

			public void setBtnKarteikartenLoeschenVisible(boolean visible) {
				btnKarteikartenLoeschen.setVisible(visible);
			}
		}