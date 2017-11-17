package main;

import java.util.Random;
import java.util.Vector;

public class Object {

	private int objPosX;
	private int objPosY;
	private Vector<Integer> objectPosition = new Vector<Integer>();

	public Object(int mapSize) {
		super();
		this.objPosX = generateNumber(mapSize);
		this.objPosY = generateNumber(mapSize);
		this.objectPosition = new Vector<Integer>(this.objPosX, this.objPosY);
	}

	public int generateNumber(int mapSize) {
		int toReturn = 0;
		Random rand = new Random();

		toReturn = rand.nextInt(mapSize) + 1;

		return toReturn;
	}

	public int getObjPosX() {
		return objPosX;
	}

	public void setObjPosX(int objPosX) {
		this.objPosX = objPosX;
	}

	public int getObjPosY() {
		return objPosY;
	}

	public void setObjPosY(int objPosY) {
		this.objPosY = objPosY;
	}

	public Vector<Integer> getObjectPosition() {
		return objectPosition;
	}

	public void setObjectPosition(Vector<Integer> objectPosition) {
		this.objectPosition = objectPosition;
	}

}
