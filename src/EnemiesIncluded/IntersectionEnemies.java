package EnemiesIncluded;

import org.newdawn.slick.geom.Rectangle;

public class IntersectionEnemies extends GameState{
	
public static void start (){
		
		ePolices.clear();
		System.out.println("------------Frame-------------");
		System.out.println("");
		System.out.println("------------Outter------------");
		collision = false;
		
		for (Rectangle rec : enemyRecList){
			if (marioShape.intersects(rec)){
				
				System.out.println("=>Outter Collision: " + coinsShapes.indexOf(rec));
				System.out.println("Speed: " + Mario.speedX + "/" + Mario.speedY);
				
				collision = true;
				Cpolices.add(new Rectangle(rec.getMinX(), rec.getMinY(), texSize, texSize));
				
				arr3[0].setX(marioShape.getMinX()+1);
				arr3[0].setY(marioShape.getMinY()+1);
				arr3[1].setX(marioShape.getMaxX()-1);
				arr3[1].setY(marioShape.getMinY()+1);
				arr3[2].setX(marioShape.getMinX()+1);
				arr3[2].setY(marioShape.getMaxY()-1);
				arr3[3].setX(marioShape.getMaxX()-1);
				arr3[3].setY(marioShape.getMaxY()-1);
				
				bot = top = left = right = false;
				
				System.out.println("----------------");
				
			}
		}
		if (!collision){
			System.out.println("Outter: No Collisions");
			
			fall = true;
		}
	}
}
