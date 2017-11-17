package main;

public class Item extends Object{
	
	private String itemName;
	private int scoreValue;
	
	public Item(int mapSize, String itemName, int scoreValue) {
		super(mapSize);
		this.itemName = itemName;
		this.scoreValue = scoreValue;
		// TODO Auto-generated constructor stub
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getScoreValue() {
		return scoreValue;
	}

	public void setScoreValue(int scoreValue) {
		this.scoreValue = scoreValue;
	}

}
