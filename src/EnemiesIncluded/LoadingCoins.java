package EnemiesIncluded;

import org.newdawn.slick.geom.Rectangle;

public class LoadingCoins extends GameState {
	
	public LoadingCoins (){
		
	}
	
	public static void start(){
		coinsShapes.clear();
		
		//placement of coins in middle
		for (int i=0; i<6; i++){
			coinsShapes.add(new Rectangle(300+(i*40), 300, texSize, texSize));
		}
		
		//coins middle top
		for (int i=0; i<6; i++){
			coinsShapes.add(new Rectangle(300+(i*40), 160, texSize, texSize));
		}
		
		//coins top corner
		for (int i=0; i<3; i++){
			coinsShapes.add(new Rectangle(10+(i*40), 120, texSize, texSize));
		}
		
		//coins at the top
		for (int i=0; i<5; i++){
			coinsShapes.add(new Rectangle(400+(i*40), 20, texSize, texSize));
		}
		
		//coins at bottom corner
		for(int i=0; i<4; i++) {
			coinsShapes.add(new Rectangle(10+(i*40), 350, texSize, texSize));
		}
		
		//single coins
		coinsShapes.add(new Rectangle(700, 160, texSize, texSize));
		
		coinsShapes.add(new Rectangle(texSize*3, 240, texSize, texSize));
	}

}
