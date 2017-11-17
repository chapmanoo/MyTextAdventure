package main;

public class Treasure extends Object {

	private boolean isGoal = false;

	public Treasure(int mapSize, boolean isGoal) {
		super(mapSize);
		this.isGoal = isGoal;

	}

	public boolean isGoal() {
		return isGoal;
	}

	public void setGoal(boolean isGoal) {
		this.isGoal = isGoal;
	}

}
