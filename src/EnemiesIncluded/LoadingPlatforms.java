package EnemiesIncluded;

import org.newdawn.slick.geom.Rectangle;

public class LoadingPlatforms extends GameState {
	public LoadingPlatforms (){
		
	}
	public static void start(){
		for (int i=0; i<X; i+=texSize){
			platforms.add(platform_basic);
			platformsShapes.add(new Rectangle(i, bottom, texSize, texSize));
		
		}
		platforms.add(platform_basic);
		platformsShapes.add(new Rectangle (200, 400, texSize, texSize));
		
		platforms.add(platform_basic);
		platformsShapes.add(new Rectangle (200-texSize, 400+texSize, texSize, texSize));
		
		platforms.add(platform_basic);
		platformsShapes.add(new Rectangle (200-2*texSize, 400+2*texSize, texSize, texSize));
		platforms.add(platform_basic);
		
		platformsShapes.add(new Rectangle (200-3*texSize, 400+3*texSize, texSize, texSize));
		
		platforms.add(platform_basic);
		platformsShapes.add(new Rectangle (X-texSize*4, bottom-4*texSize, texSize, texSize));
		
		platforms.add(platform_basic);
		platformsShapes.add(new Rectangle (0, bottom-2*texSize, texSize, texSize));
		
		int count = 0;
		for (Rectangle rec : platformsShapes){
			count++;
			System.out.println("Rectangle " + count + " [" + rec.getX() + ", " + rec.getY() + "]" + " [" + platformsShapes.indexOf(rec) + "]");
		}
	}

}
