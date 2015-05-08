package EnemiesIncluded;

import org.newdawn.slick.geom.Rectangle;

public class LoadingPlatforms extends GameState {
	public LoadingPlatforms (){
	}
	public static void start(){
		
		//bottom ground
		for (int i=0; i<X; i+=texSize){
			platforms.add(platform_basic);
			platformsShapes.add(new Rectangle(i, bottom, texSize, texSize));
		}
		
		//middle ground
		for (int i=0; i<200; i+=texSize){
			platforms.add(platform_basic);
			platformsShapes.add(new Rectangle(i, 300, texSize, texSize));
		}
		
		//middle ground
		for (int i=0; i<150; i+=texSize){
		platforms.add(platform_basic);
		platformsShapes.add(new Rectangle (X-i, bottom-4*texSize, texSize, texSize));
		}
		
		//top ground
		for (int i=0; i<600; i+=texSize){
		platforms.add(platform_basic);
		platformsShapes.add(new Rectangle (i+texSize*6, texSize*3, texSize, texSize));
		}
		
		//top boundary
		for (int i=0; i<650; i+=texSize){
		platforms.add(platform_basic);
		platformsShapes.add(new Rectangle (i+texSize*4, -texSize, texSize, texSize));
		}
		
		//position of flag/end
		flagShape = new Rectangle(X-texSize, texSize*2, texSize, texSize);
		
		platforms.add(platform_basic);
		platformsShapes.add(new Rectangle (texSize*8, texSize*2, texSize, texSize)); //8
		
		platforms.add(platform_basic);
		platformsShapes.add(new Rectangle (texSize*8, -5, texSize, texSize));
		
		platforms.add(platform_basic);
		platformsShapes.add(new Rectangle (400, 400, texSize, texSize));
		
		platforms.add(platform_basic);
		platformsShapes.add(new Rectangle (X-texSize, 400, texSize, texSize));
		
		platforms.add(platform_basic);
		platformsShapes.add(new Rectangle (680, 350, texSize, texSize));
		
		platforms.add(platform_basic);
		platformsShapes.add(new Rectangle (650, 300, texSize, texSize));
		
		platforms.add(platform_basic);
		platformsShapes.add(new Rectangle (600, 250, texSize, texSize));
		
		platforms.add(platform_basic);
		platformsShapes.add(new Rectangle (400, 250, texSize, texSize));
		
		platforms.add(platform_basic);
		platformsShapes.add(new Rectangle (400-texSize, 250, texSize, texSize));
		
		platforms.add(platform_basic);
		platformsShapes.add(new Rectangle (150, texSize*6, texSize, texSize));
		
		platforms.add(platform_basic);
		platformsShapes.add(new Rectangle (150-texSize, texSize*6, texSize, texSize));
		
		platforms.add(platform_basic);
		platformsShapes.add(new Rectangle (150-texSize*2, texSize*6, texSize, texSize));
		
		platforms.add(platform_basic);
		platformsShapes.add(new Rectangle (texSize*6, 300-texSize, texSize, texSize));
		
		platforms.add(platform_basic);
		platformsShapes.add(new Rectangle (200, 400, texSize, texSize));
		
		platforms.add(platform_basic);
		platformsShapes.add(new Rectangle (200-texSize, 400+texSize, texSize, texSize));
		
		platforms.add(platform_basic);
		platformsShapes.add(new Rectangle (200-2*texSize, 400+2*texSize, texSize, texSize));
		
		platforms.add(platform_basic);
		platformsShapes.add(new Rectangle (200-3*texSize, 400+3*texSize, texSize, texSize));
		
		platforms.add(platform_basic);
		platformsShapes.add(new Rectangle (0, bottom-2*texSize, texSize, texSize));
		
		platforms.add(platform_basic);
		platformsShapes.add(new Rectangle (texSize*5, texSize*4, texSize, texSize));
		
	}

}
