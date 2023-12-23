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
import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

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

        btnNeueKarteikarteErstellen = new JButton("neue Karteikarte erstellen");
        btnNeueKarteikarteErstellen.setBackground(new Color(251, 251, 246));
        btnNeueKarteikarteErstellen.addActionListener(this);

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(btnNeueKarteikarteErstellen, BorderLayout.WEST);

        JPanel rightPanel = new JPanel(new BorderLayout());

        String[] columnNames = {"Titel", "Inhalt", "Kategorie"};
        Object[][] data = {}; // Hier sollten die Daten aus dem KarteiContainer geladen werden
        tableModel = new DefaultTableModel(data, columnNames);
        karteikartenTabelle = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(karteikartenTabelle);
        btnKarteikartenBearbeiten = new JButton("Karteikarten bearbeiten");
        topPanel.add(btnKarteikartenBearbeiten, BorderLayout.CENTER);
        btnKarteikartenLoeschen = new JButton("Karteikarten löschen");
        topPanel.add(btnKarteikartenLoeschen, BorderLayout.EAST);
        GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
        groupLayout.setHorizontalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addComponent(topPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        		.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, 567, GroupLayout.PREFERRED_SIZE)
        );
        groupLayout.setVerticalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addComponent(topPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addComponent(scrollPane, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
        frame.getContentPane().setLayout(groupLayout);

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
