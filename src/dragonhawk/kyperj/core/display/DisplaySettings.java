package dragonhawk.kyperj.core.display;


public class DisplaySettings {
	
	public static final int DEFAULT_WIDTH = 800;
	
	public static final int DEFAULT_HEIGHT = 600;
	
	public Resolution r;
	
	private String title;
	
	private boolean fullscreen;
	
	private boolean tri_buffer = false;
	
	private boolean resize = false;
	
	private int sync = -1;
	
	public DisplaySettings(Resolution res){
		r = res;
	}
	
	public DisplaySettings(int width, int height){
		r = new Resolution(width, height);
	}
	
	public void setTitle(String title){
		this.title = title;
	}
	
	public void setFullscreen(boolean fullscreen){
		this.fullscreen = fullscreen;
	}
	
	public void setSync(int sync){
		this.sync = sync;
	}
	
	public String getTitle(){
		return title;
	}
	
	public boolean isFullScreen(){
		return fullscreen;
	}
	
	public int getSync(){
		return sync;
	}
	
	public int getWidth(){
		return r.width;
	}
	
	public int getHeight(){
		return r.height;
	}
	
	public float getScale(){
		return r.scale;
	}
	
	public void setResolution(Resolution resolution){
		this.r = resolution;
	}
	
	public void setTripleBuffer(boolean tbuf){
		this.tri_buffer = tbuf;
	}
	
	public boolean isTripleBuffered(){
		return tri_buffer;
	}
	
	public void setResize(boolean resize){
		this.resize = resize;
	}
	
	public boolean isResize(){
		return resize;
	}
}
