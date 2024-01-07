package de.vivienseligerlaraspadin.lernquiz.gui;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import de.vivienseligerlaraspadin.lernquiz.core.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * Diese Klasse repräsentiert das GUI für die Verwaltung von Kategorien.
 * Sie ermöglicht das Hinzufügen, Ändern und Löschen von Kategorien sowie den Zugriff auf das Hauptmenü.
 */
public class KategorieEinsehen extends JFrame implements ActionListener {
    private KategorieManager kategorieManager; // Instanz des KategorieManagers für die Verwaltung von Kategorien
    private DefaultTableModel tableModel; // Modell für die Tabelle zur Anzeige der Kategorien
    private JTable kategorienTabelle; // Tabelle zur Anzeige der Kategorien
    private JButton btnKategorieHinzufuegen, btnKategorieAendern, btnKategorieLoeschen, btnHauptmenue; 

    /**
     * Konstruktor der Klasse KategorieEinsehen, der das GUI für die Verwaltung von Kategorien erstellt.
     */
    public KategorieEinsehen() {
        kategorieManager = new KategorieManager(); // Initialisierung des KategorieManagers
        setTitle("Kategorien verwalten"); // Setzen des Fenstertitels
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Festlegen des Schließverhaltens
        setLayout(new GridBagLayout()); // Festlegen des Layout-Managers

        // Buttons hinzufügen
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT)); // Erstellen eines Panels für die Buttons
        btnKategorieHinzufuegen = new JButton("Hinzufügen"); // Button zum Hinzufügen einer neuen Kategorie
        btnKategorieAendern = new JButton("Ändern"); // Button zum Ändern einer ausgewählten Kategorie
        btnKategorieLoeschen = new JButton("Löschen"); // Button zum Löschen einer ausgewählten Kategorie
        btnHauptmenue = new JButton("Hauptmenü"); // Button zum Zurückkehren zum Hauptmenü

        buttonPanel.add(btnKategorieHinzufuegen); // Hinzufügen des Hinzufügen-Buttons zum Panel
        buttonPanel.add(btnKategorieAendern); // Hinzufügen des Ändern-Buttons zum Panel
        buttonPanel.add(btnKategorieLoeschen); // Hinzufügen des Löschen-Buttons zum Panel
        buttonPanel.add(Box.createHorizontalGlue()); // Hinzugefügter horizontaler Abstand
        buttonPanel.add(btnHauptmenue); // Hinzufügen des Hauptmenü-Buttons zum Panel

        GridBagConstraints gbc = new GridBagConstraints(); // Erstellen von Constraints für das Layout
        gbc.fill = GridBagConstraints.HORIZONTAL; // Festlegen des Fülltyps
        gbc.weightx = 1.0; // Festlegen des Gewichts in horizontaler Richtung
        gbc.weighty = 0; // Festlegen des Gewichts in vertikaler Richtung
        gbc.gridx = 0; // Festlegen der X-Position im Grid
        gbc.gridy = 0; // Festlegen der Y-Position im Grid
        add(buttonPanel, gbc); // Hinzufügen des Button-Panels zum Hauptframe

        // Tabelle initialisieren
        String[] columnNames = {"Kategorie"}; // Spaltennamen für die Tabelle
        tableModel = new DefaultTableModel(columnNames, 0); // Erstellen eines Modells für die Tabelle
        kategorienTabelle = new JTable(tableModel); // Erstellen der Tabelle
        ladeKategorienInTabelle(); // Laden der vorhandenen Kategorien in die Tabelle

        JScrollPane scrollPane = new JScrollPane(kategorienTabelle); // Erstellen eines ScrollPanes für die Tabelle
        gbc = new GridBagConstraints(); // Zurücksetzen der Constraints
        gbc.fill = GridBagConstraints.BOTH; // Festlegen des Fülltyps auf "beides"
        gbc.weightx = 1.0; // Festlegen des Gewichts in horizontaler Richtung
        gbc.weighty = 1.0; // Festlegen des Gewichts in vertikaler Richtung
        gbc.gridx = 0; // Festlegen der X-Position im Grid
        gbc.gridy = 1; // Festlegen der Y-Position im Grid
        add(scrollPane, gbc); // Hinzufügen der Tabelle mit ScrollPane zum Hauptframe

        // ActionListener setzen
        btnKategorieHinzufuegen.addActionListener(this); // ActionListener für Hinzufügen-Button
        btnKategorieAendern.addActionListener(this); // ActionListener für Ändern-Button
        btnKategorieLoeschen.addActionListener(this); // ActionListener für Löschen-Button
        btnHauptmenue.addActionListener(this); // ActionListener für Hauptmenü-Button

        pack(); // Größe des Frames an den Inhalt anpassen
        setLocationRelativeTo(null); // Frame in der Mitte des Bildschirms positionieren
        setVisible(true); // Frame sichtbar machen
    }

    /**
     * Methode zum Laden der vorhandenen Kategorien in die Tabelle zur Anzeige.
     */
    private void ladeKategorienInTabelle() {
        List<String> kategorien = kategorieManager.getKategorien(); // Abrufen der Kategorien aus dem KategorieManager
        DefaultTableModel model = (DefaultTableModel) kategorienTabelle.getModel(); // Zugriff auf das Tabellenmodell
        model.setRowCount(0); // Zurücksetzen der Zeilen im Modell
        for (String kategorie : kategorien) {
            model.addRow(new Object[]{kategorie}); // Hinzufügen der Kategorie zur Tabelle
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnKategorieHinzufuegen) {
            // Aktion für Hinzufügen-Button
            String neueKategorie = JOptionPane.showInputDialog(this, "Neue Kategorie:"); // Dialog zur Eingabe einer neuen Kategorie
            if (neueKategorie != null && !neueKategorie.trim().isEmpty()) {
                kategorieManager.kategorieHinzufuegen(neueKategorie); // Neue Kategorie hinzufügen
                ladeKategorienInTabelle(); // Tabelle aktualisieren
                this.revalidate(); // Neuladen des GUIs
                this.repaint(); // Neuzeichnen des GUIs
            }
        } else if (e.getSource() == btnKategorieAendern) {
            // Aktion für Ändern-Button
            int selectedRow = kategorienTabelle.getSelectedRow(); // Ausgewählte Zeile in der Tabelle
            if (selectedRow >= 0) {
                String aktuelleKategorie = (String) kategorienTabelle.getValueAt(selectedRow, 0); // Ausgewählte Kategorie
                String neueKategorie = JOptionPane.showInputDialog(this, "Kategorie ändern:", aktuelleKategorie); // Dialog zur Änderung der Kategorie
                if (neueKategorie != null && !neueKategorie.trim().isEmpty() && !neueKategorie.equals(aktuelleKategorie)) {
                    kategorieManager.kategorieAendern(aktuelleKategorie, neueKategorie); // Kategorie ändern
                    ladeKategorienInTabelle(); // Tabelle aktualisieren
                }
            } else {
                JOptionPane.showMessageDialog(this, "Bitte wählen Sie eine Kategorie aus, um sie zu ändern.", "Keine Auswahl", JOptionPane.WARNING_MESSAGE);
            }
        } else if (e.getSource() == btnKategorieLoeschen) {
            // Aktion für Löschen-Button
            int selectedRow = kategorienTabelle.getSelectedRow(); // Ausgewählte Zeile in der Tabelle
            if (selectedRow >= 0) {
                String kategorie = (String) kategorienTabelle.getValueAt(selectedRow, 0); // Ausgewählte Kategorie
                int antwort = JOptionPane.showConfirmDialog(this, "Wollen Sie die Kategorie '" + kategorie + "' wirklich löschen?", "Kategorie löschen", JOptionPane.YES_NO_OPTION); // Dialog zur Bestätigung der Löschung
                if (antwort == JOptionPane.YES_OPTION) {
                    kategorieManager.kategorieLoeschen(kategorie); // Kategorie löschen
                    ladeKategorienInTabelle(); // Tabelle aktualisieren
                }
            } else {
                JOptionPane.showMessageDialog(this, "Bitte wählen Sie eine Kategorie aus, um sie zu löschen.", "Keine Auswahl", JOptionPane.WARNING_MESSAGE);
            }
        } else if (e.getSource() == btnHauptmenue) { 
            // Aktion für Hauptmenü-Button
            this.dispose(); // Schließen des aktuellen Frames
            new Hauptmenue(); // Öffnen des Hauptmenüs
        }
    }
}
