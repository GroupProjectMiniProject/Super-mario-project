/*package EnemiesIncluded;

import org.newdawn.slick.geom.Rectangle;

public class IntersectionEnemies extends GameState {
	
	public IntersectionEnemies (){
		
	}
	
	public static void start (){
		
		polices.clear();
		System.out.println("------------Frame-------------");
		System.out.println("");
		System.out.println("------------Outter------------");
		collision = false;
		
		for (int i = enemyList.size()-1; i>= 0; i--){
			Rectangle c = enemyList.get(i).BoundingBoxNull;
			
			if (marioShape.intersects(c)){
				
				System.out.println("=>Outter Collision: " + platformsShapes.indexOf(c));
				System.out.println("Speed: " + Mario.speedX + "/" + Mario.speedY);
				
				collision = true;
				//ePolices.add(new Rectangle(c.getMinX(), c.getMinY(), enemyDragonTex.getWidth(), enemyDragonTex.getHeight()));
				
				arr2[0].setX(marioShape.getMinX()-2);
				arr2[0].setY(marioShape.getMinY()-2);
				arr2[1].setX(marioShape.getMaxX()-2);
				arr2[1].setY(marioShape.getMinY()-2);
				arr2[2].setX(marioShape.getMinX()-2);
				arr2[2].setY(marioShape.getMaxY()-2);
				arr2[3].setX(marioShape.getMaxX()-2);
				arr2[3].setY(marioShape.getMaxY()-2);
				
				botE = topE = leftE = rightE = false;
				
				//bot right corner 
				if (c.contains(arr2[3].getX(), arr2[3].getY())){
					if (c.contains(arr2[1].getX(), arr2[1].getY())) 
						rightE = true;
					else if (c.contains(arr2[2].getX(), arr2[2].getY())){
						botE = true;
						System.out.println(Mario.speedY);
						System.out.println("bot right");
					}
						
					else {
						x = Math.abs(arr2[3].getX()-c.getMinX());
						y = Math.abs(arr2[3].getY()-c.getMinY());
						if (x>y) botE = true; 
						else if (x<y) rightE = true;
						else {
							botE = true;
							rightE = true;
						}
					}
				//bot left corner	
				} else if (c.contains(arr2[2].getX(), arr2[2].getY())){
					if (c.contains(arr2[0].getX(), arr2[0].getY()))
						leftE = true;
					else {
						x = Math.abs(arr2[2].getX()-c.getMaxX());
						y = Math.abs(arr2[2].getY()-c.getMinY());
						if (x>y) {
							botE = true; 
							System.out.println("bot right");
						}
						else if (x<y) leftE = true;
						else {
							botE = true;
							leftE = true;
						}
					}	
				//top right corner
				} else if (c.contains(arr2[1].getX(), arr2[1].getY())){
					if (c.contains(arr2[0].getX(), arr2[0].getY())) 
						topE = true;
					else {
						x = Math.abs(arr2[1].getX()-c.getMinX());
						y = Math.abs(arr2[1].getY()-c.getMaxY());
						if (x>y || y==19) topE = true; 
						else if (x<y) rightE = true;
						else {
							topE = true;
							rightE = true;
						}
					}
				//top left corner
				} else if (c.contains(arr2[0].getX(), arr2[0].getY())){
					x = Math.abs(arr2[0].getX()-c.getMinX());
					y = Math.abs(arr2[0].getY()-c.getMaxY());
					if (x>y || y==19) topE = true; 
					else if (x<y) leftE = true;
					else {
						top = true;
						left = true;
					}
				}
				
				
				if (botE){
					enemyList.remove(i);
				}else if (leftE || rightE || topE)
					HP--;
				killMario = true;
				
				
			}
		}
		
	}

}*/
