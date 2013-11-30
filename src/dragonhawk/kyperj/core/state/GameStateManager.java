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
		state.setStateName(key);
	}
	
	public void removeState(String state){
		states.remove(state);
	}
	
	public void startState(String state){
		states.get(state).start();
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
	
	public GameState getCurrentState(){
		return states.get(current_state);
	}
	
	public void changeState(String state){
		prev_state = current_state+"";
		current_state = state;
	}
	
	public GameState getGameState(String state){
		return states.get(state);
	}
	
	public void lastState(){
		current_state = prev_state;
	}
}
