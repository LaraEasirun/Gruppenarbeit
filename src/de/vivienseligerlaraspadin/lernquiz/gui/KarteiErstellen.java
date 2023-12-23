package de.vivienseligerlaraspadin.lernquiz.gui;


	import javax.swing.JFrame;
	import javax.swing.JPanel;
	import javax.swing.JLabel;
	import javax.swing.JTextField;
	import javax.swing.JButton;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;

	public class KarteiErstellen {

	    private JFrame frame;
	    private JTextField frageTextField;
	    private JTextField antwortTextField;
	    private JTextField kategorieTextField;
	    private JTextField schwierigkeitTextField;

	    public KarteiErstellen() {
	        frame = new JFrame("Karteikarte erstellen");
	        JPanel panel = new JPanel();
	        panel.setLayout(null);

	        JLabel frageLabel = new JLabel("Frage:");
	        frageLabel.setBounds(20, 20, 100, 20);
	        panel.add(frageLabel);

	        frageTextField = new JTextField();
	        frageTextField.setBounds(130, 20, 200, 20);
	        panel.add(frageTextField);

	        JLabel antwortLabel = new JLabel("Antwort:");
	        antwortLabel.setBounds(20, 50, 100, 20);
	        panel.add(antwortLabel);

	        antwortTextField = new JTextField();
	        antwortTextField.setBounds(130, 50, 200, 20);
	        panel.add(antwortTextField);

	        JLabel kategorieLabel = new JLabel("Kategorie:");
	        kategorieLabel.setBounds(20, 80, 100, 20);
	        panel.add(kategorieLabel);

	        kategorieTextField = new JTextField();
	        kategorieTextField.setBounds(130, 80, 200, 20);
	        panel.add(kategorieTextField);

	        JLabel schwierigkeitLabel = new JLabel("Schwierigkeit:");
	        schwierigkeitLabel.setBounds(20, 110, 100, 20);
	        panel.add(schwierigkeitLabel);

	        schwierigkeitTextField = new JTextField();
	        schwierigkeitTextField.setBounds(130, 110, 200, 20);
	        panel.add(schwierigkeitTextField);

	        JButton erstellenButton = new JButton("Erstellen");
	        erstellenButton.setBounds(150, 150, 100, 30);
	        erstellenButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                // Hier können Sie die Karteikarte erstellen und speichern
	                String frage = frageTextField.getText();
	                String antwort = antwortTextField.getText();
	                String kategorie = kategorieTextField.getText();
	                int schwierigkeit = Integer.parseInt(schwierigkeitTextField.getText());

	                // Hier können Sie Ihre Karteikarte speichern oder weitere Aktionen ausführen

	                // Schließen Sie das Fenster nach der Erstellung
	                frame.dispose();
	            }
	        });
	        panel.add(erstellenButton);

	        frame.add(panel);
	        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        frame.setSize(400, 250);
	        frame.setVisible(true);
	    }
	}

