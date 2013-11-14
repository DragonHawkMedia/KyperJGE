package dragonhawk.kyperj.core;

import dragonhawk.kyperj.core.display.DisplaySettings;
import dragonhawk.kyperj.core.display.Java2DGameDisplay;
import dragonhawk.kyperj.core.graphics.GraphicsComponent;

public abstract class KyperJGame implements Runnable{
	
	public static final int JAVA2D = 0;
	public static final int LWJGL = 1;
	
	private GameDisplay gameDisplay;
	
	private boolean running = false;
	private int mode = 0;
	
	//private int UPDATES_PER_SECOND = 30;
	
	private DisplaySettings settings;
	
	public void start(){
		running = true;
		new Thread(this).start();
	}
	
	public void setMode(int mode){
		this.mode = mode;
	}
	
	public void setDisplaySettings(DisplaySettings settings){
		this.settings = settings;
	}
	
	public GameDisplay getGameDisplay(){
		return gameDisplay;
	}
	
	public void run(){
		gameDisplay = new Java2DGameDisplay(this);
		initialize();
		if(settings!=null)
			gameDisplay.setDisplaySettings(settings);
		try {
			checkModeAndSetDisplay();
			gameDisplay.startDisplay();
		} catch (Exception e) {
			e.printStackTrace();
		}
		GraphicsComponent g = gameDisplay.getGraphicsComponent();
		
		while(running){
			
			update(0);
			
			
			g.clear();
			render(g);
			g.show();
			
			
			gameDisplay.updateDisplay();
		}
		
		cleanup();
		
	}
	
	private void cleanup(){
		gameDisplay.destroy();
		System.exit(0);
	}
	
	private void checkModeAndSetDisplay() throws Exception{
		switch(mode){
		case JAVA2D: gameDisplay = new Java2DGameDisplay(this);
					 gameDisplay.setDisplaySettings(settings);
			break;
		case LWJGL: 
			break;
			default: throw new Exception("invalid game mode");
		}
	}
	
	public void stop(){
		System.out.println("stopped?");
		running = false;
	}
	
	public abstract void initialize();
	

	public abstract void render(GraphicsComponent g);
	
	public abstract void update(int delta);
	
	
	
}
