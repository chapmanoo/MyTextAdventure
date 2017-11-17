package main;

import java.util.ArrayList;

public class Player extends Object {

	private int score = 100;
	private ArrayList<Item> playerItems = new ArrayList<Item>();
	private boolean isOnTopOfItem = false;

	public boolean isOnTopOfItem() {
		return isOnTopOfItem;
	}

	public void setOnTopOfItem(boolean isOnTopOfItem) {
		this.isOnTopOfItem = isOnTopOfItem;
	}

	public Player(int mapSize) {
		super(mapSize);

	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	public void addItem(Item i)
	{
		try {
			playerItems.add(i);
			score += i.getScoreValue();
		} catch (Exception e)
		{
			return;
		}
	}
	

}
