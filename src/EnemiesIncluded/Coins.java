package EnemiesIncluded;

import org.newdawn.slick.Image;

public class Coins extends GameState {
	
	public int Cx;//Change
	public int Cy;//Change

	public void draw(Image image) {
		image.draw(Cx, Cy);
		System.out.println("COIN DRAWN");
	}
	
	
}
