package TestOndrej;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class SetupClass extends BasicGame {
	
	static int X = 800, Y = 600, jumpSpeed = 12; 
	
	static float gravity = 2.0f, acc = 1.2f;
	
	private Image mario = null;
	private Image background = null;
	private Image platform_basic = null;
	
	private boolean start = true, jump = false, allowed = true;
	
	private Character Mario = new Character();
	
	
	public SetupClass(String title) {
		super(title);	
	}

	public void init(GameContainer container) throws SlickException {
		mario = new Image ("data/Mario_Basic.png");
		background = new Image ("data/Background_Basic.bmp");
		platform_basic = new Image ("data/Platform_Basic.bmp");
		
	}

	public void update(GameContainer container, int delta) throws SlickException {
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

	public void render(GameContainer container, Graphics g) throws SlickException {
		//g.drawString("Hello World!", X/2, Y/2);
		background.draw(0, 0);
		for (int i=0; i<X; i+=32){
			platform_basic.draw(i, Y-32);
		}
		Mario.draw(mario);
	}
	
	public static void main(String[] args) throws SlickException {
		AppGameContainer app = new AppGameContainer(new SetupClass("Setup Test"));
		
		app.setDisplayMode(X, Y, false);
		app.setAlwaysRender(true);
		app.setVSync(true);
		
		app.start();
	}
	
}

