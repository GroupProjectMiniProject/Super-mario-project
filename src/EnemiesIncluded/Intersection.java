package EnemiesIncluded;

import org.newdawn.slick.geom.Rectangle;

public class Intersection extends GameState {
	
	public Intersection (){
		
	}
	
	public static void start (){
		
		//Clearing array list for changing state
		polices.clear();
		System.out.println("------------Frame-------------");
		System.out.println("");
		System.out.println("------------Outter------------");
		collision = false;
		
		//For loop for all platforms
		for (Rectangle rec : platformsShapes){
			
			//If mario is intersecting a platform
			if (marioShape.intersects(rec)){
				
				//System.out.println("=>Outter Collision: " + platformsShapes.indexOf(rec));
				//System.out.println("Speed: " + Mario.speedX + "/" + Mario.speedY);
				
				//Set collision to true 
				collision = true;
				//Add a policy to use later for checking visually in the game if collision happened
				polices.add(new Rectangle(rec.getMinX(), rec.getMinY(), texSize, texSize));
				
				//Setting some array pointers for checking which part of Mario is intersecting so he can be set accordingly
				//It is set 1 pixel less to make sure mario can jump in between a space that is his own size in height
				arr2[0].setX(marioShape.getMinX()+1);
				arr2[0].setY(marioShape.getMinY()+1);
				arr2[1].setX(marioShape.getMaxX()-1);
				arr2[1].setY(marioShape.getMinY()+1);
				arr2[2].setX(marioShape.getMinX()+1);
				arr2[2].setY(marioShape.getMaxY()-1);
				arr2[3].setX(marioShape.getMaxX()-1);
				arr2[3].setY(marioShape.getMaxY()-1);
				
				bot = top = left = right = false;
				
				//Bot Right Corner
				//If platform contains the bottom right corner of Mario start a new if statement
				if (rec.contains(arr2[3].getX()+1, arr2[3].getY())){
					//If platform contains the top right corner of Mario set right to true
					if (rec.contains(arr2[1].getX(), arr2[1].getY())) 
						right = true;
					//If it doens't then else if platform contains the top bottom left corner set bot to true 
					else if (rec.contains(arr2[2].getX(), arr2[2].getY())){
						bot = true;
						//System.out.println(Mario.speedY);
						//System.out.println("bot right");
					}
					//This is if both right and bot a true. If they are we need to find whether mario should be 
					//placed left of the the square or top of the square. 
					//If x is larger it means that mario is further inside the platform on the x axis. And therefore he should be put on top of it.
					//If y is larger it means that mario is further inside the platform on the y axis. Therefore right is true. 
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
				//Bottom left corner
				// if platform contains the bottom left corner of mario go to the next if statement
				} else if (rec.contains(arr2[2].getX(), arr2[2].getY())){
					// if platform contains top left corner of mario then set left to true else continue to calculate x and y and shown above 
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
				//Top right corner
					//If the platform contaons top right corner of mario go to the next if statement
				} else if (rec.contains(arr2[1].getX(), arr2[1].getY())){
					//If the platform contain the top left corner set top to true
					if (rec.contains(arr2[0].getX(), arr2[0].getY())) 
						top = true;
					else { //This is shown in "Bottom right corner"
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
					//If the platform contains top left corner of mario go to the next if statement
					//if it contains the top left corner then continue as shown in "Bottom right corner"
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
				
				//If top then set Mario's y pos to the bottom left corner of the platform
				//Set jump to false and fall to true so that mario will fall down again
				if (top){
					Mario.y = (int)(rec.getMaxY());
					marioShape.setY(Mario.y);
					jump = false;
					fall = true;
					Mario.speedY = 0;
					//System.out.println("top");
				}
				//If bot set mario's y to the top left corner of the platform minus mario's heigth
				//Set the speed of Y and fall to false so he will remain in place
				if (bot){
					Mario.y = (int)(rec.getMinY()-marioShape.getHeight());
					marioShape.setY(Mario.y);
					Mario.speedY = 0;
					allowed = true;
					fall = false;
					
					//System.out.println("bot");
				}
				//if right then set mario's x pos to the platforms top right corner minus mario's width
				// set speed of X to 0 so he can't continue moving through the plaform
				if (right){
					Mario.x = (int)(rec.getMinX()-marioShape.getWidth());
					marioShape.setX(Mario.x);
					Mario.speedX = 0;
					//System.out.println("right");
				}
				//if left then set mario's x pos to the platforms top left corner and set his speed X to 0
				//So he won't move through the platform. 
				if (left){
					Mario.x = (int)rec.getMaxX();
					marioShape.setX(Mario.x);	
					Mario.speedX = 0;
					//System.out.println("left");
				}
				//System.out.println("----------------");
				
			}
		}
		//Check if there is no collision and set fall to true if it is
		if (!collision){
			//System.out.println("Outter: No Collisions");
			
			fall = true;
		}	
		//If mario's center x and y are touching the flag set finish  and hitflag to true 
	if (flagShape.contains(marioShape.getCenterX(), marioShape.getCenterY())) {
		finish = true; 
		hitFlag = true;
	}
		
	//****************************************************************************// Change
		//Enemy Intersections with platform
		//For each element for enemyList
		for (Enemies d: enemyList){
	
		//Set the parameters for each enemies to false for making sure each cycle is clean 
		d.outerCollision = false; 
		d.innerCollision = false;}
	
		//For each platform
		for (Rectangle rec : platformsShapes){
			
			//For each element for enemyList
			for (Enemies dragons: enemyList)
			{
				//Setting variables
				Rectangle o = dragons.enemyOuterShape;
				Rectangle i = dragons.enemyInnerShape;
				Enemies e = dragons;
				boolean b = dragons.bot; 
				boolean t = dragons.top; 
				boolean r = dragons.right; 
				boolean l = dragons.left; 

				//if the outerShape of enemy is intersecting with plaform set the outercollision to true. 
				if (o.intersects(rec))
					dragons.outerCollision = true;
				
				//if the innerShape of enemy is intersecting with plaform set the innerCollison to true. 
				if (i.intersects(rec)){
					
					dragons.innerCollision = true;
					b = t = l = r = false; 
					x = y = 0; 
				
					//The code below is very similar to the above code where mario is intersecting with platforms.
					//The only difference is that we are using the innershape and outershape rectangles to define the corner 
					//points. Instead of using the pointer array
					
				//Bot Right Corner
				if (rec.contains(i.getMaxX(), i.getMaxY())){
					if (rec.contains(i.getMaxX(), i.getMinY()))
						r = true;
					else if (rec.contains(i.getMinX(), i.getMaxY()))
						b = true; 
					
				} else {
					x = Math.abs(i.getMaxX()-rec.getMinX());
					y = Math.abs(i.getMaxY()-rec.getMinY());
					if (x>y) b = true; 
					else if (x<y) r = true; 
					else {
						b = true; 
						r = true; 
					}					
				}
				
				//Bot Left Corner
				} else if (rec.contains(i.getMinX(), i.getMaxY())){
					if (rec.contains(i.getMinX(), i.getMinY())){
						l = true;
					}
					
					else {
						x = Math.abs(i.getMinX()-rec.getMaxX());
						y = Math.abs( i.getMaxY()-rec.getMinY());

						if (x>y) {
							b = true;

						}
						else if (x<y) l = true;
						else {

							b = true;
							l = true;
						}
					}
					//Top Right Corner
				} else if (rec.contains(i.getMaxX(), i.getMinY())){
					if (rec.contains(i.getMinX(), i.getMinY())) 
						t = true;
					else {
						x = Math.abs(i.getMaxX()-rec.getMinX());
						y = Math.abs(i.getMinY()-rec.getMaxY());
						if (x>y || y==0) t = true; 
						else if (x<y) r = true;
						else {

							t = true;
							r = true;
						}
					}
					//Top Left Corner
				} else if (rec.contains(i.getMinX(), i.getMinY())){
					x = Math.abs(i.getMinX()-rec.getMaxX());
					y = Math.abs(i.getMinY()-rec.getMaxY());
					if (x>y || y==0) {
						t = true; 
					}
					else if (x<y) l = true; 
					else {

						t = true;
						l = true;
					}
				}
				
				if (t){
					e.y = (int)(rec.getMaxY());
					e.falling = true;
					e.speedY = 1.0f;

				}
				if (b){
					e.y = (int)(rec.getMinY()-o.getHeight());
					e.speedY = 0;
					e.falling = false;

				}
				
				if (r){
					e.x = (int)(rec.getMinX()-o.getWidth());
					e.speedX = -1.0f;
					

				}
				if (l){
					e.x = (int)rec.getMaxX();
					e.speedX = 1.0f;
				}
			}
			
		}
		for(Enemies e : enemyList){
		if (!e.outerCollision && !e.innerCollision){
			e.falling = true;
		}
		}
	
		
		//This is activating the falling boolean for enemies. So if activated enemy will 
		//Fall down. 
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
		//Intersection with coins are just checking if mario is intersecting with coins and increment the integer 
		//coinCollection
	//COIN intersection START
		for (Rectangle coins : coinsShapes)
		{
			if (marioShape.intersects(coins))
			coinCollection++;

		}	
		//THis is removing the coins by setting the touched coin to last element of the list and removing it  .
		for (int i = coinsShapes.size()-1; i>= 0; i--){
			Rectangle rec =  coinsShapes.get(i);

			if (marioShape.intersects(rec)){
				coinsShapes.remove(i);
			}

		}//COIN intersection END 
		

	}
}
