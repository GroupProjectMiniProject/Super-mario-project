package TestOndrej;

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
		platformsShapes.add(new Rectangle (X-texSize, bottom-5*texSize, texSize, texSize));
		
		platforms.add(platform_basic);
		platformsShapes.add(new Rectangle (X-texSize*5, bottom-4*texSize, texSize, texSize));
		
		platforms.add(platform_basic);
		platformsShapes.add(new Rectangle (0, bottom-2*texSize, texSize, texSize));
		
		int count = 0;
		for (Rectangle rec : platformsShapes){
			count++;
			System.out.println("Rectangle " + count + " [" + rec.getX() + ", " + rec.getY() + "]" + " [" + platformsShapes.indexOf(rec) + "]");
		}
	}

}
