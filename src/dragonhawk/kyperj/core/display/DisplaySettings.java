package dragonhawk.kyperj.core.display;

import java.awt.Image;


public class DisplaySettings {
	/* the default width and height of our games if no other is set*/
	public static final int DEFAULT_WIDTH = 800;
	
	public static final int DEFAULT_HEIGHT = 600;
	/*the resolution of our game display*/
	public Resolution r;
	/*the title of our game display*/
	private String title;
	/*set to true for fullscreen game*/
	private boolean fullscreen = false;
	/*if we are using tripple buffering*/
	private boolean tri_buffer = false;
	/*set to true for resizeable game display*/
	private boolean resize = false;
	/*set this to something other than -1 to sync 
	 * our display to the desired amount*/
	private int sync = -1;
	/*the icon our display will use*/
	private Image icon;
	/**
	 * create new display settings with the desired resolution
	 * @param res - the resolution to be used
	 */
	public DisplaySettings(Resolution res){
		r = res;
	}
	
	/**
	 * create new display settings with the desired with and height
	 * @param width - desired width
	 * @param height - desired height
	 */
	public DisplaySettings(int width, int height){
		r = new Resolution(width, height);
	}
	
	/**
	 * set the title to be used by the display 
	 * @param title
	 */
	public void setTitle(String title){
		this.title = title;
	}
	
	/**
	 * set whether the display will be full screen or not
	 * @param fullscreen - is display full screen?
	 */
	public void setFullscreen(boolean fullscreen){
		this.fullscreen = fullscreen;
	}
	
	/**
	 * the number of frames you want to sync the display to
	 * @param sync - number of frames to sync display to
	 */
	public void setSync(int sync){
		this.sync = sync;
	}
	
	/**
	 * get the title of the current display
	 * @return - title of current display
	 */
	public String getTitle(){
		return title;
	}
	
	/**
	 * check to see if display is full screen
	 * @return fullscreen
	 */
	public boolean isFullScreen(){
		return fullscreen;
	}
	
	/**
	 * get the current frame sync of display
	 * @return frame sync of display
	 */
	public int getSync(){
		return sync;
	}
	
	/**
	 * get the width of current display in pixels
	 * @return the pixel width of the current resolution
	 */
	public int getWidth(){
		return r.width;
	}
	
	/**
	 * get the height of the current display in pixels
	 * @return the pixel height of the current resolution
	 */
	public int getHeight(){
		return r.height;
	}
	
	/**
	 * get the current scale of the display
	 * @return - scale of current display
	 */
	public float getScale(){
		return r.scale;
	}
	
	/**
	 * set the resolution of the display
	 * @param resolution - resolution of display
	 */
	public void setResolution(Resolution resolution){
		this.r = resolution;
	}
	
	/**
	 * set the display to triple buffer frames
	 * good against graphic glitches
	 * @param tbuf  set triple buffering true or false
	 */
	public void setTripleBuffer(boolean tbuf){
		this.tri_buffer = tbuf;
	}
	
	/**
	 * check to see if triple buffering is being used
	 * @return - tri_buffer true or false
	 */
	public boolean isTripleBuffered(){
		return tri_buffer;
	}
	
	public void setIcon(Image icon){
		this.icon = icon;
	}
	
	public Image getIcon(){
		return icon;
	}
	
	/**
	 * set display to resizeable recommended for debugging purposes
	 * @param resize - set to true for debugging purposes
	 */
	public void setResize(boolean resize){
		this.resize = resize;
	}
	
	/**
	 * is the current display resizeable?
	 * @return true if yes false if no
	 */
	public boolean isResize(){
		return resize;
	}
}
