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
    private JButton btnKategorieHinzufügen, btnKategorieÄndern, btnKategorieLöschen, btnNeuLaden, btnHauptmenue; // Added btnHauptmenue

    public KategorieEinsehen() {
        kategorieManager = new KategorieManager();
        setTitle("Kategorien verwalten");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());

        // Tabelle initialisieren
        String[] columnNames = {"Kategorie"};
        tableModel = new DefaultTableModel(columnNames, 0);
        kategorienTabelle = new JTable(tableModel);
        ladeKategorienInTabelle();

        JScrollPane scrollPane = new JScrollPane(kategorienTabelle);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        add(scrollPane, gbc);

        // Buttons hinzufügen
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        btnKategorieHinzufügen = new JButton("Hinzufügen ➕");
        btnKategorieÄndern = new JButton("Ändern ✏️");
        btnKategorieLöschen = new JButton("Löschen 🗑️");
        btnNeuLaden = new JButton("Neu Laden");
        btnHauptmenue = new JButton("Hauptmenü"); // Added btnHauptmenue

        buttonPanel.add(btnKategorieHinzufügen);
        buttonPanel.add(btnKategorieÄndern);
        buttonPanel.add(btnKategorieLöschen);
        buttonPanel.add(btnNeuLaden);
        buttonPanel.add(btnHauptmenue); // Added btnHauptmenue

        gbc.gridy = 1;
        gbc.weighty = 0;
        add(buttonPanel, gbc);

        // ActionListener setzen
        btnKategorieHinzufügen.addActionListener(this);
        btnKategorieÄndern.addActionListener(this);
        btnKategorieLöschen.addActionListener(this);
        btnNeuLaden.addActionListener(this);
        btnHauptmenue.addActionListener(this); // Added btnHauptmenue

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void ladeKategorienInTabelle() {
        List<String> kategorien = kategorieManager.getKategorien();
        DefaultTableModel model = (DefaultTableModel) kategorienTabelle.getModel();
        model.setRowCount(0);
        for (String kategorie : kategorien) {
            model.addRow(new Object[]{kategorie});
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
                if (neueKategorie != null && !neueKategorie.trim().isEmpty() && !neueKategorie.equals(aktuelleKategorie)) {
                    kategorieManager.kategorieAendern(aktuelleKategorie, neueKategorie);
                    ladeKategorienInTabelle();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Bitte wählen Sie eine Kategorie aus, um sie zu ändern.", "Keine Auswahl", JOptionPane.WARNING_MESSAGE);
            }
        } else if (e.getSource() == btnKategorieLöschen) {
            int selectedRow = kategorienTabelle.getSelectedRow();
            if (selectedRow >= 0) {
                String kategorie = (String) kategorienTabelle.getValueAt(selectedRow, 0);
                int antwort = JOptionPane.showConfirmDialog(this, "Wollen Sie die Kategorie '" + kategorie + "' wirklich löschen?", "Kategorie löschen", JOptionPane.YES_NO_OPTION);
                if (antwort == JOptionPane.YES_OPTION) {
                    kategorieManager.kategorieLoeschen(kategorie);
                    ladeKategorienInTabelle();
                }
            } else {
                JOptionPane.showMessageDialog(this, "Bitte wählen Sie eine Kategorie aus, um sie zu löschen.", "Keine Auswahl", JOptionPane.WARNING_MESSAGE);
            }
        } else if (e.getSource() == btnNeuLaden) {
            ladeKategorienInTabelle();
        } else if (e.getSource() == btnHauptmenue) { // Added btnHauptmenue
            this.dispose();
		    new Hauptmenue();
        }
    }
}