package dragonhawk.kyperj.core.state;

import dragonhawk.kyperj.core.KyperJGame;
import dragonhawk.kyperj.core.graphics.GraphicsComponent;

public abstract class GameState {
	/*DEFAULT GAME STATE NAMES*/
	public static final String SPLASH_STATE = "splash";
	public static final String MAIN_MENU_STATE = "mainmenu";
	public static final String IN_GAME_STATE = "ingame";
	public static final String GAME_OVER_STATE = "gameover";

	private String name="";
	private boolean started  = false;
	private boolean done_loading = false;
	
	private boolean safeinit = false;
	
	public boolean hasSafeInit(){
		return safeinit;
	}
	
	public void setSafeInit(boolean init){
		this.safeinit = init;
	}
	
	public boolean isDoneLoading(){
		return done_loading;
	}
	
	public void finishLoading(){
		done_loading = true;
	}
	
	public boolean hasStarted(){
		return started;
	}
	
	public  abstract int getStateID();
	
	public String getStateName(){
		return name;
	}
	
	public void setStateName(String name){
		this.name = name;
	}
	
	public void start(){
		KyperJGame.getLoader().loadBegin(this);
		load();
		KyperJGame.getLoader().loadEnd(this);
		started = true;
	}
	
	public abstract void load();
	
	public abstract boolean SafeInit();
	
	public abstract void update(int delta);
	
	public abstract void render(GraphicsComponent g);
	
	public abstract void end();
}
