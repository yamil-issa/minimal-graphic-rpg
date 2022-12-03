package rpgSwing;

public class MoveModel{

	private final int boardRows = 5, boardCols = 5, squareSize = 50;
	int playerX = 0;
	private int playerY = 200;
	private final int playerSize =25;
	int getPlayerX() {  return playerX; }

	void setPlayerX(final int playerX) {  this.playerX = playerX; }

	int getPlayerY() {return playerY;   }

	void setPlayerY(final int playerY) {  this.playerY = playerY; }

	int getPlayerSize() {return playerSize; }

	int getBoardRows() {return boardRows; }

	int getBoardCols() {return boardCols; }

	int getSquareSize() {return squareSize; }
}