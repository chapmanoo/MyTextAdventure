package main;

import java.util.LinkedList;
import java.util.Random;

public class ItemManager {

	private boolean isListGenerated = false;
	private LinkedList<Item> itemList = new LinkedList<Item>();
	private Item itemOnTopOf = null;

	// private ArrayList<String> prefix = new ArrayList<String>();
	// private ArrayList<String> describe = new ArrayList<String>();
	//
	private String[] describer = { "a big", "a small", "a wet", "a bloody", "an old", "a beaten" };
	private String[] object = { "jug", "sword", "goblet", "stick", "book", "cauldron" };

	public boolean addItem(Item i) {
		try {
			itemList.add(i);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void removeItem(Item i) {
		try {
			for(Item item : itemList)
			{
				if(item.equals(i))
				{
					itemList.remove(itemList.indexOf(item));
				}
			}
		} catch (Exception e) {
		}
	}

	public LinkedList<Item> getItemList() {
		return itemList;
	}

	public void listGeneration(int mapSize, int itemsToMake) {
		if (!isListGenerated) {
			for (int i = 0; i < itemsToMake; i++) {
				isListGenerated = true;
				addItem(generateItem(mapSize));
			}
		}
	}

	private Item generateItem(int mapSize) {

		String itemName = itemNameCreator();
		int score = scoreCreator(itemName);
		Item toReturn = new Item(mapSize, itemName, score);

		return toReturn;
	}
	
	private int scoreCreator(String itemName) {
		int toReturn = itemName.length() * 2;
				
		return toReturn;
	}

	private String itemNameCreator() {
		String toReturn = "";
		int indexA = new Random().nextInt(describer.length);
		toReturn += describer[indexA] + " ";

		indexA = new Random().nextInt(object.length);
		toReturn += object[indexA] + " ";

		System.out.println(toReturn);
		return toReturn;
	}

	public boolean checkIfPlayerIsOnTopOfItem(Object player) {
		for(Item i : itemList)
		{
			if (player.getObjPosX() == i.getObjPosX() && player.getObjPosY() == i.getObjPosY())
			{
				System.out.println("You found " + i.getItemName());
				itemOnTopOf = i;
				itemList.remove(itemList.indexOf(i));
				return true;
			}
		}
		return false;
	}
	
	public Item pickUp() {
		return itemOnTopOf;
	}

}
