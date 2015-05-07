package EnemiesIncluded;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;

public class PowerUp extends GameState {
	
	public int x;
	public int y;

	public void draw(Image image) {
		image.draw(x, y);
	}

	public static void start (){
		
		//Clear the array for re setting the stage
		powerUpList.clear();  
		
		
		//Creating new elements to Rectangle array defined in GameState. It gets the width and height of the texture for powerUp
		powerUpList.add(new Rectangle(395, 235, powerUpTex.getWidth(), powerUpTex.getHeight())); 
		powerUpList.add(new Rectangle(10, 550-2*texSize, powerUpTex.getWidth(), powerUpTex.getHeight()));

	
	}	
	
	public static void interaction () {
		//Starting a for loop which goes backwards from the array list. So we can delete from the end of the list.
		for (int i = powerUpList.size()-1; i>= 0; i-- )
		{
			Rectangle e = powerUpList.get(i);
			
			//If mario's boundingbox is intersecting with an element of the rectangle array remove the current element
			if (marioShape.intersects(e)){
				poweredUp = true; 
				powerUpList.remove(i);
		
			}
		}
		
	}
}
