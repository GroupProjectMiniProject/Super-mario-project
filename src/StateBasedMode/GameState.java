package StateBasedMode;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class GameState extends BasicGameState {
	
	public static int X = 800, Y = 600, jumpSpeed = 12; 
	public static float gravity = 2.0f, acc = 1.2f;
	public Image mario = null;
	public Image background = null;
	public Image platform_basic = null;
	public boolean start = true, jump = false, allowed = true;
	public Character Mario = new Character();
		
	public void init(GameContainer container, StateBasedGame sbg)
			throws SlickException {
		mario = new Image ("data/Mario_Basic.png");
		background = new Image ("data/Background_Basic.bmp");
		platform_basic = new Image ("data/Platform_Basic.bmp");
		
	}
	
	public void update(GameContainer container, StateBasedGame sbg, int delta)
			throws SlickException {
		if (container.getInput().isKeyPressed(Input.KEY_ESCAPE)) sbg.enterState(2, new FadeOutTransition(), new FadeInTransition());

		if (start){
			Mario.x = X/2-mario.getWidth()/2;
			Mario.y = Y-64;
			Mario.health = 1;
			Mario.speedX = 0.0f;
			Mario.speedY = 0.0f;
			Mario.speedMax = 5;
			start = false;
		}
		
		Input input = container.getInput();
		if (input.isKeyDown(Input.KEY_LEFT)){
			if ((int)Mario.speedX == 0 || (int)Mario.speedX > 0) Mario.speedX = -1.0f; else {
				if ((int)Mario.speedX >= -Mario.speedMax) Mario.speedX *= acc;
			}
		} 
		else if (input.isKeyDown(Input.KEY_RIGHT)){
			if ((int)Mario.speedX == 0 || (int)Mario.speedX < 0) Mario.speedX = 1.0f; else {
				if ((int)Mario.speedX <= Mario.speedMax) Mario.speedX *= acc; 
			}
		}
		else {
			if ((int)Mario.speedX != 0) Mario.speedX /= acc;
		}
		
		if (input.isKeyPressed(Input.KEY_UP) && !jump && allowed){
			//if (!jump && allowed) {
				Mario.speedY = -jumpSpeed;
				jump = true;
				allowed = false;
			//}
		} else if (jump) {
			if ((int)Mario.speedY < 0) Mario.speedY /= gravity; else jump = false;
		} else {
			if ((int)Mario.speedY == 0 && !allowed) Mario.speedY = 1.0f; else {
				if (Mario.y < Y-64) Mario.speedY *= gravity; else {
					Mario.y = Y-64;
					Mario.speedY = 0;
					allowed = true;
				}
			}
		}
		
		if (input.isKeyDown(Input.KEY_DOWN)){
			//crouch
		}
		
		//Borders and final position
		Mario.x += (int)Mario.speedX; 
		Mario.y += (int)Mario.speedY;
		
		if (Mario.x < 0) Mario.x = 0;
		if (Mario.x > X-32) Mario.x = X-32;
		if (Mario.y > Y-64) Mario.y = Y-64;	
		
	}

	public void render(GameContainer container, StateBasedGame sbg, Graphics g)
			throws SlickException {
		g.drawString("Stage 1", 50, 30);
		background.draw(0, 0);
		for (int i=0; i<X; i+=32){
			platform_basic.draw(i, Y-32);
		}
		Mario.draw(mario);
		
	}
	
	public int getID() {
		
		return 1;
	}
	
}
