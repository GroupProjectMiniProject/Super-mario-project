package TheGame;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.state.StateBasedGame;

public class Enemies {
	public int x, y, speedMax, health;
	public float speedX, speedY;
	private Image evilEnemy = null;


	public void draw(Image image) {
		image.draw(x, y);
	}

	public void update(GameContainer container, StateBasedGame game, int delta) {
		// TODO Auto-generated method stub
		
	}
}
