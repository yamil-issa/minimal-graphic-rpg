package rpgSwing;

import java.awt.FlowLayout;

import javax.swing.*;


public class GameLoop {
	private static JFrame window = new JFrame("Age of Darkness");
	private static JPanel mainPanel = new JPanel();
	private static String playerName;
	private static String playerClass;
	
	public static JPanel getPanel() {
		return GameLoop.mainPanel;
		
	}
	
	public static JFrame getWindow() {
		return GameLoop.window;
		
	}
	public static void gameStart() {
		
		window.setSize(1000, 1000);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainPanel.setLayout(new FlowLayout());
		
		JLabel mainLablel = new JLabel("Age of Darkness");
		JLabel secondLabel = new JLabel("A game made by Issa Yamil");
		JLabel thirdLabel = new JLabel("Choisissez une classe");
		
		JTextField playerName = new JTextField(20);

	    
		JButton playerNameButton = new JButton("Confirmer");
		
		ButtonAction infoPlayerName = new ButtonAction(playerName);
		
		
		 JComboBox<String> cb = new JComboBox<String>(Player.getPlayerClassArray());
		 
		String classValue = cb.getSelectedItem().toString();
		Player player = new Player(infoPlayerName.getTextFieldInfo(), classValue);
		
		GameLoop.playerName = player.getName();
		GameLoop.playerName = player.getChosenClass();

		
		playerNameButton.addActionListener(infoPlayerName);
        		
       
		mainPanel.add(mainLablel);
		mainPanel.add(secondLabel);
		mainPanel.add(playerName);
		mainPanel.add(thirdLabel);
		mainPanel.add(cb);
		mainPanel.add(playerNameButton);
		window.add(mainPanel);
		window.validate();
		window.setVisible(true);
	}
	
	public static String getPlayerNameGlobal() {
		return GameLoop.playerName;
	}
    
	public static String getPlayerClassGlobal() {
		return GameLoop.playerClass;
	}

}
