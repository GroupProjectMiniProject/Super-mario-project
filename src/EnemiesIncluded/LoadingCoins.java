package EnemiesIncluded;

import org.newdawn.slick.geom.Rectangle;

public class LoadingCoins extends GameState {
	
	public LoadingCoins (){
		
	}
	
	public static void start(){
		for (int i=0; i<10; i+=texSize){
			coin.add(money);
			coinsShapes.add(new Rectangle(300, 300, texSize, texSize));
		}
		
		coin.add(money);
		coinsShapes.add(new Rectangle (X-texSize, bottom-2*texSize, texSize, texSize));
		
		coin.add(money);
		coinsShapes.add(new Rectangle (X-texSize*5, bottom-3*texSize, texSize, texSize));
		
		coin.add(money);
		coinsShapes.add(new Rectangle (0, bottom-3*texSize, texSize, texSize));
		
		int coinCount = 0;
		for (Rectangle rec : coinsShapes){
			coinCount++;
			System.out.println("Rectangle " + coinCount + " [" + rec.getX() + ", " + rec.getY() + "]" + " [" + coinsShapes.indexOf(rec) + "]");
			
		}
	}

}
