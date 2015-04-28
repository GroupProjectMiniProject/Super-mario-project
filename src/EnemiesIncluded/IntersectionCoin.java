package EnemiesIncluded;

import org.newdawn.slick.geom.Rectangle;

public class IntersectionCoin extends GameState {
	
	public IntersectionCoin (){
		
	}
	
	public static void start (){
		
		Cpolices.clear();
		//System.out.println("------------Frame-------------");
		//System.out.println("");
		//System.out.println("------------Outter------------");
		collision = false;
		
		for (Rectangle rec : coinsShapes){
			if (marioShape.intersects(rec)){
				
				
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
				/*
				//bot right corner 
				if (rec.contains(arr3[3].getX()+1, arr3[3].getY())){
					if (rec.contains(arr3[1].getX(), arr3[1].getY())) 
						right = true;
					else if (rec.contains(arr3[2].getX(), arr3[2].getY())){
						bot = true;
						System.out.println(Mario.speedY);
						System.out.println("bot right");
					}
						
					else {
						x = Math.abs(arr3[3].getX()-rec.getMinX());
						y = Math.abs(arr3[3].getY()-rec.getMinY());
						if (x>y) bot = true; 
						else if (x<y) right = true;
						else {
							bot = true;
							right = true;
						}
					}
				//bot left corner	
				} else if (rec.contains(arr3[2].getX(), arr3[2].getY())){
					if (rec.contains(arr3[0].getX(), arr3[0].getY()))
						left = true;
					else {
						x = Math.abs(arr3[2].getX()-rec.getMaxX());
						y = Math.abs(arr3[2].getY()-rec.getMinY());
						if (x>y) {
							bot = true; 
							System.out.println("bot right");
						}
						else if (x<y) left = true;
						else {
							bot = true;
							left = true;
						}
					}	
				//top right corner
				} else if (rec.contains(arr3[1].getX(), arr3[1].getY())){
					if (rec.contains(arr3[0].getX(), arr3[0].getY())) 
						top = true;
					else {
						x = Math.abs(arr3[1].getX()-rec.getMinX());
					    y = Math.abs(arr3[1].getY()-rec.getMaxY());
						if (x>y || y==19) top = true; 
						else if (x<y) right = true;
						else {
							top = true;
							right = true;
						}
					}
				//top left corner
				} else if (rec.contains(arr3[0].getX(), arr3[0].getY())){
					x = Math.abs(arr3[0].getX()-rec.getMinX());
					y = Math.abs(arr3[0].getY()-rec.getMaxY());
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
					//jump = false;
					//fall = true;
					//Mario.speedY = 0;
					System.out.println("top");
				}
				if (bot){
					Mario.y = (int)(rec.getMinY()-marioShape.getHeight());
					marioShape.setY(Mario.y);
					//Mario.speedY = 0;
					//allowed = true;
					//fall = false;
					System.out.println("bot");
				}
				
				if (right){
					Mario.x = (int)(rec.getMinX()-marioShape.getWidth());
					marioShape.setX(Mario.x);
					//Mario.speedX = 0;
					System.out.println("right");
				}
				if (left){
					Mario.x = (int)rec.getMaxX();
					marioShape.setX(Mario.x);	
					//Mario.speedX = 0;
					System.out.println("left");
				}
				*/
				//System.out.println("----------------");
				
			}
		}
		//if (!collision){
		//System.out.println("Outter: No Collisions");
			
		//}
	}

}
