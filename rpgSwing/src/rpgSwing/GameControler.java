package rpgSwing;


import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class GameControler  {

   
  
    
    public static JPanel createMainPanel() {
        JPanel panel = new JPanel(new GridLayout(0, 5));
        panel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        
        for (int index = 0; index < 25; index++) {
            JButton button = new JButton();
            button.setPreferredSize(new Dimension(64, 64));
            panel.add(button);
        }
        
        return panel;
    }

}