package rpgSwing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ButtonAction implements ActionListener {
	private JTextField textField;
	private static String textFieldName;
	private static Player globalPlayer;
		
	public ButtonAction(JTextField  field) {
		this.textField = field;

	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		if(actionEvent.getSource().getClass() == JButton.class) {
			ButtonAction.textFieldName = this.textField.getText();
			
			JFrame secondFrame = new JFrame();
			secondFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			secondFrame.setSize(1000, 1000);
			JPanel secondPanel = new JPanel();
			JButton goButton = new JButton("go");
			
			GoButton renderMap = new GoButton();
			
			Player player = new Player(getTextFieldInfo(), GameLoop.getPlayerClassGlobal());
			globalPlayer = player;
			
			
			goButton.addActionListener(renderMap);
			secondPanel.add(Story.printIntro());
			secondPanel.add(goButton);
			goButton.addActionListener(null);
			
			secondFrame.add(secondPanel);
			secondFrame.validate();
			secondFrame.setVisible(true);

		}
		
	}
	public static String getTextFieldInfo() {
		return ButtonAction.textFieldName;
	}
	
	public static Player getGlobalPlayerInfo() {
		return globalPlayer;
	}
	
	

}
