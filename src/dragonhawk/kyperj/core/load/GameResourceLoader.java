package dragonhawk.kyperj.core.load;

import java.util.List;

import dragonhawk.kyperj.core.graphics.GameImage;
import dragonhawk.kyperj.core.graphics.GameSheet;
import dragonhawk.kyperj.core.sound.GameSound;
import dragonhawk.kyperj.core.sound.GameSound.SoundType;
import dragonhawk.kyperj.core.state.GameState;

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
	public GameSound loadGameSound(String file, boolean inproject, SoundType type);
	
	/**
	 * load a game sheet(tilesheet) with 
	 * @param file
	 * @param inproject
	 * @param segment_size
	 * @return
	 */
	public GameSheet loadGameSheet(String file, boolean inproject, int segment_size);
	
	/**
	 * reload all assets
	 */
	public void reload();
	
	/**
	 * load all assets
	 */
	public void load();
	
	public void load(String state);
	
	/**
	 * if assets are done loading
	 * @return if assets are loading
	 */
	public boolean isDoneLoading();
	
	/**
	 * get all the resources to be loaded
	 * @return an arraylist containing all resources to be loaded
	 */
	public List<GameResource> getResources();
	
	/**
	 * set the resources to be loaded via an arraylist
	 * @param resources
	 */
	public void setResources(List<GameResource> resources);
	
	/**
	 * get the loading percentage 
	 * @return files that have been loaded %
	 */
	public double getPercentageDone(String state);
	
	public void loadBegin(GameState state);
	
	public void loadEnd(GameState state);
	
}
