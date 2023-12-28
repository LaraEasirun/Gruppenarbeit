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

import de.vivienseligerlaraspadin.lernquiz.core.KartenManager;
import de.vivienseligerlaraspadin.lernquiz.core.*;

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
    private List<Karteikarte> karteikartenListe;

    public KarteiEinsehen() {
        frame = new JFrame("Karteikarten Einsehen");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        btnNeueKarteikarteErstellen = new JButton("+");
        btnNeueKarteikarteErstellen.setBackground(new Color(251, 251, 246));
        btnNeueKarteikarteErstellen.addActionListener(this);

        JPanel topPanel = new JPanel(new BorderLayout());
        topPanel.add(btnNeueKarteikarteErstellen, BorderLayout.WEST);

        JPanel rightPanel = new JPanel(new BorderLayout());

       // String[] columnNames = {"Frage", "Antwort", "Kategorie", "Schwierigkeit"};
       // Object[][] data = {}; 
        String[] columnNames = {"Frage", "Antwort", "Kategorie", "Schwierigkeit"};
        karteikartenListe = KartenManager.zeigeAlleKarteikarten(); // Angenommen, es gibt eine Klasse KarteikartenManager
        Object[][] data = new Object[karteikartenListe.size()][columnNames.length];
        for (int i = 0; i < karteikartenListe.size(); i++) {
            Karteikarte karte = karteikartenListe.get(i);
            data[i][0] = karte.getFrage();
            data[i][1] = karte.getAntwort();
            data[i][2] = karte.getKategorie();
            data[i][3] = karte.getSchwierigkeit();
        }
        tableModel = new DefaultTableModel(data, columnNames);
        karteikartenTabelle = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(karteikartenTabelle);
        btnKarteikartenBearbeiten = new JButton("🖊️");
        topPanel.add(btnKarteikartenBearbeiten, BorderLayout.CENTER);
        btnKarteikartenLoeschen = new JButton("🗑️");
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
   

