package EnemiesIncluded;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class GameOverState extends BasicGameState {

	public void init(GameContainer container, StateBasedGame sbg)
			throws SlickException {
	}
	
	public void update(GameContainer container, StateBasedGame sbg, int delta)
			throws SlickException {
		if (container.getInput().isKeyPressed(Input.KEY_ENTER)) sbg.enterState(0, new FadeOutTransition(), new FadeInTransition());
		
	}
	
	public void render(GameContainer container, StateBasedGame sbg, Graphics g)
			throws SlickException {
		//Text for ending stage
		if (GameState.hitFlag){
			g.setColor(Color.yellow);
			//g.drawString("Stage 2", 50, 30);
			g.drawString("You Win!", 375, 290);
			g.setColor(Color.white);
		} 
		else {
			//g.drawString("Stage 2", 50, 30);
			g.setColor(Color.red);
			g.drawString("Game Over!", 375, 290);
			g.setColor(Color.white);
		}
		
	}

	public int getID() {
		
		return 2;
	}

}
