package EnemiesIncluded;

import org.newdawn.slick.Image;

public class Coins extends GameState {
	
	public static int Cx=400;
	public static int Cy=400;

	public void draw(Image image) {
		image.draw(Cx, Cy);
		System.out.println("COIN DRAWN");
	}
	

}
