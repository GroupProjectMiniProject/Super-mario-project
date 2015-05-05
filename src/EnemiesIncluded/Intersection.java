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
				
				//System.out.println("=>Outter Collision: " + platformsShapes.indexOf(rec));
				//System.out.println("Speed: " + Mario.speedX + "/" + Mario.speedY);
				
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
				
				//if (top || left || right || bot) System.out.println("=>Inner Collision:");
				//else System.out.println("=>Inner Collision: No Collision");
				//System.out.println("TBLR: " + top + bot + left + right);
				
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
				if (!collision){
					//System.out.println("Outter: No Collisions");
					
					fall = true;
				}	
			}
		}
		
	
		for (Rectangle rec : platformsShapes){

			for (Enemies dragons: enemyList)
			{
				Rectangle c = dragons.BoundingBoxNull;
				Enemies e = dragons;
				
			if (c.intersects(rec)){
				
						
				eCollision = true;
				//ePolices.add(new Rectangle(rec.getMinX(), rec.getMinY(), texSize, texSize));
				
				enemyArray[0].setX(c.getMinX()+1);
				enemyArray[0].setY(c.getMinY()+1);
				enemyArray[1].setX(c.getMaxX()-1);
				enemyArray[1].setY(c.getMinY()+1);
				enemyArray[2].setX(c.getMinX()+1);
				enemyArray[2].setY(c.getMaxY()-1);
				enemyArray[3].setX(c.getMaxX()-1);
				enemyArray[3].setY(c.getMaxY()-1);
				
				botE = topE = leftE = rightE = false;  //think i need parameters for top left right and bot
				
			//bot right corner 
				if (rec.contains(enemyArray[3].getX()+1, enemyArray[3].getY())){
					if (rec.contains(enemyArray[1].getX(), enemyArray[1].getY())) 
						rightE = true;
					else if (rec.contains(enemyArray[2].getX(), enemyArray[2].getY())){
						botE = true;
						//System.out.println(Mario.speedY);
						//System.out.println("bot right");
					}
						
					else {
						x = Math.abs(enemyArray[3].getX()-rec.getMinX());
						y = Math.abs(enemyArray[3].getY()-rec.getMinY());
						if (x>y) botE = true; 
						else if (x<y) rightE = true;
						else {
							botE = true;
							rightE = true;
						}
					}
				//bot left corner	
				} else if (rec.contains(enemyArray[2].getX(), enemyArray[2].getY())){
					if (rec.contains(enemyArray[0].getX(), enemyArray[0].getY()))
						leftE = true;
					else {
						x = Math.abs(enemyArray[2].getX()-rec.getMaxX());
						y = Math.abs(enemyArray[2].getY()-rec.getMinY());
						if (x>y) {
							botE = true; 
							//System.out.println("bot right");
						}
						else if (x<y) leftE = true;
						else {
							botE = true;
							leftE = true;
						}
					}	
						//top right corner
				} else if (rec.contains(enemyArray[1].getX(), enemyArray[1].getY())){
					if (rec.contains(enemyArray[0].getX(), enemyArray[0].getY())) 
						topE = true;
					else {
						x = Math.abs(enemyArray[1].getX()-rec.getMinX());
						y = Math.abs(enemyArray[1].getY()-rec.getMaxY());
						if (x>y || y==19) topE = true; 
						else if (x<y) rightE = true;
						else {
							topE = true;
							rightE = true;
						}
					}
				//top left corner
					
					} else if (rec.contains(enemyArray[0].getX(), enemyArray[0].getY())){
					x = Math.abs(enemyArray[0].getX()-rec.getMinX());
					y = Math.abs(enemyArray[0].getY()-rec.getMaxY());
					if (x>y || y==19) topE = true; 
					else if (x<y) leftE = true;
					else {
						topE = true;
						leftE = true;
					}				

				}			

				
				
				
				if (topE){
					
					//System.out.println("top");
				}
				if (botE){
					e.y = (int)(rec.getMinY()-c.getHeight());
					//c.setY(e.y);
					e.falling = false;

					e.speedY = 0;
					
					//e.speedX = -1.0f;
					//allowed = true;				
						/*e.speedX = -1.0f;
						if (e.x == e.overX) // idea: add parameters enemies so they have a fixed max and min movement
							e.speedX = -1.0f;
						if (e.x == e.belowX)
							e.speedX = 1.0f; 
					
				
					System.out.println("bot");
				}
				/* 
				if (rightE){
					e.x = (int)(rec.getMinX()-c.getWidth());
					c.setX(e.x);
					e.speedX = 0;
					System.out.println(" right");
					
				}
				
				if (leftE){
					e.x = (int)c.getMaxX();
					c.setX(e.x);	
					e.speedX = 0;
					System.out.println("left");
				}
			
						*/

				//System.out.println("----------------");
			}
	
			}
		}
		
		
		for (Enemies dragons: enemyList) {
		
			
		if (!eCollision){
			dragons.falling = true;
			System.out.println("loooooooooooooool");

		}
		}
		
		
		for (Enemies dragons: enemyList){
		
		if (dragons.falling) {
		if (dragons.speedY == 0) 
			dragons.speedY = 1.0f;
		else if (dragons.speedY < fallSpeed)
			dragons.speedY *= gravity; 
		//eFall = false;
		}
		}
		
			
	}
	
	}
}
