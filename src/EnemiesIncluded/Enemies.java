package EnemiesIncluded;

import org.newdawn.slick.Image;


public class Enemies extends GameState {
	public int x;
	public int y;
	public static int speedMax;
	public static int health;
	public float speedX, speedY;
	
	


	public Enemies(int xpos, int ypos) {
		x = xpos;
		y = ypos;
	}



	public void draw(Image image) {
		image.draw(x, y);
		
	}



	public static void start() {
		
	
		for (int d=1; d<4; d++){
			enemyTexList.add(enemyDragonTex);
			enemyList.add(new Enemies(50*d, 300)); //I have to make the parameters linked to the X and Y coordinates??
			System.out.printf("Enemy %d loaded \n", d);

		
		}

	}

	

	

}