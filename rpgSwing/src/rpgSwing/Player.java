package rpgSwing;

import java.util.ArrayList;

public class Player extends Character {
	private int numAttackUpgrades, numDefUpgrades;
	
	private int gold, restsLeft, pots;
	private String chosenClass;
	
	private Weapon[] playerWeapons = new Weapon[6];
	
    private ArrayList<Weapon> playerWeaponsBought = new ArrayList<Weapon>();
    
	private String[] attackUpgrades = {"Strength", "Power", "Might", "Godlike Strength"};
	private String[] defUpgrades = {"Heavy Bones", "stoneskin", "scale Armor", "Holy Aura"};
	
	static String[] playerClass = {"sorcier", "chevalier", "mendiant"};
	
	private int x = 0;
	private int y = 4;
	
    
	//player constructor
	public Player(String name, String pClass) {
		super(name, 100, 0);
		this.numAttackUpgrades = 0;
		this.numDefUpgrades = 0;
		this.gold = 5;
		this.restsLeft = 1;
		this.pots = 0;
		this.chosenClass = pClass ;
		this.playerWeapons[0] = new Weapon("épée du hero", 1);
		this.playerWeapons[1] = new Weapon("épée du hero", 2);
		this.playerWeapons[2] = new Weapon("hallebarde", 3);
		this.playerWeapons[3] = new Weapon("hallebarde", 3);
		this.playerWeapons[4] = new Weapon("lance sacrée", 4);
		this.playerWeapons[5] = new Weapon("lance sacrée", 4);
		
	}
	
	static String[] getPlayerClassArray() {
		return playerClass;
	}
	
	public int getPlayerXposition() {
		return this.x;
		
	}
	
    public int getPlayerYposition() {
    	return this.y;
	}
    
    public void setPositivePlayerXPosition() {
    	this.x++;
    }
    public void setPositivePlayerYPosition() {
    	this.y++;
    }
    public void setNegativePlayerXPosition() {
    	this.x--;
    }
    public void setNegativePlayerYPosition() {
    	this.y--;
    }
    

	@Override
	public int attack() {
		
		return (int) (Math.random()*(xp/2 + numAttackUpgrades + 3));
	}

	@Override
	public int defend() {
		return (int) (Math.random()*(xp/4 + numDefUpgrades + 3));
		
	}
	public int getNumAttackUpgrades() {
		return this.numAttackUpgrades;
	}
	public int getNumDefUpgrades() {
		return this.numAttackUpgrades;
	}
    public int restoreHp(int hpRestored) {
    	return this.hp += hpRestored;
    }
	public String[] getAttackUpgrades() {
		return this.attackUpgrades;
	}
	public String[] getDefUpgrades() {
		return this.defUpgrades;
	}
	public int getGold() {
		return this.gold;
	}
	public int getPots() {
		return this.pots;
	}
	public int getRestsLeft() {
		return this.restsLeft;
	}
	public int setRestsLeft() {
		return this.restsLeft++;
	}
	public int setGold(int goldEarned) {
		return this.gold += goldEarned;
	}
	public int setPots() {
		return this.pots++;
	}
	public int buy(int price) {
		return this.gold -= price;
	}
	public int useRests() {
		return this.restsLeft--;
	}
	public void buyWeapon(Weapon weaponBought) {
		this.playerWeaponsBought.add(weaponBought);
		this.numAttackUpgrades += weaponBought.getWeaponDamagePoints();
		
	}
	
	public Weapon getWeapon(int numWeapon) {
		return this.playerWeapons[numWeapon];
	}
	/*public void renderWeaponBought() {
		for(Weapon elem: this.playerWeaponsBought)
	       {
	       	 System.out.println (elem.getWeaponName());
	       	 
	       }
		
	}
	*/
	
	/*public void chooseClass() {
		
	}
	*/
	
	public String getChosenClass(){
		return this.chosenClass;
	}

}
