package rpgSwing;

import javax.swing.*;

public class Story {
	public static JLabel printIntro() {
		
		JLabel intro = new JLabel("<html>Nous somme dans le royaume de sith, vous êtes le dernier survivant de l'attatque de votre village par une horde de creatures à la solde du nameless King.<br>"
				+ "votre famille vos amis sont tous mort, mort vous l'etiez egalement mais une force obsucure vous a ramené dans le monde des vivant<br>"
				+ "Vous n'avez plus qu'un seul objectif defaire le nameless King et obtenir vore revanche<html>");
		return intro;
		
    	}
	
	public static void printFirstActIntro() {
		
		JLabel firstActLine = new JLabel("Votre quête de vengeance debute, vous traversez la foret afin de sortir du village ");
		}
	public static void printFirstActOutro() {
		JLabel firstActOutroLine = new JLabel("Vous sortez du village, vous vous dirigez à present vers le chateau du namless King ");
		}
	public static void printSecondActIntro() {
		JLabel secondActIntroLine = new JLabel("vous arrivez à l'acdemie d'Aria lucaria ");
	
	}
	public static void printSecondActOutro() {
		JLabel secondAcOutrotLine = new JLabel("Vous êtes arrivé devant le chateau du nameless King");
		
	}
	
	/*public static void printEnd(Player player) {
		if(player.getCharacterHp() <= 0) {
			GameLoop.playerDied();
		}else {
			GameLoop.clearConsole();
			GameLoop.printSeparator(30);
			System.out.println("Bravo," + player.getCharacterName() + "! Vous avez reussi à vaincre le nameless King, le mal ne rongera plus le royaume, vous pouvez desormais reposer en paix");
			GameLoop.printSeparator(30);
			System.out.println("Jeu developpé dans le cadre de la licence pro projet web et mobile");
			System.out.println("Merci d'avoir joué");
			GameLoop.toContinue();
		}
		
	}
  */

}
