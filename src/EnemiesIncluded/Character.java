package EnemiesIncluded;

import org.newdawn.slick.Image;

public class Character extends GameState{
	
	public int x, y, speedMax;
	public float speedX, speedY;

	public void load (){
		x = X/2-mario.getWidth()/2;
		y = bottom-mario.getHeight();
		speedX = 0.0f;
		speedY = 0.0f;
		speedMax = 5;
	}
	public void draw(Image image) {
		image.draw(x, y);
	}

}
