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
			enemyList.add(new Enemies(200+d*200, 500+(d*10), 0.0f, 0.0f, 50, 50, BoundingBoxNull, BoundingBoxRed, BoundingBoxPurple, false)); //I have to make the parameters linked to the X and Y coordinates??
			System.out.printf("Enemy %d loaded \n", d);
		}	
	}
	
	
	public static void intersection() {
		
			for(Enemies dragonas: enemyList ){
	
			dragonas.BoundingBoxNull = new Rectangle(dragonas.x, dragonas.y, enemyDragonTex.getWidth(), enemyDragonTex.getHeight());
			
			//Lower body enemy boundingbox
			dragonas.BoundingBoxPurple = new Rectangle(dragonas.x+3, dragonas.y+12, enemyDragonTex.getWidth()-4, enemyDragonTex.getHeight()/2);
			//Upper body enemy boundingbox
			dragonas.BoundingBoxRed = new Rectangle(dragonas.x+3, dragonas.y, enemyDragonTex.getWidth()-7, enemyDragonTex.getHeight()/3);
			ePolices.add(new Rectangle(dragonas.BoundingBoxNull.getX()+3, dragonas.BoundingBoxNull.getY()+18, enemyDragonTex.getWidth()-4, enemyDragonTex.getHeight()/2));
			RedPolices.add(new Rectangle(dragonas.BoundingBoxNull.getX()+3, dragonas.BoundingBoxNull.getY(), enemyDragonTex.getWidth()-7, enemyDragonTex.getHeight()/3));

			}	
			
			//Enemy-mario interaction.
			
				for (int i = enemyList.size()-1; i>= 0; i--){
				Rectangle e = enemyList.get(i).BoundingBoxPurple;
				Rectangle d = enemyList.get(i).BoundingBoxRed;

				//if (marioShape.intersects(d))
						//enemyList.remove(i); 
			
				
				arr2[0].setX(marioShape.getMinX()+1);
				arr2[0].setY(marioShape.getMinY()+1);
				arr2[1].setX(marioShape.getMaxX()-1);
				arr2[1].setY(marioShape.getMinY()+1);
				arr2[2].setX(marioShape.getMinX()+1);
				arr2[2].setY(marioShape.getMaxY()-1);
				arr2[3].setX(marioShape.getMaxX()-1);
				arr2[3].setY(marioShape.getMaxY()-1);
				
				
				//killing enemy, boundingbox red
				if (d.contains(arr2[2].getMinX(), arr2[2].getMinY())||d.contains(arr2[3].getMinX(), arr2[3].getMinY())){
					enemyList.remove(i); 	
				} 
			
				//killing mario, boundingbox purple
				if (marioShape.intersects(e)){
					if (!poweredUp) {
						HP--;
						killMario = true; 
					}
					poweredUp = false;
					
					enemyList.remove(i); 
				}


				
				
				
			
	}	

	}

}
	

	

