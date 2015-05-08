package EnemiesIncluded;

import org.newdawn.slick.Image;

public class Character extends GameState{
	
	//storing properties of mario
	public int x, y, speedMax;
	public float speedX, speedY;

	//loading properties
	public void load (){
		x = X-mario.getWidth();
		y = bottom-mario.getHeight();
		speedX = 0.0f;
		speedY = 0.0f;
		speedMax = 5;
	}
	
	//Drawing mario and placing it in its position
	public void draw(Image image) {
		image.draw(x, y);
	}
}
