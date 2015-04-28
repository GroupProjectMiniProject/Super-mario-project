package EnemiesIncluded;

import org.newdawn.slick.Input;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class KeyPressed extends GameState {
	public KeyPressed (){
		
	}
	public static void start(Input input, StateBasedGame sbg){
		
		
		//ESC
		if (input.isKeyPressed(Input.KEY_ESCAPE)) sbg.enterState(2, new FadeOutTransition(), new FadeInTransition());
				
		//Left&Right
		if (input.isKeyDown(Input.KEY_LEFT) && input.isKeyDown(Input.KEY_RIGHT)){
			if ((int)Mario.speedX != 0) Mario.speedX /= acc;
		}
		//Left
		else if (input.isKeyDown(Input.KEY_LEFT)){
			if ((int)Mario.speedX == 0 || (int)Mario.speedX > 0) Mario.speedX = -1.0f; else {
				if ((int)Mario.speedX >= -Mario.speedMax) Mario.speedX *= acc;
			}
		} 
		//Right
		else if (input.isKeyDown(Input.KEY_RIGHT)){
			if ((int)Mario.speedX == 0 || (int)Mario.speedX < 0) Mario.speedX = 1.0f; else {
				if ((int)Mario.speedX <= Mario.speedMax) Mario.speedX *= acc; 
			}
		}
		else {
		if ((int)Mario.speedX != 0) Mario.speedX /= acc;
		}
		
		//Up
		if (input.isKeyPressed(Input.KEY_UP) && !jump && allowed){
			Mario.speedY = -jumpSpeed;
			jump = true;
			fall = false;
			allowed = false;
		} else if (jump) {
			if (Mario.speedY < -0.8) 
				Mario.speedY /= gravity;
			else {
				Mario.speedY = 0;
				jump = false;
				fall = true;
			}
		} else if (fall && !bot){
			System.out.println("Falling");
			if (Mario.speedY == 0) Mario.speedY = 1.0f; 
			else {
				if (Mario.speedY < fallSpeed) Mario.speedY *= gravity; else Mario.speedY = fallSpeed;
			}
		}
		
		//Down
		if (input.isKeyDown(Input.KEY_DOWN)){
			//crouch
		}
		
		//Hp Back
		if (input.isKeyDown(Input.KEY_A)){
			killMario = false;
		}
		
	
	}

}
