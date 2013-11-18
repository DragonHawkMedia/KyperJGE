package dragonhawk.kyperj.core.input;

import java.awt.AWTEvent;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import dragonhawk.kyperj.core.KyperJGame;

public class Java2DGameInput implements GameInput{
	
	/*WHAT EVENTS TO PICK UP*/
	public static final long eventMask = AWTEvent.MOUSE_MOTION_EVENT_MASK
										+ AWTEvent.MOUSE_EVENT_MASK
										+ AWTEvent.KEY_EVENT_MASK;
	/*KEY BOOLEANS TRUE IF PRESSED*/
	private boolean KEYS[] = new boolean[700];
	/*MOUSE BUTTONS BOOLEANS TRUE IF PRESSED*/
	private boolean MOUSE_BUTTONS[] = new boolean[10];
	/*MOUSE X*/
	private double MOUSE_X = 0;
	/*MOUSE Y*/
	private double MOUSE_Y = 0;
	/*OUR CONTAINING GAME*/
	private KyperJGame game;
	
	public Java2DGameInput(KyperJGame game){
		this.game = game;
		//ADD AWT LISTENER TO DEFAULT TOOLKIT -- GLOBAL LISTENING
		Toolkit.getDefaultToolkit().addAWTEventListener(new AWTEventListener() {
			
			//EVENT CALL BACK
			@Override
			public void eventDispatched(AWTEvent event) {
				//check mouse event
				if(event instanceof MouseEvent){
					MouseEvent e = (MouseEvent)event;
					//update the x and y
					MOUSE_X = e.getX();
					MOUSE_Y = e.getY();
					//update mouse button to pressed
					if(e.getID()==MouseEvent.MOUSE_PRESSED){
						MOUSE_BUTTONS[e.getButton()] = true;
					}
					//update mouse button to released
					if(e.getID()==MouseEvent.MOUSE_RELEASED){
						MOUSE_BUTTONS[e.getButton()] = false;
					}
					
				}
				
				//check key event
				if(event instanceof KeyEvent){
					KeyEvent e = (KeyEvent)event;
					//update the key to pressed
					if(e.getID()==KeyEvent.KEY_PRESSED){
						KEYS[e.getKeyCode()] = true;
					}
					//update the key to released
					if(e.getID()==KeyEvent.KEY_RELEASED){
						KEYS[e.getKeyCode()] = false;
					}
					
					if(e.getID()==KeyEvent.KEY_TYPED){
					}
				}
				
			}
		}, eventMask);
	}
	@Override
	public void update_input() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isKeyDown(int Key) {
		return KEYS[Key];
	}

	@Override
	public boolean isMouseButtonDown(int MouseButton) {
		return MOUSE_BUTTONS[MouseButton];
	}

	@Override
	public double getMouseX() {
		if(MOUSE_X < 0)
			return 0;
		if(MOUSE_X/game.getGameDisplay().getDisplaySettings().getScale() 
		         >game.getGameDisplay().getDisplaySettings().getWidth())
			return game.getGameDisplay().getDisplaySettings().getWidth();
		return MOUSE_X/game.getGameDisplay().getDisplaySettings().getScale();
	}

	@Override
	public double getMouseY() {
		if(MOUSE_Y < 0)
			return 0;
		if(MOUSE_Y/game.getGameDisplay().getDisplaySettings().getScale() 
		         >game.getGameDisplay().getDisplaySettings().getHeight())
			return game.getGameDisplay().getDisplaySettings().getHeight();
		return MOUSE_Y/game.getGameDisplay().getDisplaySettings().getScale();
	}

}
