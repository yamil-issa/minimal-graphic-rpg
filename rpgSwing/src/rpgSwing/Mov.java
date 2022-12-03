package rpgSwing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Rectangle;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Mov {

	private final MoveModel moveModel;
	private final Showvisible showvisible;
	
		public Mov() {
		moveModel = new MoveModel();
		showvisible = new Showvisible(moveModel);
		showvisible.getMoveWestButton().addActionListener(e-> movePlayerXNegative(50));
		showvisible.getMoveEastButton().addActionListener(e-> movePlayerX(50));
		showvisible.getMoveDownButton().addActionListener(e-> movePlayerYNegative(50));
		showvisible.getMoveUpButton().addActionListener(e-> movePlayerY(50));
		
		
	}


	//Move player in the x direction to the East (positive) or west (negative 
	private void movePlayerX(final int distance) {
		moveModel.setPlayerX(moveModel.getPlayerX()+distance);
		showvisible.refresh();
	}
	
	private void movePlayerXNegative(final int distance) {
		moveModel.setPlayerX(moveModel.getPlayerX()-distance);
		showvisible.refresh();
	}
	
	private void movePlayerY(final int distance) {
		moveModel.setPlayerY(moveModel.getPlayerY()-distance);
		showvisible.refresh();
	}
	
	private void movePlayerYNegative(final int distance) {
		moveModel.setPlayerY(moveModel.getPlayerY()+distance);
		showvisible.refresh();
	}
	
 
}

class Showvisible {

	private final static int GAP = 2;
	MoveModel MoveModel;
	private MainPanel mainPanel;

	Showvisible(final MoveModel MoveModel){
		this.MoveModel = MoveModel;
		createAndShowGUI();
	}

	void refresh() {
		mainPanel.repaint();
	}


	private void createAndShowGUI() {
		final JFrame board = new JFrame("Age Of Darkness ");
		board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainPanel = new MainPanel();
		board.add(mainPanel);
		board.pack();
		board.setVisible(true);
	}

	JButton getMoveEastButton() { return mainPanel.getMoveEastButton(); }
	JButton getMoveDownButton() { return mainPanel.getMoveDownButton(); }
	JButton getMoveWestButton() { return mainPanel.getMoveWestButton(); }
	JButton getMoveUpButton() { return mainPanel.getMoveUpButton(); }

	class MainPanel extends JPanel {
		private static final long serialVersionUID = 1L;
		private final BottomPanel bPanel;

		MainPanel() {
			
			add(new BoardPanel());
			bPanel = new BottomPanel();
			add(bPanel, new BorderLayout());
		}

		JButton getMoveEastButton() { return bPanel.getMoveEastButton(); }
		JButton getMoveDownButton() { return bPanel.getMoveDownButton(); }
		JButton getMoveWestButton() { return bPanel.getMoveWestButton(); }
		JButton getMoveUpButton() { return bPanel.getMoveUpButton(); }


	}

	class TopPanel extends JPanel {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		
	}

	class BoardPanel extends JPanel {

		
		private static final long serialVersionUID = 1L;
		Player player;

		BoardPanel()   {

			setBorder(BorderFactory.createLineBorder(Color.BLACK, GAP));
			final GridLayout layout = new GridLayout(MoveModel.getBoardRows(),
					MoveModel.getBoardCols());
			setLayout(layout);

			for (int i = 0; i <MoveModel.getBoardRows(); i++)   {

				for (int j = 0; j < MoveModel.getBoardCols(); j++)  {
					add(new Tile());
				}
			}

			player = new FinalPlayer(GameLoop.getPlayerNameGlobal(), GameLoop.getPlayerClassGlobal());
			player.setBounds(new Rectangle(1000,1000, 1000,1000));
		}

		@Override
		protected void paintComponent(final Graphics g) {
			super.paintComponent(g);
			player.paint(g);
		}
	}

	class Tile extends JLabel {

		private static final long serialVersionUID = 1L;

		Tile() {
			setPreferredSize(new Dimension(MoveModel.getSquareSize(), MoveModel.getSquareSize()));
			setBorder(BorderFactory.createLineBorder(Color.GRAY, GAP));
		}
	}

	class FinalPlayer extends Player{

		public FinalPlayer(String name, String pClass) {
			super(name, pClass);
			// TODO Auto-generated constructor stub
		}

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		@Override
		protected void paintComponent(final Graphics g) {
			super.paintComponent(g);
			g.setColor(Color.BLUE);
			g.fillRect(MoveModel.getPlayerX(), MoveModel.getPlayerY(), MoveModel.getPlayerSize(),MoveModel.getPlayerSize());
		}
	}

	class BottomPanel extends JPanel {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		JButton moveEastButton =new JButton("Droite");
		JButton moveDownButton =new JButton("Bas");
		JButton moveWestButton =new JButton("Gauche");
		JButton moveUpButton =new JButton("Haut");


		BottomPanel(){
			add(moveEastButton, BorderLayout.EAST);
			add(moveDownButton, BorderLayout.SOUTH);
			add(moveWestButton, BorderLayout.WEST);
			add(moveUpButton, BorderLayout.NORTH);

		}

		JButton getMoveEastButton() { return moveEastButton; }
		JButton getMoveDownButton() { return moveDownButton; }
		JButton getMoveWestButton() { return moveWestButton; }
		JButton getMoveUpButton() { return moveUpButton; }


	}
}

