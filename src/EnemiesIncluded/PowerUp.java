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
		
		for (int i = 0; i < 2; i++){
			powerUpTexList.add(powerUpTex);
			powerUpList.add(new Rectangle(200+(i*400), 550, powerUpTex.getWidth(), powerUpTex.getHeight()));

			
		}
	
	}	
	public static void interaction () {
		
		for (int i = powerUpList.size()-1; i>= 0; i-- )
		{
			Rectangle e = powerUpList.get(i);
			
			if (marioShape.intersects(e)){
				poweredUp = true; 
				powerUpList.remove(i);
		
			}
		}
		
	}
}
