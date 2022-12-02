package rpgSwing;

public abstract class Character {
	protected String name;
	protected int maxHp, hp, xp;
	
	//character conctructor
	public Character(String name, int maxHp, int xp) {
		this.name = name;
		this.maxHp = maxHp;
		this.xp = xp;
		this.hp = maxHp;
		
	}
	public String getCharacterName(){
		return this.name;
		
	}
	public int getCharacterHp(){
		return this.hp;
		
	}
	public int setCharacterHp(int neWhp) {
		this.hp = neWhp;
		return this.hp;
	}
	public int getCharacterMaxHp(){
		return this.maxHp;
		
	}
	public int getCharacterXp(){
		return this.xp;
		
	}
	public int getDamage(int dmg) {
		return this.hp -= dmg;
	}
	public int gainXp(int gain) {
		return this.xp += gain;
	}
    public abstract int attack();
    public abstract int defend();
}
