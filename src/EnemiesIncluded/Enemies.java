package EnemiesIncluded;


//import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;


public class Enemies extends GameState {
	
	
	//Creating memory for rectangles that will define collision 
	public  Rectangle BoundingBoxRed;
	public  Rectangle BoundingBoxPurple;
	public  Rectangle enemyInnerShape;
	public  Rectangle enemyOuterShape;

	public int x;
	public int y;
	public int overX;
	public int belowX;
	public float speedX;
	public float speedY;
	public boolean falling;
	public boolean bot;
	public boolean top;
	public boolean right;
	public boolean left;
	public boolean outerCollision, innerCollision; 


	//Creating a method to give enemies different parameters. Parameters makes sure that each element of enemyList array 
	//have their own pos, speed, boundingboxes etc.
	public Enemies(int xpos, int ypos, float spX, float spY, int ovrX, int blwX, Rectangle eOtS, Rectangle bndboxR, Rectangle bndboxP, Rectangle eInS, boolean falls, boolean bo, boolean to, boolean righ, boolean lef, boolean outCol, boolean inCol) {
		
		x = xpos;
		y = ypos;
		speedX = spX;
		speedY = spY;
		overX = ovrX+xpos;
		belowX = xpos-blwX;
		BoundingBoxRed = bndboxR;
		BoundingBoxPurple = bndboxP;
		enemyInnerShape = eInS;
		enemyOuterShape = eOtS;
		bot = bo;
		top = to; 
		right = righ;
		left = lef; 
		falling = falls;
		outerCollision = outCol;
		innerCollision = inCol; 

	}
	
	public  void start() {
		
		//Clearing arrayList for new stage 
		enemyList.clear();
		
		//Add new elements to enemyList.
		enemyList.add(new Enemies(2*texSize, bottom-11*texSize, 0.0f, 0.0f, 50, 50, enemyOuterShape, BoundingBoxRed, BoundingBoxPurple, enemyInnerShape, false, false, false, false, false, false, false)); //Change
		System.out.printf("Enemy loaded \n");
		
		enemyList.add(new Enemies(texSize, bottom-texSize-10, 0.0f, 0.0f, 50, 50, enemyOuterShape, BoundingBoxRed, BoundingBoxPurple, enemyInnerShape, false, false, false, false, false, false, false)); //Change
		System.out.printf("Enemy loaded \n");
		
		enemyList.add(new Enemies(Y-4*texSize, bottom-5*texSize, 0.0f, 0.0f, 50, 50, enemyOuterShape, BoundingBoxRed, BoundingBoxPurple, enemyInnerShape, false, false, false, false, false, false, false)); //Change
		System.out.printf("Enemy loaded \n");
		
		enemyList.add(new Enemies(500, texSize, 0.0f, 0.0f, 50, 50, enemyOuterShape, BoundingBoxRed, BoundingBoxPurple, enemyInnerShape, false, false, false, false, false, false, false)); //Change
		System.out.printf("Enemy loaded \n");
	}
	
	
	
	public static void intersection() {
		
			for(Enemies dragonas: enemyList ){
			
			//Creating bounding boxes for collision detection
				
			//enemyOuterShape is normal shape of our Enemies
			dragonas.enemyOuterShape = new Rectangle(dragonas.x, dragonas.y, enemyDragonTex.getWidth(), enemyDragonTex.getHeight());
			//enenmyInnerShape is one pixel less than normal shape
			dragonas.enemyInnerShape = new Rectangle  (dragonas.x+1, dragonas.y+1, enemyDragonTex.getWidth()-2, enemyDragonTex.getHeight()-2); //Change
			
			//Lower body enemy boundingbox setting
			dragonas.BoundingBoxPurple = new Rectangle(dragonas.x+3, dragonas.y+12, enemyDragonTex.getWidth()-4, enemyDragonTex.getHeight()/2);
			//Upper body enemy boundingbox setting
			dragonas.BoundingBoxRed = new Rectangle(dragonas.x+3, dragonas.y-2, enemyDragonTex.getWidth()-4, enemyDragonTex.getHeight()-22);
			
			}	
			
			//Enemy-mario interaction.
			
			for (int i = enemyList.size()-1; i>= 0; i--){
				Rectangle e = enemyList.get(i).BoundingBoxPurple;
				Rectangle d = enemyList.get(i).BoundingBoxRed;
				
				//Setting array points according to marioShape edges
				
				//Top Left corner
				arr2[0].setX(marioShape.getMinX()+1);
				arr2[0].setY(marioShape.getMinY()+1);
				//Top Right corner
				arr2[1].setX(marioShape.getMaxX()-1);
				arr2[1].setY(marioShape.getMinY()+1);
				//Bot Left corner
				arr2[2].setX(marioShape.getMinX()+1);
				arr2[2].setY(marioShape.getMaxY()-1);
				//Bot Right corner
				arr2[3].setX(marioShape.getMaxX()-1);
				arr2[3].setY(marioShape.getMaxY()-1);
				
				
				//When BoundingBoxRed (upper body of enemy) contains bottom right and left corner of mario
				//then remove element i of enemyList which is the current one.
				if (d.contains(arr2[2].getMinX(), arr2[2].getMinY())||d.contains(arr2[3].getMinX(), arr2[3].getMinY())){
					enemyList.remove(i); 
				
				//else if marioshape hits BoundingBoXRed (lower body of enemy) set powered up to false and remove 
				//enemy hit. If mario was powered up then set deduct a Health point from mario and set killmario to false
				} else if (marioShape.intersects(e)){
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
	

	

