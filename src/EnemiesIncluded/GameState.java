package EnemiesIncluded;

import java.util.ArrayList;












import org.newdawn.slick.Animation;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Point;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;











public class GameState extends BasicGameState {
	
	public static ArrayList<Rectangle> coinsShapes = new ArrayList<Rectangle>(), Cpolices = new ArrayList<Rectangle>();
	public static int coinCollection = 0; 
	public static Image money;
	public static boolean collision = false, fall = false, start = true, jump = false, allowed = true, left = false, right = false, top = false, bot = false, enemyheadQ = false;
	public static boolean leftE = false, rightE = false, botE = false, topE = false;
	public static Character Mario = new Character();
	
	
	//Enemies 
	public static ArrayList<Enemies> enemyList = new ArrayList<Enemies>();
	public static ArrayList<Rectangle> ePolices = new ArrayList<Rectangle>();
	public static ArrayList<Rectangle> RedPolices = new ArrayList<Rectangle>();
	public static ArrayList<Rectangle> enemyRecList = new ArrayList<Rectangle>();
	public static Image enemyDragonTex;
	public static boolean enemyStartos = false;
	public static boolean killMario = false;
	public static boolean eCollision = false;
	public static boolean keyLeft = false, keyRight = false, eFall = false;
	public static SpriteSheet enemySheetLeft, enemySheetRight;
	public static Animation enemyWalkLeft, enemyWalkRight;

	//Platforms
	public static ArrayList<Image> platforms = new ArrayList<Image>();
	public static ArrayList<Rectangle> platformsShapes = new ArrayList<Rectangle>(), polices = new ArrayList<Rectangle>();

	//PowerUps
	public static Image powerUpTex;
	public static ArrayList<Rectangle> powerUpList = new ArrayList<Rectangle>();
	public static boolean poweredUp = false; 

	//Mario
	public static int HP = 2; 
	public static Point[] arr2 = new Point[4];
	public static int timer1 = 0, X = 800, Y = 600, jumpSpeed = 20, fallSpeed = 10 , texSize = 32, bottom = Y-texSize; 
	public static float x = 0, y = 0;
	public static float gravity = 1.3f, acc = 1.4f;
	public static Rectangle marioShape;
	public static Image mario;
	public static Image flag;
	public static Rectangle flagShape;
	public static Boolean finish = false, timer = false, hitFlag = false;
	public static Image background;
	public static Image platform_basic;
	public static SpriteSheet MarioSheetLeft, MarioSheetRight;
	public static Animation MarioWalkLeft, MarioWalkRight;
	

		
	public void init(GameContainer container, StateBasedGame sbg)
			throws SlickException {
		//Loading Textures
		mario = new Image ("data/Mario_Basic.png");
		background = new Image ("data/Background_Basic.bmp");
		platform_basic = new Image ("data/Platform_Basic.bmp");
		money = new Image("data/mariobroscoin.png");
		enemyDragonTex = new Image ("data/drage4.png");
		powerUpTex = new Image("data/mush.png");
		MarioSheetRight = new SpriteSheet ("data/MarioSheet.png", 32, 32);
		MarioSheetLeft = new SpriteSheet (MarioSheetRight.getFlippedCopy(true, false), 32, 32);
		MarioWalkLeft = new Animation (MarioSheetLeft, 200);
		MarioWalkRight = new Animation (MarioSheetRight, 200);
		enemySheetLeft = new SpriteSheet ("data/enemySprites.png", texSize, texSize);
		enemySheetRight = new SpriteSheet (enemySheetLeft.getFlippedCopy(true, false), texSize, texSize);
		enemyWalkLeft = new Animation (enemySheetLeft, 200);
		enemyWalkRight = new Animation (enemySheetRight, 200);
		flag = new Image ("data/flag.png");
		
		System.out.println("Textures Loaded!");
		
		//Loading Coins
		LoadingCoins.start();
		System.out.println("Coins Loaded!");
		
		//Loading platforms into scene
		LoadingPlatforms.start();
		System.out.println("Platforms Loaded!");
		
		//Loading PowerUPs
		PowerUp.start();
		
		//Assigning arrays
			//Mario
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
			enemyStartos = true;
			poweredUp = false; 
			killMario = false;
			hitFlag = false;
			coinCollection = 0;
			HP = 2;
			marioShape = new Rectangle (Mario.x, Mario.y, mario.getWidth(), mario.getHeight());
			
			new Enemies(0, 0, 0, 0, 0, 0, null, null, null, null, false, false, false, false, false, false, false).start();

			
			LoadingCoins.start();
			PowerUp.start();
			start = false;		
			finish = false;
		}
	
		
		//KeyPressed
		KeyPressed.start(input, sbg);
		
		//Animation Update
		System.out.println("Keys: left/right = " + keyLeft + "/" + keyRight);
		if (keyLeft) {
			MarioWalkLeft.start();
			MarioWalkLeft.update(delta);
		}
		else if (keyRight) {
			MarioWalkRight.start();
			MarioWalkRight.update(delta);
		}
		else {
			MarioWalkLeft.restart();
			MarioWalkLeft.stop();
			MarioWalkRight.restart();
			MarioWalkRight.stop();
		}
		
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
		//PowerUp Collision
		PowerUp.interaction();
		
		//Enemies Collision 
		Enemies.intersection();

		//Enemies Starts Patrolling
		if (enemyStartos)
		{
			for (Enemies dra: enemyList)
			{
				dra.speedX = -1.0f;

				enemyStartos = false;

			}
		}
	
		//Enemy borders
		for (Enemies drago: enemyList)
		{			
			if (drago.x < 0) {
				drago.x = 4;
				drago.speedX = 1.0f;
			}
			if (drago.x > X-texSize) {
				drago.x = (X-texSize-4);
				drago.speedX = -1.0f;
			}
		}	
		
		//Movement
		for (Enemies drago: enemyList)
		{			
			drago.x += (int)drago.speedX;
			drago.y += (int)drago.speedY;
			
		}
				
		System.out.println(enemyList.size());

		//Mario and Enemy collisions with platforms
		Intersection.start();
		
		if (HP==0)
			finish = true;
		
		//Finish
		if (finish) {
			finish = false;
			start = true;
			timer = false;
			killMario = false;
			Mario.load();
			sbg.enterState(2, new FadeOutTransition(), new FadeInTransition());
		}
		
		if (timer){
			if (timer1 <= 60){
				timer1++;
				if (timer1 % 3 == 0) killMario = !killMario;
			}
			else {
				timer1 = 0;
				killMario = false;
				timer = false;
			}
		}
		
	}

	public void render(GameContainer container, StateBasedGame sbg, Graphics g)
			throws SlickException {
		
		//Draw background image
		background.draw(0, 0);

		//Draw coins
		for (Rectangle rec : coinsShapes) {
			money.draw(rec.getX(), rec.getY());
		}
		
		//Draw platforms
		for (Rectangle rec : platformsShapes){
			platforms.get(platformsShapes.indexOf(rec)).draw(rec.getX(), rec.getY());
		}
		
		//Draw flag
		flag.draw(flagShape.getMinX(), flagShape.getMinY(), flagShape.getWidth(), flagShape.getHeight());
		
		//Draw Enemies  
		for(Enemies dragon: enemyList ) // selecting list items with for loop method 1
		{
			if (dragon.speedX < 0) enemyWalkLeft.draw(dragon.x, dragon.y);
			else enemyWalkRight.draw(dragon.x, dragon.y);
		}
		
		//Draw PowerUps
		for (Rectangle rec : powerUpList) {
			powerUpTex.draw(rec.getX(), rec.getY());
		}
		
		//Mario visuals drawing
		if (poweredUp){
			killMario = false;
			if (!keyRight && !keyLeft) mario.draw(Mario.x, Mario.y, Color.green);
			else if (keyLeft) MarioWalkLeft.draw(Mario.x, Mario.y, Color.green);
			else if (keyRight) MarioWalkRight.draw(Mario.x, Mario.y, Color.green);
		}	
		else if (killMario){
			//System.out.println("Dead");
			mario.draw(Mario.x, Mario.y, 1.0f, Color.red);
			timer = true;
		}	
		else {
			if (!keyRight && !keyLeft) mario.draw(Mario.x, Mario.y);
			else if (keyLeft) MarioWalkLeft.draw(Mario.x, Mario.y);
			else if (keyRight) MarioWalkRight.draw(Mario.x, Mario.y);
		}
		
		//GUI
		g.setColor(Color.black);
		g.drawString("Coins: " + coinCollection, 15, 60);
		g.drawString("Enemy HP: " + HP, 15, 30);
		//g.drawString("Powered UP?: " + poweredUp, 15, 90);
		//g.drawString("killMario?: " + killMario, 15, 120);
	    
		//Color for game over stage
		//g.setColor(Color.red);
		
		/*
		Interaction notifiers for our own use.
		g.drawString("Stage 1", 50, 30);
		
		for (Rectangle r : polices){
			g.draw(r);
		}
		for (Rectangle r : Cpolices){
			g.draw(r);
		} */
		
	}
	
	//returns the ID of the state of gameplay
	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 1;
	}
	
}
