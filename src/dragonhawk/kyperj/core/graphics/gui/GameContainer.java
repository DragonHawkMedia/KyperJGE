package dragonhawk.kyperj.core.graphics.gui;

import java.util.ArrayList;

import dragonhawk.kyperj.core.graphics.GraphicsComponent;

public class GameContainer implements GameComponent{
	
	private boolean master = false;
	private double x = 0;
	private double y = 0;
	private double width = 0;
	private boolean hasfocus = false;
	private boolean visible = false;
	private boolean dirty = false;
	private double height = 0;
	private GameGui gg;
	private GameComponent parent;
	private ArrayList<GameComponent> components;
	private GameComponent currentFocus;
	
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
		this.x =x;
		
	}

	@Override
	public void setY(double y) {
		this.y = y;
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
		for (int i = 0; i < components.size(); i++) {
			if(components.get(i).isVisible())
				if(components.get(i).hasFocus())
					currentFocus = components.get(i);
				components.get(i).update();
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
		hasfocus = true;
		if(hasParent())
			parent.requestFocus();
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
		return components.size()>0;
	}
	
	public void add(GameComponent comp){
		
	}

	@Override
	public GameComponent[] getChildren() {
		return components.toArray(new GameComponent[components.size()]);
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
		for (int i = 0; i < components.size(); i++) {
			if(components.get(i).isVisible())
				if(currentFocus!=null){
					if(components.get(i)!=currentFocus)
						components.get(i).render(g);
				}else{
					components.get(i).render(g);
				}
		}
		for (int i = 0; i <	1000; i++) {
			g.drawString("this is the gui", i, i, gg.getFont(), 10,false);
		}
		if(currentFocus!=null&&currentFocus.isVisible())
			currentFocus.render(g);
				
	}

}
