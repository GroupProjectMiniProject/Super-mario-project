package EnemiesIncluded;

import javafx.scene.shape.Circle;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;


public class Enemies extends GameState {
	public int x;
	public int y;
	public static int speedMax;
	public static int health;
	public float speedX, speedY;
	


	public Enemies(int xpos, int ypos) {
		x = xpos;
		y = ypos;
	}



	public void draw(Image image) {
		image.draw(x, y);
		
	}



	public static void start() {
		
	
		for (int d=1; d<4; d++){
			enemyTexList.add(enemyDragonTex);
			enemyList.add(new Enemies(50*d, 530)); //I have to make the parameters linked to the X and Y coordinates??
			System.out.printf("Enemy %d loaded \n", d);
			
			//enemyRecList.add(new Rectangle(enemyList.get(d).x, enemyList.get(d).y, texSize, texSize));
		
			//Enemies enemy = enemyList.get(d);
			//enemyRecList.add(new Rectangle (enemyList.indexOf(enemy.x), 300, texSize, texSize)); //http://stackoverflow.com/questions/16020578/slick2d-entity-collision-detection
			//System.out.printf("No %d", enemyList.indexOf(enemyList.get(d).y));
		}
		for(Enemies dragonas: enemyList ) // selecting list items with for loop method 1
		{
			enemyRecList.add(new Rectangle (dragonas.x, dragonas.y, texSize, texSize)); //http://stackoverflow.com/questions/16020578/slick2d-entity-collision-detection
			System.out.printf("%d\n", dragonas.x);


		}

		}
	public static void intersection() {
		for (Rectangle dragonBoundingBox: enemyRecList)
		{
			if (marioShape.intersects(dragonBoundingBox))
			{
				Cpolices.add(new Rectangle(dragonBoundingBox.getMinX(), dragonBoundingBox.getMinY(), texSize, texSize));
				collider = true;
			}
			
		}
		
	}
		

	}

	

	

