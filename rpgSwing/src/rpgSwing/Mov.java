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
    
	private void battle(Enemy enemy) {
		
		
	}
	

	 
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
			add(new PlayerPanel());
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

		private static Player finalPlayer;
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

			player = new FinalPlayer(ButtonAction.getGlobalPlayerInfo().getCharacterName(), ButtonAction.getGlobalPlayerInfo().getChosenClass());
			BoardPanel.finalPlayer = player;
			player.setBounds(new Rectangle(1000,1000, 1000,1000));
			/*System.out.println(player.getCharacterName());
			System.out.println(player.getChosenClass());
			*/
		}

		@Override
		protected void paintComponent(final Graphics g) {
			super.paintComponent(g);
			player.paint(g);
		}
		
		public static Player getFinalPlayer() {
			return BoardPanel.finalPlayer;
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
		JButton moveWestButton =new JButton("Gauche");
		JButton moveDownButton =new JButton("Bas");
		JButton moveUpButton =new JButton("Haut");


		BottomPanel(){
			add(moveEastButton, BorderLayout.EAST);
			add(moveWestButton, BorderLayout.WEST);
			add(moveDownButton, BorderLayout.SOUTH);
			add(moveUpButton, BorderLayout.NORTH);

		}

		JButton getMoveEastButton() { return moveEastButton; }
		JButton getMoveDownButton() { return moveDownButton; }
		JButton getMoveWestButton() { return moveWestButton; }
		JButton getMoveUpButton() { return moveUpButton; }


	}
	
 class PlayerPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	JLabel name = new JLabel("nom : " + BoardPanel.getFinalPlayer().getCharacterName() );
	JLabel playerClass = new JLabel("classe: " + BoardPanel.getFinalPlayer().getChosenClass());
	JLabel playerHp = new JLabel("HP: " + BoardPanel.getFinalPlayer().getCharacterHp());
	
	PlayerPanel(){
		add(name);
		add(playerClass);
	}
	 
 }
 
 class BattlePanel extends JPanel{

	private static final long serialVersionUID = 1L;
	
	 
 }
}

