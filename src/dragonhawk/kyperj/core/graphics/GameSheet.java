package dragonhawk.kyperj.core.graphics;

public interface GameSheet {
	
	/**
	 * get the image at the specified location
	 * based on size given 
	 * @param x - x location
	 * @param y - y location
	 * @return game image at location
	 */
	public GameImage imageAt(int x, int y);
	
	/**
	 * get the game sheet width
	 * @return width
	 */
	public int getWidth();
	
	/**
	 * get the game sheet height
	 * @return height
	 */
	public int getHeight();
	
	/**
	 * get the image at the specified location 
	 * with the specified width and height
	 * @param x x location
	 * @param y y location 
	 * @param width given width
	 * @param height given height
	 * @return image at location
	 */
	public GameImage imageAt(int x, int y, int width, int height);
	
	/**
	 * set the size the images are split as
	 * @param size
	 */
	public void setSize(int size);
	
	public String getRef();
	
	public int getID();
	
	public void removeColor(java.awt.Color color);
	
	public void removeColors(java.awt.Color colors[]);

}
