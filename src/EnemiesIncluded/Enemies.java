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



	
	public Enemies(int xpos, int ypos, float spX, int ovrX, int blwX, Rectangle bndbox) {
		
		x = xpos;
		y = ypos;
		speedX = spX;
		overX = ovrX+xpos;
		belowX = xpos-blwX;
		BoundingBoxNull = bndbox; 

		
	}

	public void draw(Image image) {
		
		image.draw(x, y);
	}
	
	public void start() {
		
		for (int d=1; d<4; d++){
			enemyTexList.add(enemyDragonTex);
			enemyList.add(new Enemies(250*d, 540-(d*10), 0.0f, 50, 50, BoundingBoxNull)); //I have to make the parameters linked to the X and Y coordinates??
			System.out.printf("Enemy %d loaded \n", d);

			//enemyRecList.add(new Rectangle(100*d, 530, texSize, texSize)); 
			
			//enemyRecList.add(new Rectangle(enemyList.get(d).x, enemyList.get(d).y, texSize, texSize));
		
			//Enemies enemy = enemyList.get(d);
			//enemyRecList.add(new Rectangle (enemyList.indexOf(enemy.x), 300, texSize, texSize)); //http://stackoverflow.com/questions/16020578/slick2d-entity-collision-detection
			//System.out.printf("No %d", enemyList.indexOf(enemyList.get(d).y));
		}
		
	
	}
	
	public static void intersection() {
		 
//				
		
		
				for(Enemies dragonas: enemyList ){
	
			dragonas.BoundingBoxNull = new Rectangle(dragonas.x, dragonas.y, enemyDragonTex.getWidth(), enemyDragonTex.getHeight());
				}				
			/*for (Enemies dragonas: enemyList ) {
			if (marioShape.intersects(dragonas.BoundingBoxNull)){
								
				arr2[0].setX(marioShape.getMinX());
				arr2[0].setY(marioShape.getMinY());
				arr2[1].setX(marioShape.getMaxX());
				arr2[1].setY(marioShape.getMinY());
				arr2[2].setX(marioShape.getMinX());
				arr2[2].setY(marioShape.getMaxY());
				arr2[3].setX(marioShape.getMaxX());
				arr2[3].setY(marioShape.getMaxY());
				
				enemyheadQ = false;
				killMario = false;
				
				if (dragonas.BoundingBoxNull.contains(arr2[3].getX()+1, arr2[1].getY()+1)){
					enemyheadQ = true;
				} else {
					killMario = true;
					
				}*/
				
			
				
				
			
				
	
			//ePolices.add(new Rectangle(dragonas.BoundingBoxNull.getMinX(), dragonas.BoundingBoxNull.getMinY(), enemyDragonTex.getWidth(), enemyDragonTex.getHeight()));

			//enemyRecList.add(new Rectangle (dragonas.x, dragonas.y, texSize, texSize)); //http://stackoverflow.com/questions/16020578/slick2d-entity-collision-detection
			//System.out.printf("%d\n", dragonas.x);
			/* if (marioShape.intersects(dragonas.BoundingBoxNull))
			{
				collider = true;
				dragonas.speedX = 1.0f;
			} else {
				collider = false;
			}
		}
		
		if (marioShape.intersects(enemyList.get(0).BoundingBoxNull))
		{
			collider = true;
		} 
		
		if (marioShape.intersects(enemyList.get(1).BoundingBoxNull))
		{
			collider = true;
		} */
		
		
	
		
			
		}	
			
	
	
		
	public static void load() {
		
	
			
	
	}
		
		
}

	

	

