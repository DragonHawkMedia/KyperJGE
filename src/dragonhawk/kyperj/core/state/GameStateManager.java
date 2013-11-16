package dragonhawk.kyperj.core.state;

import java.util.HashMap;

import dragonhawk.kyperj.core.graphics.GraphicsComponent;

public class GameStateManager {
	
	private HashMap<String, GameState> states;
	
	private String prev_state = "";
	private String current_state = "";
	
	public GameStateManager(){
		states = new HashMap<String, GameState>();
		add(new SplashState(), GameState.SPLASH_STATE);
		current_state = GameState.SPLASH_STATE;
		prev_state = GameState.SPLASH_STATE;
	}
	
	public void add(GameState state, String key){
		states.put(key, state);
	}
	
	public void render(GraphicsComponent g){
		if(states.isEmpty())
			return;
		
		states.get(current_state).render(g);
	}
	
	public void update(int delta){
		if(states.isEmpty())
			return;
		states.get(current_state).update(delta);
	}
	
	public void changeState(String state){
		prev_state = current_state+"";
		current_state = state;
	}
	
	public void lastState(){
		current_state = prev_state;
	}
}
