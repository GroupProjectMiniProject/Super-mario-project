package TestJonas;


import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class SetupClass extends BasicGame {

	private Image mario = null; 
	private Image tileset = null; 
	private SpriteSheet tiles = null;
	
	public SetupClass(String title) {
		super(title);
	}
	
	
	@Override
	public void init(GameContainer container) throws SlickException {
		mario = new Image("data/Mario_Basic.png");
		tileset = new Image ("data/tileset.png");
		tiles = new SpriteSheet(tileset, 32,32); 
	}
	
	@Override
	public void update(GameContainer container, int delta) throws SlickException {
		
	}
	
	@Override
	public void render(GameContainer container, Graphics g) throws SlickException {
		g.drawString("hello buddy", 400, 300);
		
		tiles.startUse();
		for(int i = 200; i < 400; i += 32)
		tiles.getSubImage(1, 0).drawEmbedded(i ,200, 64, 32);
		
		tiles.endUse();
		mario.drawFlash(500, 400);


	}

	public static void main(String[] args) throws SlickException {
		AppGameContainer app = new AppGameContainer(new SetupClass("Setup Test")); 
	app.setDisplayMode(800, 600, false);
	app.setAlwaysRender(true);
	
	app.start(); 
	
	}

}
