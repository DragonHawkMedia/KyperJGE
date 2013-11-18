package dragonhawk.kyperj.core.input;

import java.awt.AWTEvent;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import dragonhawk.kyperj.core.KyperJGame;

public class Java2DGameInput implements GameInput{
	
	public static final long eventMask = AWTEvent.MOUSE_MOTION_EVENT_MASK
		    + AWTEvent.MOUSE_EVENT_MASK
		    + AWTEvent.KEY_EVENT_MASK;
	private boolean KEYS[] = new boolean[700];
	private boolean MOUSE_BUTTONS[] = new boolean[10];
	private double MOUSE_X = 0;
	private double MOUSE_Y = 0;
	private KyperJGame game;
	
	public Java2DGameInput(KyperJGame game){
		this.game = game;
		Toolkit.getDefaultToolkit().addAWTEventListener(new AWTEventListener() {
			
			@Override
			public void eventDispatched(AWTEvent event) {
				if(event instanceof MouseEvent){
					MouseEvent e = (MouseEvent)event;
					MOUSE_X = e.getX();
					MOUSE_Y = e.getY();
					
					if(e.getID()==MouseEvent.MOUSE_PRESSED){
						MOUSE_BUTTONS[e.getButton()] = true;
					}
					if(e.getID()==MouseEvent.MOUSE_RELEASED){
						MOUSE_BUTTONS[e.getButton()] = false;
					}
					
				}
				if(event instanceof KeyEvent){
					KeyEvent e = (KeyEvent)event;
					if(e.getID()==KeyEvent.KEY_PRESSED){
						KEYS[e.getKeyCode()] = true;
					}
					
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
		return MOUSE_X*game.getGameDisplay().getDisplaySettings().getScale();
	}

	@Override
	public double getMouseY() {
		return MOUSE_Y*game.getGameDisplay().getDisplaySettings().getScale();
	}

}
