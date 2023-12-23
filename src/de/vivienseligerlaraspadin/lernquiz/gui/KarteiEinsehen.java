package de.vivienseligerlaraspadin.lernquiz.gui;


import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class KarteiEinsehen implements ActionListener {

    private JFrame frame;
    private JTable karteikartenTabelle;
    private DefaultTableModel tableModel;
    private JButton btnNeueKarteikarteErstellen;
    private JButton btnKarteikartenBearbeiten;
    private JButton btnKarteikartenLoeschen;

    public KarteiEinsehen() {
        frame = new JFrame("Karteikarten Einsehen");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        btnNeueKarteikarteErstellen = new JButton("neue Karteikarte erstellen");
        btnNeueKarteikarteErstellen.addActionListener(this);
        btnKarteikartenBearbeiten = new JButton("Karteikarten bearbeiten");
        btnKarteikartenLoeschen = new JButton("Karteikarten löschen");

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(btnNeueKarteikarteErstellen, BorderLayout.WEST);

        JPanel rightPanel = new JPanel(new BorderLayout());
        rightPanel.add(btnKarteikartenBearbeiten, BorderLayout.NORTH);
        rightPanel.add(btnKarteikartenLoeschen, BorderLayout.SOUTH);

        String[] columnNames = {"Titel", "Inhalt", "Kategorie"};
        Object[][] data = {}; // Hier sollten die Daten aus dem KarteiContainer geladen werden
        tableModel = new DefaultTableModel(data, columnNames);
        karteikartenTabelle = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(karteikartenTabelle);

        frame.add(topPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(rightPanel, BorderLayout.EAST);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnNeueKarteikarteErstellen) {
                frame.dispose();
                new KarteiErstellen();
            
        }
    }
}
