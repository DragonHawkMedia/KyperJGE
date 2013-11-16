package dragonhawk.kyperj.core.load;

import java.util.ArrayList;

import dragonhawk.kyperj.core.graphics.GameImage;
import dragonhawk.kyperj.core.sound.GameSound;

public interface GameResourceLoader {
	
	/**
	 * load an image into the game with a different method
	 * depending on the environment chosen
	 * @param file - the name of the file
	 * @param inpath - whether or not the file is inside the project
	 * @return - the GameImage to be used for rendering onto the screen
	 */
	public GameImage loadGameImage(String file, boolean inproject);
	
	/**
	 * load a sound into the game with a different method
	 * depending on the environment chosen
	 * @param file - the name of the file
	 * @param inpath - whether or not the file is inside the project
	 * @return - the GameSound to be used 
	 */
	public GameSound loadGameSound(String file, boolean inproject);
	
	/**
	 * reload all assets
	 */
	public void reload();
	
	/**
	 * load all assets
	 */
	public void load();
	
	/**
	 * if assets are loading
	 * @return if assets are loading
	 */
	public boolean isLoading();
	
	/**
	 * get all the resources to be loaded
	 * @return an arraylist containing all resources to be loaded
	 */
	public ArrayList<GameResource> getResources();
	
	/**
	 * set the resources to be loaded via an arraylist
	 * @param resources
	 */
	public void setResources(ArrayList<GameResource> resources);
	
}
