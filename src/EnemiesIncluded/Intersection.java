package EnemiesIncluded;

import org.newdawn.slick.geom.Rectangle;

public class Intersection extends GameState {
	
	public Intersection (){
		
	}
	
	public static void start (){
		
		polices.clear();
		System.out.println("------------Frame-------------");
		System.out.println("");
		System.out.println("------------Outter------------");
		collision = false;
		
		for (Rectangle rec : platformsShapes){
			if (marioShape.intersects(rec)){
				
				System.out.println("=>Outter Collision: " + platformsShapes.indexOf(rec));
				System.out.println("Speed: " + Mario.speedX + "/" + Mario.speedY);
				
				collision = true;
				polices.add(new Rectangle(rec.getMinX(), rec.getMinY(), texSize, texSize));
				
				arr2[0].setX(marioShape.getMinX()+1);
				arr2[0].setY(marioShape.getMinY()+1);
				arr2[1].setX(marioShape.getMaxX()-1);
				arr2[1].setY(marioShape.getMinY()+1);
				arr2[2].setX(marioShape.getMinX()+1);
				arr2[2].setY(marioShape.getMaxY()-1);
				arr2[3].setX(marioShape.getMaxX()-1);
				arr2[3].setY(marioShape.getMaxY()-1);
				
				bot = top = left = right = false;
				
				//bot right corner 
				if (rec.contains(arr2[3].getX()+1, arr2[3].getY())){
					if (rec.contains(arr2[1].getX(), arr2[1].getY())) 
						right = true;
					else if (rec.contains(arr2[2].getX(), arr2[2].getY())){
						bot = true;
						//System.out.println(Mario.speedY);
						//System.out.println("bot right");
					}
						
					else {
						x = Math.abs(arr2[3].getX()-rec.getMinX());
						y = Math.abs(arr2[3].getY()-rec.getMinY());
						if (x>y) bot = true; 
						else if (x<y) right = true;
						else {
							bot = true;
							right = true;
						}
					}
				//bot left corner	
				} else if (rec.contains(arr2[2].getX(), arr2[2].getY())){
					if (rec.contains(arr2[0].getX(), arr2[0].getY()))
						left = true;
					else {
						x = Math.abs(arr2[2].getX()-rec.getMaxX());
						y = Math.abs(arr2[2].getY()-rec.getMinY());
						if (x>y) {
							bot = true; 
							//System.out.println("bot right");
						}
						else if (x<y) left = true;
						else {
							bot = true;
							left = true;
						}
					}	
				//top right corner
				} else if (rec.contains(arr2[1].getX(), arr2[1].getY())){
					if (rec.contains(arr2[0].getX(), arr2[0].getY())) 
						top = true;
					else {
						x = Math.abs(arr2[1].getX()-rec.getMinX());
						y = Math.abs(arr2[1].getY()-rec.getMaxY());
						if (x>y || y==19) top = true; 
						else if (x<y) right = true;
						else {
							top = true;
							right = true;
						}
					}
				//top left corner
				} else if (rec.contains(arr2[0].getX(), arr2[0].getY())){
					x = Math.abs(arr2[0].getX()-rec.getMinX());
					y = Math.abs(arr2[0].getY()-rec.getMaxY());
					if (x>y || y==19) top = true; 
					else if (x<y) left = true;
					else {
						top = true;
						left = true;
					}
				}
				
				if (top || left || right || bot) System.out.println("=>Inner Collision:");
				else System.out.println("=>Inner Collision: No Collision");
				System.out.println("TBLR: " + top + bot + left + right);
				
				if (top){
					Mario.y = (int)(rec.getMaxY());
					marioShape.setY(Mario.y);
					jump = false;
					fall = true;
					Mario.speedY = 0;
					//System.out.println("top");
				}
				if (bot){
					Mario.y = (int)(rec.getMinY()-marioShape.getHeight());
					marioShape.setY(Mario.y);
					Mario.speedY = 0;
					allowed = true;
					fall = false;
					
					//System.out.println("bot");
				}
				
				if (right){
					Mario.x = (int)(rec.getMinX()-marioShape.getWidth());
					marioShape.setX(Mario.x);
					Mario.speedX = 0;
					//System.out.println("right");
				}
				if (left){
					Mario.x = (int)rec.getMaxX();
					marioShape.setX(Mario.x);	
					Mario.speedX = 0;
					//System.out.println("left");
				}
				//System.out.println("----------------");
				
			}
		}
		if (!collision){
			//System.out.println("Outter: No Collisions");
			
			fall = true;
		}
		for (Rectangle rec : platformsShapes){

			for (int i = enemyList.size()-1; i >= 0; i--)
			{
				Rectangle c = enemyList.get(i).BoundingBoxNull;
				Enemies e = enemyList.get(i);
				
			if (c.intersects(rec)){
				
						
				eCollision = true;
				ePolices.add(new Rectangle(rec.getMinX(), rec.getMinY(), texSize, texSize));
				
				arr2[0].setX(c.getMinX()+1);
				arr2[0].setY(c.getMinY()+1);
				arr2[1].setX(c.getMaxX()-1);
				arr2[1].setY(c.getMinY()+1);
				arr2[2].setX(c.getMinX()+1);
				arr2[2].setY(c.getMaxY()-1);
				arr2[3].setX(c.getMaxX()-1);
				arr2[3].setY(c.getMaxY()-1);
				
				bot = top = left = right = false;
				
				//bot right corner 
				if (rec.contains(arr2[3].getX()+1, arr2[3].getY())){
					if (rec.contains(arr2[1].getX(), arr2[1].getY())) 
						right = true;
					else if (rec.contains(arr2[2].getX(), arr2[2].getY())){
						bot = true;
						//System.out.println(Mario.speedY);
						//System.out.println("bot right");
					}
						
					else {
						x = Math.abs(arr2[3].getX()-rec.getMinX());
						y = Math.abs(arr2[3].getY()-rec.getMinY());
						if (x>y) bot = true; 
						else if (x<y) right = true;
						else {
							bot = true;
							right = true;
						}
					}
				//bot left corner	
				} else if (rec.contains(arr2[2].getX(), arr2[2].getY())){
					if (rec.contains(arr2[0].getX(), arr2[0].getY()))
						left = true;
					else {
						x = Math.abs(arr2[2].getX()-rec.getMaxX());
						y = Math.abs(arr2[2].getY()-rec.getMinY());
						if (x>y) {
							bot = true; 
							//System.out.println("bot right");
						}
						else if (x<y) left = true;
						else {
							bot = true;
							left = true;
						}
					}	
				//top right corner
				} else if (rec.contains(arr2[1].getX(), arr2[1].getY())){
					if (rec.contains(arr2[0].getX(), arr2[0].getY())) 
						top = true;
					else {
						x = Math.abs(arr2[1].getX()-rec.getMinX());
						y = Math.abs(arr2[1].getY()-rec.getMaxY());
						if (x>y || y==19) top = true; 
						else if (x<y) right = true;
						else {
							top = true;
							right = true;
						}
					}
				//top left corner
				} else if (rec.contains(arr2[0].getX(), arr2[0].getY())){
					x = Math.abs(arr2[0].getX()-rec.getMinX());
					y = Math.abs(arr2[0].getY()-rec.getMaxY());
					if (x>y || y==19) top = true; 
					else if (x<y) left = true;
					else {
						top = true;
						left = true;
					}
				}
				
				if (top || left || right || bot) System.out.println("=>Inner Collision:");
				else System.out.println("=>Inner Collision: No Collision");
				System.out.println("TBLR: " + top + bot + left + right);
				
				if (top){
					e.y = (int)(rec.getMaxY());
					c.setY(Mario.y);
					//jump = false;
					eFall = true;
					//Mario.speedY = 0;
					//System.out.println("top");
				}
				if (bot){
					e.y = (int)(rec.getMinY()-c.getHeight());
					c.setY(e.y);
					e.speedY = 0;
					//allowed = true;
					eFall = false;
					
					//System.out.println("bot");
				}
				
				if (right){
					e.x = (int)(rec.getMinX()-c.getWidth());
					c.setX(e.x);
					//Mario.speedX = 0;
					//System.out.println("right");
				}
				if (left){
					e.x = (int)rec.getMaxX();
					c.setX(e.x);	
					//Mario.speedX = 0;
					//System.out.println("left");
				}

				if (eFall && !bot){
					System.out.println("ENEMY Falling");
					if (e.speedY == 0) e.speedY = 1.0f; 
					else {
					}
				}
				//System.out.println("----------------");
			}
			}
		}
	}
	

}
