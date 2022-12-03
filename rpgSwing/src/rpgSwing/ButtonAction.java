package rpgSwing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class ButtonAction implements ActionListener {
	private JTextField textField;
	private String textFieldName;
	
	public ButtonAction(JTextField  field) {
		this.textField = field;

	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {
		if(actionEvent.getSource().getClass() == JButton.class) {
			this.textFieldName = this.textField.getText();
			getTextFieldInfo();
			JFrame secondFrame = new JFrame();
			secondFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			secondFrame.setSize(1000, 1000);
			JPanel secondPanel = new JPanel();
			JButton goButton = new JButton("go");
			
			GoButton renderMap = new GoButton();
			
			goButton.addActionListener(renderMap);
			secondPanel.add(Story.printIntro());
			secondPanel.add(goButton);
			goButton.addActionListener(null);
			
			secondFrame.add(secondPanel);
			//secondFrame.add(GameControler.createMainPanel());
			secondFrame.validate();
			secondFrame.setVisible(true);

		}
		
	}
	public String getTextFieldInfo() {
		return this.textFieldName;
	}

}
