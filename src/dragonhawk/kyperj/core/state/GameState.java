package dragonhawk.kyperj.core.state;

import dragonhawk.kyperj.core.KyperJGame;
import dragonhawk.kyperj.core.graphics.GraphicsComponent;

public abstract class GameState {
	/*DEFAULT GAME STATE NAMES*/
	public static final String SPLASH_STATE = "splash";
	public static final String MAIN_MENU_STATE = "mainmenu";
	public static final String IN_GAME_STATE = "ingame";
	public static final String GAME_OVER_STATE = "gameover";

	public  abstract int getStateID();
	
	public void start(){
		KyperJGame.getLoader().loadBegin();
		
		KyperJGame.getLoader().loadEnd();
	}
	
	public abstract boolean init();
	
	public abstract void update(int delta);
	
	public abstract void render(GraphicsComponent g);
	
	public abstract void end();
}
