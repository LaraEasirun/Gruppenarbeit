package de.vivienseligerlaraspadin.lernquiz.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import de.vivienseligerlaraspadin.lernquiz.core.Karteikarte;
import de.vivienseligerlaraspadin.lernquiz.core.KartenManager;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import de.vivienseligerlaraspadin.lernquiz.core.Karteikarte;
import de.vivienseligerlaraspadin.lernquiz.core.KartenManager;

/**
 * Die Klasse KarteiEinsehen ermöglicht es dem Benutzer, Karteikarten anzuzeigen,
 * neue hinzuzufügen, vorhandene zu bearbeiten und zu löschen.
 */
public class KarteiEinsehen implements ActionListener {

    private JFrame frame;
    public static JTable karteikartenTabelle;
    private DefaultTableModel tableModel;
    private JButton btnNeueKarteikarteErstellen;
    private JButton btnKarteikartenBearbeiten;
    private JButton btnKarteikartenLoeschen;
    private List<Karteikarte> karteikartenListe;
    private JButton btnHauptmenue;

    /**
     * Konstruktor für die KarteiEinsehen-Klasse.
     * Erzeugt ein Fenster zur Anzeige von Karteikarten und ermöglicht Aktionen wie Hinzufügen, Bearbeiten und Löschen.
     */
    public KarteiEinsehen() {
        // Initialisiert das Hauptfenster
        frame = new JFrame("Karteikarten Einsehen");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Definiert die Spaltenüberschriften für die Tabelle
        String[] columnNames = {"Frage", "Antwort", "Kategorie", "Schwierigkeit", "Kann ich?" };

        // Lädt die Liste der Karteikarten aus dem KartenManager
        karteikartenListe = KartenManager.zeigeAlleKarteikarten();

        // Erstellt eine Datenmatrix für die Tabelle basierend auf den Karteikartendaten
        Object[][] data = new Object[karteikartenListe.size()][columnNames.length];
        for (int i = 0; i < karteikartenListe.size(); i++) {
            Karteikarte karte = karteikartenListe.get(i);
            data[i][0] = karte.getFrage();
            data[i][1] = karte.getAntwort();
            data[i][2] = karte.getKategorie();
            data[i][3] = karte.getSchwierigkeitsgrad();
            data[i][4] = karte.getBeherrscht() ? "Ja" : "Nein";
        }

        // Erstellt ein Tabellenmodell für die Anzeige der Karteikartendaten
        tableModel = new DefaultTableModel(data, columnNames);

        // Definiert das Layout des Hauptfensters
        GridBagLayout gridBagLayout = new GridBagLayout();
        gridBagLayout.columnWidths = new int[] { 1, 190, 167, 75, 92, 98, 0 };
        gridBagLayout.rowHeights = new int[] { 1, 29, 420, 0 };
        gridBagLayout.columnWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
        gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
        frame.getContentPane().setLayout(gridBagLayout);

        // Erstellt die Schaltflächen und die Tabelle und fügt sie zum Hauptfenster hinzu

        // Schaltfläche "Hinzufügen"
        btnNeueKarteikarteErstellen = new JButton("Hinzufügen");
        GridBagConstraints gbc_btnNeueKarteikarteErstellen = new GridBagConstraints();
        gbc_btnNeueKarteikarteErstellen.anchor = GridBagConstraints.WEST;
        gbc_btnNeueKarteikarteErstellen.insets = new Insets(0, 0, 5, 5);
        gbc_btnNeueKarteikarteErstellen.gridx = 1;
        gbc_btnNeueKarteikarteErstellen.gridy = 1;
        frame.getContentPane().add(btnNeueKarteikarteErstellen, gbc_btnNeueKarteikarteErstellen);
        btnNeueKarteikarteErstellen.addActionListener(this);

        // Schaltfläche "Löschen"
        btnKarteikartenLoeschen = new JButton("Löschen️");
        btnKarteikartenLoeschen.addActionListener(this);
        GridBagConstraints gbc_btnKarteikartenLoeschen = new GridBagConstraints();
        gbc_btnKarteikartenLoeschen.insets = new Insets(0, 0, 5, 5);
        gbc_btnKarteikartenLoeschen.gridx = 3;
        gbc_btnKarteikartenLoeschen.gridy = 1;
        frame.getContentPane().add(btnKarteikartenLoeschen, gbc_btnKarteikartenLoeschen);

        // Schaltfläche "Ändern"
        btnKarteikartenBearbeiten = new JButton("Ändern️");
        btnKarteikartenBearbeiten.addActionListener(this);
        GridBagConstraints gbc_btnKarteikartenBearbeiten = new GridBagConstraints();
        gbc_btnKarteikartenBearbeiten.insets = new Insets(0, 0, 5, 5);
        gbc_btnKarteikartenBearbeiten.gridx = 4;
        gbc_btnKarteikartenBearbeiten.gridy = 1;
        frame.getContentPane().add(btnKarteikartenBearbeiten, gbc_btnKarteikartenBearbeiten);

        // Schaltfläche "Hauptmenü"
        btnHauptmenue = new JButton("Hauptmenü");
        GridBagConstraints gbc_btnHauptmenue = new GridBagConstraints();
        gbc_btnHauptmenue.insets = new Insets(0, 0, 5, 0);
        gbc_btnHauptmenue.gridx = 5;
        gbc_btnHauptmenue.gridy = 1;
        frame.getContentPane().add(btnHauptmenue, gbc_btnHauptmenue);
        btnHauptmenue.addActionListener(this);

        // Tabelle zur Anzeige der Karteikartendaten
        karteikartenTabelle = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(karteikartenTabelle);
        GridBagConstraints gbc_scrollPane = new GridBagConstraints();
        gbc_scrollPane.fill = GridBagConstraints.BOTH;
        gbc_scrollPane.gridwidth = 6;
        gbc_scrollPane.gridx = 0;
        gbc_scrollPane.gridy = 2;
        frame.getContentPane().add(scrollPane, gbc_scrollPane);

        // Zeigt das Hauptfenster an
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    /**
     * Implementierung der ActionListener-Schnittstelle, um auf Aktionen wie Klicken von Schaltflächen zu reagieren.
     * @param e Das ActionEvent-Objekt, das die ausgelöste Aktion darstellt.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnNeueKarteikarteErstellen) {
            // Wenn "Hinzufügen" geklickt wird, wird das aktuelle Fenster geschlossen und ein neues für das Hinzufügen von Karteikarten geöffnet.
            frame.dispose();
            new KarteiErstellen();
        } else if (e.getSource() == btnHauptmenue) {
            // Wenn "Hauptmenü" geklickt wird, wird das aktuelle Fenster geschlossen und das Hauptmenü wieder geöffnet.
            frame.dispose();
            new Hauptmenue();
        } else if (e.getSource() == btnKarteikartenBearbeiten) {
            // Wenn "Ändern" geklickt wird, wird überprüft, ob eine Zeile in der Tabelle ausgewählt ist.
            int selectedRow = karteikartenTabelle.getSelectedRow();
            if (selectedRow >= 0) {
                // Wenn eine Zeile ausgewählt ist, wird die entsprechende Karteikarte bearbeitet.
                Karteikarte karte = karteikartenListe.get(selectedRow);
                frame.dispose();
                new KarteiAendern(karte);
            } else {
                // Wenn keine Zeile ausgewählt ist, wird eine Warnung angezeigt.
                JOptionPane.showMessageDialog(frame, "Bitte wählen Sie eine Karteikarte aus, um sie zu bearbeiten.",
                        "Keine Auswahl", JOptionPane.WARNING_MESSAGE);
            }
        } else if (e.getSource() == btnKarteikartenLoeschen) {
            // Wenn "Löschen" geklickt wird, wird überprüft, ob eine Zeile in der Tabelle ausgewählt ist.
            int selectedRow = karteikartenTabelle.getSelectedRow();
            if (selectedRow >= 0) {
                // Wenn eine Zeile ausgewählt ist, wird die Löschbestätigung angezeigt und die Karteikarte gelöscht, wenn der Benutzer zustimmt.
                Karteikarte karte = karteikartenListe.get(selectedRow);
                int antwort = JOptionPane.showConfirmDialog(frame, "Wollen Sie die Karteikarte wirklich löschen?",
                        "Karteikarte löschen", JOptionPane.YES_NO_OPTION);
                if (antwort == JOptionPane.YES_OPTION) {
                    KartenManager.loescheKarteikarte(selectedRow);
                    aktualisiereTabelle();
                    frame.dispose();
                    KartenManager.reloadWindows();
                }
            } else {
                // Wenn keine Zeile ausgewählt ist, wird eine Warnung angezeigt.
                JOptionPane.showMessageDialog(frame, "Bitte wählen Sie eine Karteikarte aus, um sie zu löschen.",
                        "Keine Auswahl", JOptionPane.WARNING_MESSAGE);
            }
        }
    }

    /**
     * Aktualisiert die Tabelle mit den aktuellen Karteikartendaten.
     */
    private void aktualisiereTabelle() {
        karteikartenListe = KartenManager.zeigeAlleKarteikarten();
        DefaultTableModel model = (DefaultTableModel) karteikartenTabelle.getModel();
        model.setRowCount(0);
        for (Karteikarte karte : karteikartenListe) {
            model.addRow(new Object[] { karte.getFrage(), karte.getAntwort(), karte.getKategorie(),
                    karte.getSchwierigkeitsgrad(), karte.getBeherrscht() ? "Ja" : "Nein" });
        }
    }

    /**
     * Zählt die Anzahl der beherrschten Karteikarten.
     * @return Die Anzahl der beherrschten Karteikarten.
     */
    public int zaehleBeherrschteKarteikarten() {
        int zaehler = 0;
        for (Karteikarte karte : karteikartenListe) {
            if (karte.getBeherrscht()) {
                zaehler++;
            }
        }
        return zaehler;
    }

    /**
     * Ruft eine Liste von nicht beherrschten Karteikarten ab.
     * @return Eine Liste von nicht beherrschten Karteikarten.
     */
    public List<Karteikarte> getNichtBeherrschteKarteikarten() {
        List<Karteikarte> nichtBeherrschteKarteikarten = new ArrayList<>();
        for (Karteikarte karte : karteikartenListe) {
            if (!karte.getBeherrscht()) {
                nichtBeherrschteKarteikarten.add(karte);
            }
        }
        return nichtBeherrschteKarteikarten;
    }

    public void setVisible(boolean b) {
		
	}
    
    /**
     * Setzt die Sichtbarkeit des Hauptmenü-Buttons.
     * @param visible true, um den Hauptmenü-Button anzuzeigen, false, um ihn auszublenden.
     */
    public void setBtnHauptmenueVisible(boolean visible) {
        btnHauptmenue.setVisible(visible);
    }

    /**
     * Fügt einen ActionListener zur Schaltfläche "Hauptmenü" hinzu.
     * @param listener Der ActionListener, der aufgerufen wird, wenn die Schaltfläche "Hauptmenü" geklickt wird.
     */
    public void addBtnHauptmenueListener(ActionListener listener) {
        btnHauptmenue.addActionListener(listener);
    }

    /**
     * Setzt die Sichtbarkeit der Schaltfläche "Neue Karteikarte Erstellen".
     * @param visible true, um die Schaltfläche anzuzeigen, false, um sie auszublenden.
     */
    public void setBtnNeueKarteikarteErstellenVisible(boolean visible) {
        btnNeueKarteikarteErstellen.setVisible(visible);
    }

    /**
     * Fügt einen ActionListener zur Schaltfläche "Neue Karteikarte Erstellen" hinzu.
     * @param listener Der ActionListener, der aufgerufen wird, wenn die Schaltfläche "Neue Karteikarte Erstellen" geklickt wird.
     */
    public void addBtnNeueKarteikarteErstellenListener(ActionListener listener) {
        btnNeueKarteikarteErstellen.addActionListener(listener);
    }

    /**
     * Fügt einen ActionListener zur Schaltfläche "Bearbeiten" für Karteikarten hinzu.
     * @param listener Ein ActionListener, der aufgerufen wird, wenn die Schaltfläche "Bearbeiten" geklickt wird.
     */
    public void addBtnKarteikartenBearbeitenListener(ActionListener listener) {
        btnKarteikartenBearbeiten.addActionListener(listener);
    }

    /**
     * Legt fest, ob die Schaltfläche "Bearbeiten" für Karteikarten sichtbar ist oder nicht.
     * @param visible Ein boolescher Wert, der angibt, ob die Schaltfläche sichtbar sein soll (true) oder nicht (false).
     */
    public void setBtnKarteikartenBearbeitenVisible(boolean visible) {
        btnKarteikartenBearbeiten.setVisible(visible);
    }

    /**
     * Fügt einen ActionListener zur Schaltfläche "Löschen" für Karteikarten hinzu.
     * @param listener Ein ActionListener, der aufgerufen wird, wenn die Schaltfläche "Löschen" geklickt wird.
     */
    public void addBtnKarteikartenLoeschenListener(ActionListener listener) {
        btnKarteikartenLoeschen.addActionListener(listener);
    }

    /**
     * Legt fest, ob die Schaltfläche "Löschen" für Karteikarten sichtbar ist oder nicht.
     * @param visible Ein boolescher Wert, der angibt, ob die Schaltfläche sichtbar sein soll (true) oder nicht (false).
     */
    public void setBtnKarteikartenLoeschenVisible(boolean visible) {
        btnKarteikartenLoeschen.setVisible(visible);
    }

	
}

