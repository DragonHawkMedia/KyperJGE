package dragonhawk.kyperj.core;

import java.util.List;

import dragonhawk.kyperj.core.display.DisplaySettings;
import dragonhawk.kyperj.core.display.GameDisplay;
import dragonhawk.kyperj.core.display.Java2DGameDisplay;
import dragonhawk.kyperj.core.graphics.GraphicsComponent;
import dragonhawk.kyperj.core.graphics.GraphicsGallery;
import dragonhawk.kyperj.core.graphics.SimpleGraphicsGallery;
import dragonhawk.kyperj.core.input.GameInput;
import dragonhawk.kyperj.core.input.Java2DGameInput;
import dragonhawk.kyperj.core.load.GameResource;
import dragonhawk.kyperj.core.load.GameResourceLoader;
import dragonhawk.kyperj.core.load.Java2DResourceLoader;
import dragonhawk.kyperj.core.sound.SimpleGameSound;
import dragonhawk.kyperj.core.sound.SoundManager;
import dragonhawk.kyperj.core.state.GameState;
import dragonhawk.kyperj.core.state.GameStateManager;

public abstract class KyperJGame implements Runnable{
	/* the different type of supported environments */
	public static final int JAVA2D = 0;
	public static final int LWJGL = 1;
	/*boolean to check if game has done safe init*/
	private boolean safeinit = false;
	/*The game display that will be created based on the environment we chose*/
	private GameDisplay gameDisplay;
	/*boolean to check if the game is currently running*/
	private boolean running = false;
	/*The "mode" our environment is in currently*/
	private int mode = 0;
	/*the amount of updates per second we want our game to run*/
	private int UPDATES_PER_SECOND = 60;
	/*last time we made an update*/
	private long lastUpdate;
	private int rUPS = 0;
	private int rFPS = 0;
	/*The settings for the display that is going to be made*/
	private DisplaySettings settings;
	/*this will be used to load all our game resources*/
	private static GameResourceLoader loader = new Java2DResourceLoader();
	/*game input handler*/
	private static GameInput input;
	/*our image gallery*/
	private static GraphicsGallery gallery = new SimpleGraphicsGallery();
	/*our sound manager*/
	private static SoundManager soundmanager = new SoundManager();
	
	protected static GameStateManager gsm = new GameStateManager();
	
	public static KyperJGame game;
	
	/**
	 * Set our running boolean to true and then 
	 * begin a new thread that will hold our game loop
	 */
	public void start(){
		running = true;
		new Thread(this).start();
	}
	
	public static void setGame(KyperJGame agame){
		game = agame;
	}
	
	public static KyperJGame getGame(){
		return game;
	}
	
	/**
	 * Set the mode for our game. This will decide what 
	 * environment we use to render out game
	 * @param mode - the mode that will decide what environment we use JAVA2D,LWJGL
	 */
	public void setMode(int mode){
		this.mode = mode;
	}
	
	public static GameResourceLoader getLoader(){
		return loader;
	}
	
	public static GraphicsGallery getGallery(){
		return gallery;
	}
	
	public static SoundManager getSoundManager(){
		return soundmanager;
	}
	
	public static GameInput getInput(){
		return input;
	}
	
	public static GameStateManager getGSM(){
		return gsm;
	}
	
	
	/**
	 * set the Display settings that our game display will use
	 * DEFAULT = 60
	 * @param settings - display settings our game display will use
	 */
	public void setDisplaySettings(DisplaySettings settings){
		this.settings = settings;
	}
	
	/**
	 *	set the amount of updates there will be per second
	 * @param ups updates per second
	 */
	public void setUPS(int ups){
		this.UPDATES_PER_SECOND = ups;
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
		final double tbu = 1000000000L/UPDATES_PER_SECOND;
	    int updates = 0;
	    int fps = 0;
	    long lastcrackupdate = System.nanoTime();
		lastUpdate = System.nanoTime();
		gsm.getCurrentState().start();
		loader.load(gsm.getCurrentState().getStateName());
		while(running){
			if(gsm.getCurrentState().isDoneLoading()&&gsm.getCurrentState().hasSafeInit()){	
				
				//UPDATE THE GAME
				while(System.nanoTime()-lastUpdate>tbu){
					int delta = (int) ((System.nanoTime() - lastUpdate)/1000000L);
					gsm.update(delta);
					lastUpdate+=tbu;
					updates++;
					input.update_input();
				}
				if(System.nanoTime()-lastcrackupdate > 1000000000L){
					rUPS = updates;
					rFPS = fps;
					fps=0;
					updates = 0;
					lastcrackupdate = System.nanoTime();
					System.out.println("updatesPerSecond:"+getUPS()+"  fps:"+rFPS);
				}	
				
				//RENDER THE GAME
				if(loader.isDoneLoading()){
					g.clear();
					gsm.render(g);
					g.show();
					fps++;
				}
					
				//UPDATE THE GAME DISPLAY
				gameDisplay.updateDisplay();
				
			}else if(!gsm.getCurrentState().hasSafeInit()){
				gsm.getCurrentState().SafeInit();
				gsm.getCurrentState().setSafeInit(true);
				if(!safeinit){
					safeInit();
					safeinit = true;
				}
			}	
		}
			
			
		
		//CLEAN UP GAME ASSETS
		cleanup();
		
	}
	
	/**
	 * get the amount of updates occurring per 
	 * second
	 * @return updates per second
	 */
	public int getUPS(){
		return rUPS;
	}
	
	/**
	 * get the amount of frames being drawn per second
	 * @return frames per second
	 */
	public int getFPS(){
		return rFPS;
	}
	
	/**
	 * Clean up all game assets that need to
	 * be cleaned up after our game has stopped
	 */
	private void cleanup(){
		SimpleGameSound.end();
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
					 input = new Java2DGameInput(this);
;			break;
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
		running = false;
	}
	
	/**
	 * initialize game resources and settings here
	 */
	public abstract void initialize();
	
	/**
	 * safely initialize objects with reference that has yet to be loaded or initialized
	 */
	public abstract void safeInit();
	
	
	
	
}
