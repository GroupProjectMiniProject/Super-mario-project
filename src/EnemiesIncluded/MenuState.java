package EnemiesIncluded;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.state.transition.FadeInTransition;
import org.newdawn.slick.state.transition.FadeOutTransition;

public class MenuState extends BasicGameState {

	public void init(GameContainer container, StateBasedGame sbg)
			throws SlickException {
		
	}
	
	public void update(GameContainer container, StateBasedGame sbg, int delta)
			throws SlickException {
		if (container.getInput().isKeyPressed(Input.KEY_ENTER)) sbg.enterState(1, new FadeOutTransition(), new FadeInTransition());
	}
	
	public void render(GameContainer container, StateBasedGame sbg, Graphics g)
			throws SlickException {
		g.drawString("Stage 0", 50, 30);
		g.drawString("Hello Motherfucker!Press ENTER to start the game cunt", 50, 50);
	}

	public int getID() {

		return 0;
	}

}
