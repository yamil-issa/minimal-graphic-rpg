package rpgSwing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

public class TestGrid02 {

    public static void main(String[] args) {
        new TestGrid02();
    }

    public TestGrid02() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }
          
                JPanel mainPanel = new JPanel();
                
                mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));
                TestPane panel = new TestPane();
                JPanel buttonJPanel = new JPanel(new BorderLayout());
                JButton buttonUp = new JButton("haut");
                JButton buttonDown = new JButton("bas");
                JButton buttonLeft = new JButton("gauche");
                JButton buttonRight = new JButton("droite");
                
                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setSize(10000, 10000);
                frame.setLayout(new BorderLayout());
                buttonJPanel.add(buttonUp, BorderLayout.NORTH);
                buttonJPanel.add(buttonDown, BorderLayout.SOUTH);
                buttonJPanel.add(buttonLeft, BorderLayout.WEST);
                buttonJPanel.add(buttonRight, BorderLayout.EAST);
                
                
                buttonUp.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						System.out.println("clickUp");
						
					}
                });
                
                buttonDown.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						System.out.println("clickDown");
						
					}
                });
                
                buttonLeft.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						System.out.println("clickLeft");
						
					}
                });
                
                buttonRight.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						System.out.println("clickRight");
						
					}
                });
                   
                
                mainPanel.add(panel);
                mainPanel.add(buttonJPanel);
                
                frame.add(mainPanel);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        /**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public TestPane() {
            setLayout(new GridBagLayout());

            GridBagConstraints gbc = new GridBagConstraints();
            for (int row = 0; row < 5; row++) {
                for (int col = 0; col < 5; col++) {
                    gbc.gridx = col;
                    gbc.gridy = row;

                    CellPane cellPane = new CellPane();
                    Border border = null;
                    if (row < 4) {
                        if (col < 4) {
                            border = new MatteBorder(1, 1, 0, 0, Color.GRAY);
                        } else {
                            border = new MatteBorder(1, 1, 0, 1, Color.GRAY);
                        }
                    } else {
                        if (col < 4) {
                            border = new MatteBorder(1, 1, 1, 0, Color.GRAY);
                        } else {
                            border = new MatteBorder(1, 1, 1, 1, Color.GRAY);
                        }
                    }
                    cellPane.setBorder(border);
                    add(cellPane, gbc);
                }
            }
        }
    }

    public class CellPane extends JPanel {

		private static final long serialVersionUID = 1L;
		private Color defaultBackground;

        public CellPane() {
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseEntered(MouseEvent e) {
                    defaultBackground = getBackground();
                    setBackground(Color.RED);
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    setBackground(defaultBackground);
                }
            });
        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(50, 50);
        }
    }
}