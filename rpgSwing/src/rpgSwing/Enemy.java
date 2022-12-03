package rpgSwing;

public class Enemy extends Character {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int playerXp;

	public Enemy(String name, int playerXp) {
		super(name, (int) (Math.random()* playerXp + playerXp/3 + 5), (int) (Math.random()*(playerXp/4 + 2) + 1));
		this.playerXp = playerXp;
		
	}

	@Override
	public int attack() {
		return (int) (Math.random()*(playerXp/4 + 3));
	}

	@Override
	public int defend() {
		return (int) (Math.random()*(playerXp/4 + 1));
	}

}
