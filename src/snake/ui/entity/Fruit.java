package snake.ui.entity;

import java.awt.image.BufferedImage;

@SuppressWarnings("serial")
public class Fruit extends Item {
	
	private int value, special;
	private String name;
	
	public Fruit(BufferedImage resource, int x, int y, int width, int height, String name, int value, int special) {
		super (resource, x, y, width, height);
		this.name = name;
		this.value = value;
		this.special = special;
	}
	
	public int getValue() {
		return value;
	}
	
	public int getSpecial() {
		return special;
	}
	
	public String getName() {
		return name;
	}

	@Override
	protected void onSpawn() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onDespawn() {
		// TODO Auto-generated method stub
		
	}

}
