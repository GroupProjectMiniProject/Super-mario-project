package EnemiesIncluded;

import org.newdawn.slick.geom.Rectangle;

public class IntersectionCoin extends GameState {
	
	public IntersectionCoin (){
		
	}
	
	public static void start (){
		
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

		}
	}
}
