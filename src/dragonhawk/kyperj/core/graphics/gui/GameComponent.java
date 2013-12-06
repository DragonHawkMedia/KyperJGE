package dragonhawk.kyperj.core.graphics.gui;

import java.awt.Color;

import dragonhawk.kyperj.core.graphics.GraphicsComponent;

public interface GameComponent {
	
	/**
	 * check to see if this component has a parent component
	 * @return true if it is inside another component
	 */
	public boolean hasParent();
	
	/**
	 * get the parent of this component
	 * @return null if no parent is found
	 */
	public GameComponent getParent();
	
	/**
	 * set the x location of the component
	 * relative to the parent component
	 * @param x
	 */
	public void setX(double x);
	
	/**
	 * set the y location of the component 
	 * relative to the parent component
	 * @param y
	 */
	public void setY(double y);
	
	/**
	 * set the width of the component
	 * @param width
	 */
	public void setWidth(double width);
	
	/**
	 * set the height of the component
	 * 
	 * @param height
	 */
	public void setHeight(double height);
	
	/**
	 * get the width of the component
	 * @return width
	 */
	public double getWidth();
	
	/**
	 * get the height of the component
	 * @return height
	 */
	public double getHeight();
	
	/**
	 * get the x of the component relative to the parent if any
	 * @return x location
	 */
	public int getX();
	
	/**
	 * get the y of the component relative to the parent if any
	 * @return y location
	 */
	public int getY();
	
    /**
     * actively update the component
     */
	public void update();
	
	/**
	 * check to see if the component is dirty 
	 * @return
	 */
	public boolean isDirty();
	
	/**
	 * check to see if the component is 
	 * @return false if out of focus
	 */
	public boolean hasFocus();
	
	/**
	 * make this component gain focus and be placed on top of 
	 * other components
	 */
	public void requestFocus();
	
	/**
	 * restore order within the component and all its children
	 */
	public void restoreOrder();
	
	/**
	 * organize the component in the specified location
	 */
	public void organize();
	
	/**
	 * check if the component is visible(if not then dont render)
	 * @return false if not visible
	 */
	public boolean isVisible();
	
	/**
	 * set the components visibility
	 * @param visible - whether component is visible
	 */
	public void setVisible(boolean visible);
	
	/**
	 * check if this component has children
	 * @return true if component has children
	 */
	public boolean hasChildren();
	
	/**
	 * get all the children of this component 
	 * @return child components
	 */
	public GameComponent[] getChildren();
	
	public void setParent(Object parent);
	
	public void render(GraphicsComponent g);
	
	public GameGui getGui();
	
	public void setBackGroundColor(Color color);

}
