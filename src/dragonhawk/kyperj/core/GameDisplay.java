package dragonhawk.kyperj.core;

import dragonhawk.kyperj.core.display.DisplaySettings;
import dragonhawk.kyperj.core.graphics.GraphicsComponent;

public interface GameDisplay {
	
	public void setIcon(String icon);
	
	public void setDisplaySettings(DisplaySettings settings);
	
	public void startDisplay() throws Exception;
	
	public void updateDisplay();
	
	public void setFullScreen(boolean fullscreen);
	
	public boolean isFullscreen();
	
	public void setSync(int sync);
	
	public DisplaySettings getDisplaySettings();
	
	public GraphicsComponent getGraphicsComponent();
	
	public KyperJGame getGameContainer();
	
	public int getWidth();
	
	public int getHeight();
	
	public void destroy();
}
