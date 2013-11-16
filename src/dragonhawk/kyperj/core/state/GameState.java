package dragonhawk.kyperj.core.state;

import dragonhawk.kyperj.core.graphics.GraphicsComponent;

public interface GameState {
	/*DEFAULT GAME STATE NAMES*/
	public static final String SPLASH_STATE = "splash";
	public static final String MAIN_MENU_STATE = "mainmenu";
	public static final String IN_GAME_STATE = "ingame";
	public static final String GAME_OVER_STATE = "gameover";

	public int getStateID();
	
	public void update(int delta);
	
	public void render(GraphicsComponent g);
}
