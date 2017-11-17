package main;

public class GameManager {

	boolean isTutorial = true;

	private String[] validCommands = { "look", "n", "north", "e", "east", "s", "south", "w", "west" };

	public double distanceToTreasure(Object a, Object b) {
		double toReturn = Math.abs(Math.hypot(a.getObjPosX() - b.getObjPosX(), a.getObjPosY() - b.getObjPosY()));

		return toReturn;
	}

	public String playerMove(Player player, String dir) {
		String toReturn = "";
		if (dir.toLowerCase().equals("north") || dir.toLowerCase().equals("n")) {
			player.setObjPosY(player.getObjPosY() + 1);
			toReturn = "Moved North";
			//player.setScore(player.getScore() - 1);
		}
		if (dir.toLowerCase().equals("south") || dir.toLowerCase().equals("s")) {
			player.setObjPosY(player.getObjPosY() - 1);
			toReturn = "Moved South";
			//((Player) player).setScore(((Player) player).getScore() - 1);
		}
		if (dir.toLowerCase().equals("east") || dir.toLowerCase().equals("e")) {
			player.setObjPosX(player.getObjPosX() + 1);
			toReturn = "Moved East";
			//player.setScore(player.getScore() - 1);
		}
		if (dir.toLowerCase().equals("west") || dir.toLowerCase().equals("w")) {
			player.setObjPosX(player.getObjPosX() - 1);
			toReturn = "Moved West";
			//player.setScore(player.getScore() - 1);
		}

		return toReturn;
	}

	public String manageInput(Object player, Object b, String input) {
		String toReturn = "";
		boolean isValid = false;

		if (isTutorial)
			if (isTutorial) {
				isTutorial = false;
				return toReturn = "You notice a small watch-like device in your left hand. "
						+ "\nIt has hands like a watch, but the hands don't seem to tell time.";
			}

		for (String i : validCommands) {
			if (input.toLowerCase().equals(i.toLowerCase())) {
				isValid = true;
				break;
			} else {
				toReturn = "Nothing seems to happen";
			}
		}

		if (isValid) {
			if (input.toLowerCase().equals("look")) {
				toReturn = "The treasure is : " + Math.round((distanceToTreasure(player, b)* 100.0) / 100.0) + "m away!";

			} else {
				toReturn = playerMove((Player) player, input);
			}
		}

		return toReturn;
	}

}
