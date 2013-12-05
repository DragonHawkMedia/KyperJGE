package dragonhawk.kyperj.core.graphics.gui;

import java.util.ArrayList;

import dragonhawk.kyperj.core.graphics.GraphicsComponent;

public class GameContainer implements GameComponent{
	
	private boolean master = false;
	private GameGui gg;
	private GameComponent parent;
	private ArrayList<GameComponent> components;
	
	public GameContainer(){
		this.components = new ArrayList<>();
	}

	@Override
	public boolean hasParent() {
		return !master;
	}

	@Override
	public GameComponent getParent() {
		if(!master)
			return parent;
		return null;
	}

	@Override
	public void setX(double x) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setY(double y) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setWidth(double width) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setHeight(double height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double getWidth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isDirty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean hasFocus() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void requestFocus() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void restoreOrder() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void organize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isVisible() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setVisible(boolean visible) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean hasChildren() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public GameComponent[] getChildren() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setParent(Object parent) {
		if(parent instanceof GameGui){
			master = true;
			gg = (GameGui) parent;
		}else if(parent instanceof GameComponent){
			this.parent = (GameComponent) parent;
		}
		
	}

	@Override
	public void render(GraphicsComponent g) {
		// TODO Auto-generated method stub
		
	}

}
