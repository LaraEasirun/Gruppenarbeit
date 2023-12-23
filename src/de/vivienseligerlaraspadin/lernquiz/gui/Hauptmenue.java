package de.vivienseligerlaraspadin.lernquiz.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Color;

public class Hauptmenue implements ActionListener {

    JFrame frame = new JFrame("Willkommen bei deiner Karteikarten Lernapp");
    private final JButton btnNewButton = new JButton("Karteikarten einsehen");
    private final JButton btnNewButton_1 = new JButton("Kategorien");
    private final JButton btnNewButton_2 = new JButton("Karteikarten lernen/abfragen");
    
    Hauptmenue (){
        frame.getContentPane().setBackground(new Color(253, 254, 253));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(505, 319);
        GridBagConstraints gbcButtons = new GridBagConstraints();
        gbcButtons.fill = GridBagConstraints.HORIZONTAL;
        gbcButtons.insets = new Insets(5, 5, 5, 5);
        
        JLabel lblNewLabel = new JLabel("Willkommen bei deiner Karteikarten Lernapp ");
        GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
        groupLayout.setHorizontalGroup(
        	groupLayout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addContainerGap(150, Short.MAX_VALUE)
        			.addComponent(btnNewButton)
        			.addGap(175))
        		.addGroup(groupLayout.createSequentialGroup()
        			.addGap(131)
        			.addComponent(btnNewButton_2)
        			.addContainerGap(149, Short.MAX_VALUE))
        		.addGroup(groupLayout.createSequentialGroup()
        			.addGap(189)
        			.addComponent(btnNewButton_1)
        			.addContainerGap(205, Short.MAX_VALUE))
        		.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
        			.addGap(104)
        			.addComponent(lblNewLabel)
        			.addContainerGap(119, Short.MAX_VALUE))
        );
        btnNewButton.setBackground(new Color(213, 251, 216));
        btnNewButton_2.setBackground(new Color(250, 128, 114));
        btnNewButton_1.setBackground(new Color(135, 206, 235));
        groupLayout.setVerticalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addGap(32)
        			.addComponent(lblNewLabel)
        			.addGap(74)
        			.addComponent(btnNewButton)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(btnNewButton_2)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(btnNewButton_1)
        			.addContainerGap(70, Short.MAX_VALUE))
        );
        frame.getContentPane().setLayout(groupLayout);
        
        frame.setVisible(true);
         btnNewButton.addActionListener(this);
        
    }

	@Override
	public void actionPerformed(ActionEvent e) {
    if (e.getSource() == btnNewButton) {
		      frame.dispose();
		     new KarteiEinsehen();
		            
		        }
	}
}

