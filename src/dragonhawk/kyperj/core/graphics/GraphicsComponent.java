package dragonhawk.kyperj.core.graphics;

import java.awt.Point;

import dragonhawk.kyperj.core.graphics.font.GameFont;

public interface GraphicsComponent {
	/**
	 * set the color to use next
	 * @param color color to use next
	 */
	public void setColor(java.awt.Color color);
	
	/**
	 * fill a rectangle with the specified dimensions and location
	 * @param x x location of rectangle top left corner
	 * @param y y location of rectangle top left corner
	 * @param width width of rectangle
	 * @param height height of the rectangle
	 */
	public void fillRect(int x, int y , int width, int height);
	
	/**
	 * draw a rectangle width the specified dimensions and location
	 * @param x x location of rectangle top left 
	 * @param y y location of rectangle top left
	 * @param width width of rectangle 
	 * @param height height of rectangle
	 */
	public void drawRect(int x, int y, int width, int height);
	
	/**
	 * draw a line between two points
	 * @param point1 starting point
	 * @param point2 ending point
	 */
	public void drawLine(Point point1, Point point2);
	
	/**
	 * render the specified game image at the 
	 * given location
	 * @param image game image
	 * @param x x location of top left corner
	 * @param y y location of top left corner
	 */
	public void draw(GameImage image, int x, int y);
	
	/**
	 * set the color the screen clears to after 
	 * each render cycle
	 * @param color the color the screen clears to
	 */
	public void setClearColor(java.awt.Color color);
	
	/**
	 * clear the graphics component and have it ready 
	 * for another render cycle
	 */
	public void clear();
	
	/**
	 * show the graphics component and put it on the display
	 */
	public void show();
	
	public void drawString(String string,float x, float y, GameFont font,int size);

}
