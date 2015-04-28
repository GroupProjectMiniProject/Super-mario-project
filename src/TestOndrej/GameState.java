package TestOndrej;

import java.util.ArrayList;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Point;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class GameState extends BasicGameState {
	
	public static Point[] arr2 = new Point[4];
	public static ArrayList<Image> platforms = new ArrayList<Image>();
	public static ArrayList<Rectangle> platformsShapes = new ArrayList<Rectangle>(), polices = new ArrayList<Rectangle>();
	public static Rectangle flagShape;
	public static int X = 800, Y = 600, jumpSpeed = 20, fallSpeed = 10 , texSize = 32, bottom = Y-texSize; 
	public static float x = 0, y = 0;
	public static float gravity = 1.3f, acc = 1.4f;
	public static Rectangle marioShape;
	public static Image mario, background, flag;
	public static Image platform_basic;
	public static boolean finish = false, collision = false, fall = false, start = true, jump = false, allowed = true, left = false, right = false, top = false, bot = false;
	public static Character Mario = new Character();
		
	public void init(GameContainer container, StateBasedGame sbg)
			throws SlickException {
		
		//Loading Textures
		mario = new Image ("data/Mario_Basic.png");
		background = new Image ("data/Background_Basic.bmp");
		platform_basic = new Image ("data/Platform_Basic.bmp");
		flag = new Image ("data/flag.png");
		System.out.println("Textures loaded!");
		
		//Loading platforms into scene
		LoadingPlatforms.start();
		System.out.println("Platforms Loaded!");
		
		//Assigning arrays of points
		for(int i = 0; i < arr2.length; i++) {
		    arr2[i] = new Point(0, 0);
		}
			
	}
	
	public void update(GameContainer container, StateBasedGame sbg, int delta)
			throws SlickException {
		
		Input input = container.getInput();
		
		//Loading Mario class (once per game)
		if (start){
			Mario.load();
			start = false;
			finish = false;
			marioShape = new Rectangle (Mario.x, Mario.y, mario.getWidth(), mario.getHeight());
		}
		
		//KeyPressed
		KeyPressed.start(input, sbg);
		
		//Borders and final position
		Mario.x += (int)Mario.speedX; 
		Mario.y += (int)Mario.speedY;
		marioShape.setBounds(Mario.x, Mario.y, mario.getWidth(), mario.getHeight());
		
		//Borders (X edges of screen)
		if (Mario.x < 0) {
			Mario.x = 0;
			Mario.speedX = 0;
		}
		if (Mario.x > X-texSize) {
			Mario.x = X-texSize;
			Mario.speedX = 0;
		}
		
		//Collisions with platforms
		Intersection.start();
		
		if (finish) {
			finish = false;
			start = true;
			sbg.enterState(2, new FadeOutTransition(), new FadeInTransition());
		}
		
		System.out.println(marioShape.getCenterX() + ":" + marioShape.getCenterY() + "/" + flagShape.getMinX() + ":" + flagShape.getMinY());

	}

	public void render(GameContainer container, StateBasedGame sbg, Graphics g)
			throws SlickException {
		
		//Draw stage notifier
		g.drawString("Stage 1", 50, 30);
		
		//Draw background image
		background.draw(0, 0);

		//Draw platforms & flag
		for (Rectangle rec : platformsShapes){
			platforms.get(platformsShapes.indexOf(rec)).draw(rec.getX(), rec.getY());
		}
		
		flag.draw(flagShape.getMinX(), flagShape.getMinY(), flagShape.getWidth(), flagShape.getHeight());

		
		//Interaction notifiers
		g.setColor(Color.red);
		for (Rectangle r : polices){
			g.draw(r);
		}
		g.setColor(Color.white);
		
		//Draw Mario
		Mario.draw(mario);
		
		
	}
	
	public int getID() {
		
		return 1;
	}
	
}
