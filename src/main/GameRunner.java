package main;

import java.util.Scanner;

public class GameRunner {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		GameManager gm = new GameManager();
		ItemManager im = new ItemManager();
		boolean finishedSetup = false;
		int mapSize = 0;
		Object player = null;
		Object goal = null;

		// game setup
		while (!finishedSetup) {
			System.out.println("Input size of map. 10 is tiny, 2000 is reeeeallly big\nThere are no map limits whichever you choose");
			try {
				mapSize = Integer.parseInt(sc.nextLine());
				player = new Player(mapSize);
				goal = new Treasure(mapSize, true);

				while (player.getObjPosX() == goal.getObjPosX() || player.getObjPosY() == goal.getObjPosY()) {
					goal = new Treasure(mapSize, true);
				}
				finishedSetup = true;
				
			} catch (NumberFormatException nfe) {
				System.out.println("Input was not an integer. " + nfe);
			}
		} // game setup
		
		im.listGeneration(mapSize, (int)Math.round(mapSize/3 + 1));
		
		System.out.println("GAME START");
		System.out.println();
		System.out.println();
		System.out.println("You awaken to find yourself in a barren moor.  Try \"look\".");

		// main play loop
		while (gm.distanceToTreasure(player, goal) != 0) // fix this issue, its returning 0 when it shouldn't
		{
			String input = sc.nextLine();
			System.out.println(gm.manageInput(player, goal, input));
			
			//check if player is on top of an item
			//pickup item
			if(im.checkIfPlayerIsOnTopOfItem(player)) {
			((Player)player).addItem(im.pickUp());
			}
			
		} // main play loop

		System.out.println(
				"You see a box sitting on the plain.\nIts filled with treasure!\nYou win!\nThe end.\n\nYou have a score of : "
						+ ((Player) player).getScore());
		sc.close();
	}

}
