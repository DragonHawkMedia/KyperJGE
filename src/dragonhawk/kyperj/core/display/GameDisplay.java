package dragonhawk.kyperj.core.display;

import dragonhawk.kyperj.core.KyperJGame;
import dragonhawk.kyperj.core.graphics.GraphicsComponent;
/**
 * Game display interface 
 * for use with multiple different display 
 * types including but not limited to Java2D and LWJGL
 * 
 * @author Jonathan Camarena
 *
 */
public interface GameDisplay {
	/**
	 * set the icon for this display
	 * @param icon - icon to be used by display
	 */
	public void setIcon(String icon);
	
	/**
	 * set the settings to be used by the display
	 * @param settings - DisplaySettings
	 */
	public void setDisplaySettings(DisplaySettings settings);
	
	/**
	 * start the GameDisplay
	 * @throws Exception
	 */
	public void startDisplay() throws Exception;
	
	/**
	 * update the game display accordingly 
	 */
	public void updateDisplay();
	
	/**
	 * set the display to fullscreen
	 * @param fullscreen
	 */
	public void setFullScreen(boolean fullscreen);
	
	/**
	 * check if its fullscreen
	 * @return
	 */
	public boolean isFullscreen();
	
	/**
	 * set the current sync of the display
	 * @param sync
	 */
	public void setSync(int sync);
	
	/**
	 * get the display settings of this display
	 * @return
	 */
	public DisplaySettings getDisplaySettings();
	
	/**
	 * get the display's graphics component 
	 * @return - appropriate graphics component
	 */
	public GraphicsComponent getGraphicsComponent();
	
	/**
	 * get the current container of this display
	 * @return the game that is using this display
	 */
	public KyperJGame getGameContainer();
	
	/**
	 * get the width of the current display
	 * NOTE: for pixel resolution use DisplaySettings.getWidth()
	 * @return - width of display
	 */
	public int getWidth();
	
	/**
	 * get the height of the current display
	 * NOTE: for pixel resolution use DisplaySettings.getHieght()
	 * @return - height of display
	 */
	public int getHeight();
	
	/**
	 * destroy the current display
	 */
	public void destroy();
}
