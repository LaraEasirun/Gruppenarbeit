package de.vivienseligerlaraspadin.lernquiz.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Insets;
import javax.swing.JButton;

public class Hauptmenue implements ActionListener {

	
	JFrame frame = new JFrame() ;
	JButton myButton = new JButton("Karteikarte erstellen");
	
	Hauptmenue (){
	GridBagLayout gridBagLayout = new GridBagLayout();
	gridBagLayout.columnWidths = new int[]{100, 200, 0};
	gridBagLayout.rowHeights = new int[]{65, 40, 0, 0};
	gridBagLayout.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
	gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
	frame.getContentPane().setLayout(gridBagLayout);
	myButton.setFocusable(false); 
	myButton.addActionListener(this);
	
	GridBagConstraints gbc_myButton = new GridBagConstraints();
	gbc_myButton.insets = new Insets(0, 0, 5, 0);
	gbc_myButton.fill = GridBagConstraints.BOTH;
	gbc_myButton.gridx = 1;
	gbc_myButton.gridy = 0;
	frame.getContentPane().add(myButton, gbc_myButton);
	
	JButton btnNewButton = new JButton("Karteikarte ansehen");
	GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
	gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
	gbc_btnNewButton.gridx = 1;
	gbc_btnNewButton.gridy = 1;
	frame.getContentPane().add(btnNewButton, gbc_btnNewButton);
	
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(420, 420);
	frame.setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==myButton) {
			frame.dispose();
			new KarteiErstellen();
		}
		
		
	}

	
		
	

}
