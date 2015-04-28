package CoinsIncluded;

import org.newdawn.slick.Image;

public class Enemies {
	public int x, y, speedMax, health;
	public float speedX, speedY;

	public void draw(Image image) {
		image.draw(x, y);
		
	}
}
