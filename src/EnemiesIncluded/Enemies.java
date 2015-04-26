package EnemiesIncluded;


import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;


public class Enemies extends GameState {
	
	public Rectangle BoundingBoxNull;
	public int x;
	public int y;
	public int speedMax;
	public int health;
	public int overX;
	public int belowX;
	public float speedX;
	public float speedY;
	public boolean falling;


	
	public Enemies(int xpos, int ypos, float spX, float spY, int ovrX, int blwX, Rectangle bndbox, boolean falls) {
		
		x = xpos;
		y = ypos;
		speedX = spX;
		speedY = spY;
		overX = ovrX+xpos;
		belowX = xpos-blwX;
		BoundingBoxNull = bndbox; 
		falling = falls;
	}

	public void draw(Image image) {
		
		image.draw(x, y);
	}
	
	
	public void start() {
		
		for (int d=1; d<4; d++){
			enemyTexList.add(enemyDragonTex);
			enemyList.add(new Enemies(200+d*100, 340, 0.0f, 0.0f, 50, 50, BoundingBoxNull, false)); //I have to make the parameters linked to the X and Y coordinates??
			System.out.printf("Enemy %d loaded \n", d);
		}	
	}
	
	
	public static void intersection() {
		
			for(Enemies dragonas: enemyList ){
	
			dragonas.BoundingBoxNull = new Rectangle(dragonas.x, dragonas.y, enemyDragonTex.getWidth(), enemyDragonTex.getHeight());
			}			
	}	

}

	

	

