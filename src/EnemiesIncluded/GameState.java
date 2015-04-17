package EnemiesIncluded;

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

import CoinsIncluded.Coins;

public class GameState extends BasicGameState {
	
	//coins
	public static ArrayList<Image> coin = new ArrayList<Image>();
	public static ArrayList<Rectangle> coinsShapes = new ArrayList<Rectangle>(), Cpolices = new ArrayList<Rectangle>();
	public static Point[] arr3 = new Point[4];
	
	//Enmemies 
	public static ArrayList<Enemies> enemyList = new ArrayList<Enemies>();
	public static ArrayList<Image> enemyTexList = new ArrayList<Image>();
	//public static Enemies enemyDragon = new Enemies(X, X);
	public static Image enemyDragonTex;

	public static Point[] arr2 = new Point[4];
	public static ArrayList<Image> platforms = new ArrayList<Image>();
	public static ArrayList<Rectangle> platformsShapes = new ArrayList<Rectangle>(), polices = new ArrayList<Rectangle>();
	public static int X = 800, Y = 600, jumpSpeed = 20, fallSpeed = 10 , texSize = 32, bottom = Y-texSize; 
	public static float x = 0, y = 0;
	public static float gravity = 1.3f, acc = 1.4f;
	public static Rectangle marioShape;
	public static Image mario;
	public static Image background;
	public static Image platform_basic;
	//COINS
	public static Image money;
	public static boolean collision = false, fall = false, start = true, jump = false, allowed = true, left = false, right = false, top = false, bot = false;
	public static Character Mario = new Character();
	//COINS
	public static Coins Money = new Coins();
	public static Image Dragon;
	
		
	public void init(GameContainer container, StateBasedGame sbg)
			throws SlickException {
		//Loading Textures
		mario = new Image ("data/Mario_Basic.png");
		background = new Image ("data/Background_Basic.bmp");
		platform_basic = new Image ("data/Platform_Basic.bmp");
		//COINS
		money = new Image("data/mariobroscoin.png");
		System.out.println("Textures loaded!");
		
		//COINS
		LoadingCoins.start();
		System.out.println("coins lodaded!");
		
		//Loading platforms into scene
		LoadingPlatforms.start();
		System.out.println("Platforms Loaded!");
		//System.out.println("Enemy loaded");

		//Enemies
		enemyDragonTex = new Image ("data/drage.png");
		Enemies.start();
		//for (int d=1; d<4; d++){
			//enemyTexList.add(enemyDragonTex);
		//	enemyList.add(new Enemies(300-(d*20), 9)); //I have to make the parameters linked to the X and Y coordinates??
		//	System.out.printf("Enemy %d loaded \n", d);
//			

		//}
	
		
		
		//Assigning arrays
		for(int i = 0; i < arr2.length; i++) {
		    arr2[i] = new Point(0, 0);
		}
		
		//coins
		for(int i = 0; i < arr2.length; i++) {
		    arr3[i] = new Point(0, 0);
		}
		
			
	}
	
	public void update(GameContainer container, StateBasedGame sbg, int delta)
			throws SlickException {
		
		Input input = container.getInput();
		
		//Loading Mario class (once per game)
		if (start){
			Mario.load();
			start = false;
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
		
        //COINS
		IntersectionCoin.start();
	}

	public void render(GameContainer container, StateBasedGame sbg, Graphics g)
			throws SlickException {
		
		//Draw stage notifier
		g.drawString("Stage 1", 50, 30);
		
		//Draw background image
		background.draw(0, 0);

		//Draw coins
		for (Rectangle rec : coinsShapes) {
			coin.get(coinsShapes.indexOf(rec)).draw(rec.getX(),rec.getY());
		}
		
		//Draw platforms
		for (Rectangle rec : platformsShapes){
			platforms.get(platformsShapes.indexOf(rec)).draw(rec.getX(), rec.getY());
		}
		
		//Draw Enemies 
		for(Enemies dragon: enemyList )
		{
			enemyTexList.get(enemyList.indexOf(dragon)).draw(dragon.x, dragon.y); //Doesn't get the modified x and y's only the first set
		}		
		//for (int i = 1; i < enemyList.size(); i++)
		//{
	//		enemyList.get(i).draw(enemyTexList.get(i));	
		//}
		//enemyList.get(0).draw(enemyTexList.get(0));
		
		//enemyList.get(1).draw(enemyTexList.get(1));
		
		//enemyList.get(2).draw(enemyTexList.get(2));



		//Interaction notifiers
		g.setColor(Color.red);
		for (Rectangle r : polices){
			g.draw(r);
		}
		
		for (Rectangle r : Cpolices){
			g.draw(r);
		}
		
		//Draw Mario
		Mario.draw(mario);
		//coins
		//Money.draw(money);
	}

	@Override
	public int getID() {
		// TODO Auto-generated method stub
		return 1;
	}
	

	
}
