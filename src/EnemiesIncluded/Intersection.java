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
					x = Math.abs(arr2[0].getX()-rec.getMaxX());
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
				
			}
		}
		if (!collision){
			//System.out.println("Outter: No Collisions");
			
			fall = true;
		}	
	if (flagShape.contains(marioShape.getCenterX(), marioShape.getCenterY())) finish = true; 
		
	//****************************************************************************// Change
		//Enemy Intersections with platform
		
	outerCollision = false; 
	innerCollision = false;
	
		for (Rectangle rec : platformsShapes){
			

			for (Enemies dragons: enemyList)
			{
				Rectangle o = dragons.enemyOuterShape;
				Rectangle i = dragons.enemyInnerShape;
				Enemies e = dragons;
				
				if (o.intersects(rec))
					outerCollision = true;
				if (i.intersects(rec)){
					
					innerCollision = true;
					botE = topE = leftE = rightE = false; 
					x = y = 0; 
				
				//Bot Right Corner
				if (rec.contains(i.getMaxX(), i.getMaxY())){
					if (rec.contains(i.getMaxX(), i.getMinX()))
						rightE = true;
					else if (rec.contains(i.getMinX(), i.getMaxY()))
						botE = true; 
					
				} else {
					x = Math.abs(i.getMaxX()-rec.getMinX());
					y = Math.abs(i.getMaxY()-rec.getMinY());
					if (x>y) botE = true; 
					else if (x<y) rightE = true; 
					else {
						botE = true; 
						rightE = true; 
					}					
				}
				
				//Bot Left Corner
				} else if (rec.contains(i.getMinX(), i.getMaxY())){
					if (rec.contains(i.getMinX(), i.getMinY()))
						leftE = true;
					else {
						x = Math.abs(i.getMinX()-rec.getMaxX());
						y = Math.abs( i.getMaxY()-rec.getMinY());
						if (x>y) {
							botE = true;
						}
						else if (x<y) leftE = true;
						else {
							botE = true;
							leftE = true;
						}
					}
					//Top Right Corner
				} else if (rec.contains(i.getMaxX(), i.getMinY())){
					if (rec.contains(i.getMinX(), i.getMinY())) 
						topE = true;
					else {
						x = Math.abs(i.getMaxX()-rec.getMinX());
						y = Math.abs(i.getMinY()-rec.getMaxY());
						if (x>y || y==19) topE = true; 
						else if (x<y) rightE = true;
						else {
							topE = true;
							rightE = true;
						}
					}
					//Top Left Corner
				} else if (rec.contains(i.getMinX(), i.getMinY())){
					x = Math.abs(i.getMinX()-rec.getMaxX());
					y = Math.abs(i.getMinY()-rec.getMaxY());
					if (x>y || y==19) topE = true; 
					else if (x<y) leftE = true;
					else {
						topE = true;
						leftE = true;
					}
				}
				
				if (topE){
					e.y = (int)(rec.getMaxY());
					e.falling = true;
					e.speedY = 0;
				}
				if (botE){
					e.y = (int)(rec.getMinY()-o.getHeight());
					e.speedY = 0;
					e.falling = false;
				}
				
				if (rightE){
					e.x = (int)(rec.getMinX()-o.getWidth());
					e.speedX = -1.0f;
				}
				if (leftE){
					e.x = (int)rec.getMaxX();
					e.speedX = 1.0f;
				}
			}
			
		}
		for(Enemies e : enemyList){
		if (!outerCollision && !innerCollision){
			e.falling = true;
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
//Enemy Intersection END //CHANGE
		
		
//********************************************************************************************************// CHANGE
//COIN intersection START
		for (Rectangle coins : coinsShapes)
		{
			if (marioShape.intersects(coins))
			coinCollection++;

		}
		
		for (int i = coinsShapes.size()-1; i>= 0; i--){
			Rectangle rec =  coinsShapes.get(i);

			if (marioShape.intersects(rec)){
				coinsShapes.remove(i);
			}

		}//COIN intersection END 
		

	}
}
