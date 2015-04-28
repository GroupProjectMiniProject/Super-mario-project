package EnemiesIncluded;


import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;


public class Enemies extends GameState {
	
	public Rectangle BoundingBoxNull;
	public Rectangle BoundingBoxRed;
	public Rectangle BoundingBoxPurple;

	public int x;
	public int y;
	public int speedMax;
	public int health;
	public int overX;
	public int belowX;
	public float speedX;
	public float speedY;
	public boolean falling;


	
	public Enemies(int xpos, int ypos, float spX, float spY, int ovrX, int blwX, Rectangle bndbox, Rectangle bndboxR, Rectangle bndboxP, boolean falls) {
		
		x = xpos;
		y = ypos;
		speedX = spX;
		speedY = spY;
		overX = ovrX+xpos;
		belowX = xpos-blwX;
		BoundingBoxNull = bndbox;
		BoundingBoxRed = bndboxR; 
		BoundingBoxPurple = bndboxP; 

		falling = falls;
	}

	public void draw(Image image) {
		
		image.draw(x, y);
	}
	
	
	public void start() {
		
		for (int d=1; d<4; d++){
			enemyTexList.add(enemyDragonTex);
			enemyList.add(new Enemies(200+d*100, 500, 0.0f, 0.0f, 50, 50, BoundingBoxNull, BoundingBoxRed, BoundingBoxPurple, false)); //I have to make the parameters linked to the X and Y coordinates??
			System.out.printf("Enemy %d loaded \n", d);
		}	
	}
	
	
	public static void intersection() {
		
			for(Enemies dragonas: enemyList ){
	
			dragonas.BoundingBoxNull = new Rectangle(dragonas.x, dragonas.y, enemyDragonTex.getWidth(), enemyDragonTex.getHeight());
			//dragonas.BoundingBoxPurple = new Rectangle(dragonas.x+3, dragonas.y+2, enemyDragonTex.getWidth()-4, enemyDragonTex.getHeight()-10);
			//dragonas.BoundingBoxRed = new Rectangle(dragonas.x+3, dragonas.y, enemyDragonTex.getWidth()-7, enemyDragonTex.getHeight()/3);
			//ePolices.add(new Rectangle(dragonas.BoundingBoxNull.getX()+3, dragonas.BoundingBoxNull.getY()+12, enemyDragonTex.getWidth()-4, enemyDragonTex.getHeight()/2));
			//RedPolices.add(new Rectangle(dragonas.BoundingBoxNull.getX()+3, dragonas.BoundingBoxNull.getY(), enemyDragonTex.getWidth()-7, enemyDragonTex.getHeight()/3));

			}	
			
			//Killing that shit Mario. (Purple)
			/*
			for(Enemies dragonas: enemyList ){				
				//Enemy points which are slight smaller than bounding box
				if (marioShape.intersects(dragonas.BoundingBoxRed))
					killMario = true;
			}
				for (int i = enemyList.size()-1; i>= 0; i--){
					Rectangle e = enemyList.get(i).BoundingBoxPurple;
					if (marioShape.intersects(e))
						enemyList.remove(i); }*/

			
				
				/*arrPur[0].setX(marioShape.getMinX()+1);
				arrPur[0].setY(marioShape.getMinY()+1);
				arrPur[1].setX(marioShape.getMaxX()-1);
				arrPur[1].setY(marioShape.getMinY()+1);
				arrPur[2].setX(marioShape.getMinX()+1);
				arrPur[2].setY(marioShape.getMaxY()-1);
				arrPur[3].setX(marioShape.getMaxX()-1);
				arrPur[3].setY(marioShape.getMaxY()-1);
				*/
				/*/Top 
				if (rec.contains(arrPur[0].getMinX(), arrPur[0].getMinY())){
					if (rec.contains(arrPur[1].getMinX(), arrPur[1].getMinY())){
						killMario = true; 
					}
					
				}*/
					
				
				
			
	}	

}

	

	

