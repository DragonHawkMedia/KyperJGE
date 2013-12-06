package dragonhawk.kyperj.core.graphics.gui;

import java.awt.Color;

import dragonhawk.kyperj.core.KyperJGame;
import dragonhawk.kyperj.core.display.GameDisplay;
import dragonhawk.kyperj.core.graphics.GraphicsComponent;
import dragonhawk.kyperj.core.input.GameInput;
import dragonhawk.kyperj.core.input.GameInput.InputState;

public class GameButton implements GameComponent{
	
	private KyperJGame game;
	private boolean hasfocus = false;
	private boolean visible = false;
	private boolean hasParent = false;
	private boolean pressed = false;
	private boolean hovered = false;
	private GameButtonCallback callback;
	private boolean dirty = false;
	private GameComponent parent;
	private double x , y , width , height;
	private String s;
	
	public GameButton(){
		this("");
	}
	
	public GameButton(String s){
		game = KyperJGame.getGame();
		this.s = s;
		width = 30;
		height = 10;
		callback = new GameButtonCallback() {
			public void buttonPressed(GameButton button) {System.out.println("pressed");}
			public void buttonExited(GameButton button) {System.out.println("exited");}
			public void buttonEntered(GameButton button) {System.out.println("entered");}
		};
	}

	@Override
	public boolean hasParent() {
		return parent!=null;
	}

	@Override
	public GameComponent getParent() {
		return parent;
	}

	@Override
	public void setX(double x) {
		this.x = x+parent.getX();
		
	}

	@Override
	public void setY(double y) {
		this.y = y+parent.getY();
		
	}

	@Override
	public void setWidth(double width) {
		this.width = width;
	}

	@Override
	public void setHeight(double height) {
		this.height = height;
		
	}

	@Override
	public double getWidth() {
		return width;
	}

	@Override
	public double getHeight() {
		return height;
	}

	@Override
	public int getX() {
		return (int)x;
	}

	@Override
	public int getY() {
		return (int)y;
	}

	@Override
	public void update() {
		GameInput in= KyperJGame.getInput();
		double mx = in.getMouseX();
		double my = in.getMouseY();
		if(mx >= getX() && my >= getY() && mx <= getX()+getWidth() && my <= getY()+getHeight()){
			if(!hovered){
				callback.buttonEntered(this);
				hovered = true;
			}
			if(in.getMouseButtonState(1)==InputState.PRESSED_ONCE){
				callback.buttonPressed(this);
			}
		}else{
			if(hovered){
				callback.buttonExited(this);
				hovered = false;
			}
		}
		
		
	}

	@Override
	public boolean isDirty() {
		return dirty;
	}

	@Override
	public boolean hasFocus() {
		return hasfocus;
	}

	@Override
	public void requestFocus() {
		
	}

	@Override
	public void restoreOrder() {
		
	}

	@Override
	public void organize() {
	}

	@Override
	public boolean isVisible() {
		return visible;
	}

	@Override
	public void setVisible(boolean visible) {
		this.visible = visible;
		
	}

	@Override
	public boolean hasChildren() {
		return false;
	}

	@Override
	public GameComponent[] getChildren() {
		return null;
	}

	@Override
	public void setParent(Object parent) {
		if(parent instanceof GameContainer){
			this.parent = (GameContainer)parent;
		}
		
	}

	@Override
	public void render(GraphicsComponent g) {
		g.setColor(Color.GRAY);
		g.fillRect((int)x, (int)y, (int)width, (int)height);
	}
	
	public void addButtonCallback(GameButtonCallback callback){
		this.callback = callback;
	}
	
}
