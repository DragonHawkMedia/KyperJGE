package dragonhawk.kyperj.core.input;

public interface GameInput {
	public static final int LEFT_MOUSE_BUTTON = 1;
	public static final int RIGHT_MOUSE_BUTTON = 3;
	
	/**
	 * update all game input/poll keys
	 */
	public void update_input();
	
	/**
	 * is keyboard key down
	 * @param Key the number of the key
	 * @return return whether the specified key is down
	 */
	public boolean isKeyDown(int Key);
	
	/**
	 * check to see if given mouse button is down
	 * @param MouseButton button in check
	 * @return - if the mouse button is down
	 */
	public boolean isMouseButtonDown(int MouseButton);
	
	public InputState getKeyState(int key);
	
	public InputState getMouseButtonState(int button);
	
	/**
	 * get the mouse pixel  x coordinate on the screen
	 * @return get mouse x
	 */
	public double getMouseX();
	
	/**
	 * get the mouse pixel y coordinate
	 * @return get mouse y
	 */
	public double getMouseY();
	
	/**
	 * amount of times key has been registered as pressed without being released
	 * @param key - the key to get count for
	 * @return int - amount
	 */
	public boolean isKeyReleased(int key);
	
	public static enum InputState{
		PRESSED_ONCE,
		PRESSED,
		RELEASED;
	}

}
