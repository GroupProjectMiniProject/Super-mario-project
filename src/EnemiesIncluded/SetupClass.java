package EnemiesIncluded;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class SetupClass extends StateBasedGame {
	
	public static int X = 800, Y = 600;
	
	public SetupClass(String title) {
		super(title);	
	}
	
	public static void main(String[] args) throws SlickException {
		
		//Settings for application
		AppGameContainer app = new AppGameContainer(new SetupClass("Setup Test"));
		app.setDisplayMode(X, Y, false);
		app.setAlwaysRender(true);
		app.setTargetFrameRate(60);
		app.setVSync(true);
		
		app.start();
	}

	public void initStatesList(GameContainer container) throws SlickException {
		
		//Adding of states into Slick2D pre-designed interface
		this.addState(new MenuState());
		this.addState(new GameState());
		this.addState(new GameOverState());
	}
	
}

