package rpgSwing;

public class Weapon {
	private String name;
	private int damagePoints;
	
	public Weapon(String name, int damagePoints) {
		this.name = name;
		this.damagePoints = damagePoints;
		
	}
	
	public String getWeaponName() {
		return this.name;
	}
	public int getWeaponDamagePoints() {
		return this.damagePoints;
	}

}