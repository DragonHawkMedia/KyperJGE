package dragonhawk.kyperj.core;

import dragonhawk.kyperj.core.display.DisplaySettings;
import dragonhawk.kyperj.core.display.GameDisplay;
import dragonhawk.kyperj.core.display.Java2DGameDisplay;
import dragonhawk.kyperj.core.graphics.GraphicsComponent;

public abstract class KyperJGame implements Runnable{
	/* the different type of supported environments */
	public static final int JAVA2D = 0;
	public static final int LWJGL = 1;
	
	/*The game display that will be created based on the environment we chose*/
	private GameDisplay gameDisplay;
	/*boolean to check if the game is currently running*/
	private boolean running = false;
	/*The "mode" our environment is in currently*/
	private int mode = 0;
	/*the amount of updates per second we want our game to run*/
	//private int UPDATES_PER_SECOND = 30;
	/*The settings for the display that is going to be made*/
	private DisplaySettings settings;
	
	/**
	 * Set our running boolean to true and then 
	 * begin a new thread that will hold our game loop
	 */
	public void start(){
		running = true;
		new Thread(this).start();
	}
	
	/**
	 * Set the mode for our game. This will decide what 
	 * environment we use to render out game
	 * @param mode - the mode that will decide what environment we use JAVA2D,LWJGL
	 */
	public void setMode(int mode){
		this.mode = mode;
	}
	
	/**
	 * set the Display settings that our game display will use
	 * @param settings - display settings our game display will use
	 */
	public void setDisplaySettings(DisplaySettings settings){
		this.settings = settings;
	}
	
	/**
	 * Get the current game display
	 * @return - current game display
	 */
	public GameDisplay getGameDisplay(){
		return gameDisplay;
	}
	
	/**
	 * our main game loop is contained in this method
	 */
	public void run(){
		//create a new display with the default mode
		gameDisplay = new Java2DGameDisplay(this);
		//game initializes all things in abstract method
		initialize();
		//give the display the settings we gave it
		//if they are null, use default settings
		if(settings!=null)
			gameDisplay.setDisplaySettings(settings);
		try {
			//check to see if the environment mode was set to something
			//other than the default. If it was then reset the display 
			checkModeAndSetDisplay();
			gameDisplay.startDisplay();
		} catch (Exception e) {
			
			e.printStackTrace();
			System.exit(0);
		}
		//retrieve the graphics component of our current game display
		GraphicsComponent g = gameDisplay.getGraphicsComponent();
		
		while(running){
			
			//UPDATE THE GAME
			update(0);
			
			//RENDER THE GAME
			g.clear();
			render(g);
			g.show();
			
			//UPDATE THE GAME DISPLAY
			gameDisplay.updateDisplay();
		}
		
		//CLEAN UP GAME ASSETS
		cleanup();
		
	}
	
	/**
	 * Clean up all game assets that need to
	 * be cleaned up after our game has stopped
	 */
	private void cleanup(){
		gameDisplay.destroy();
		System.exit(0);
	}
	
	/**
	 * check to see if the environment mode was set to 
	 * something other than the default
	 * @throws Exception - if the mode was set incorrectly throw an exception
	 */
	private void checkModeAndSetDisplay() throws Exception{
		switch(mode){
		case JAVA2D: gameDisplay = new Java2DGameDisplay(this);
					 gameDisplay.setDisplaySettings(settings);
			break;
		case LWJGL: 
			break;
			default: throw new Exception("invalid environment mode set");
		}
	}
	
	/**
	 * set running boolean to false and let the 
	 * game loop end. 
	 */
	public void stop(){
		System.out.println("stopped?");
		running = false;
	}
	
	/**
	 * initialize game resources and settings here
	 */
	public abstract void initialize();
	
	/**
	 * uses a graphics component to help render our game
	 * 
	 * @param g - graphics component that will render our game
	 */
	public abstract void render(GraphicsComponent g);
	
	/**
	 * update our games logic with a delta value
	 * @param delta - value used to have smooth updating
	 */
	public abstract void update(int delta);
	
	
	
}
