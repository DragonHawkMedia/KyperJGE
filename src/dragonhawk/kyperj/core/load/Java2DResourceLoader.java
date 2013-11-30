package dragonhawk.kyperj.core.load;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dragonhawk.kyperj.core.KyperJGame;
import dragonhawk.kyperj.core.graphics.GameImage;
import dragonhawk.kyperj.core.graphics.GameSheet;
import dragonhawk.kyperj.core.graphics.Java2DGameImage;
import dragonhawk.kyperj.core.graphics.Java2DGameSheet;
import dragonhawk.kyperj.core.sound.GameSound;
import dragonhawk.kyperj.core.sound.GameSound.SoundType;
import dragonhawk.kyperj.core.sound.SimpleGameSound;
import dragonhawk.kyperj.core.state.GameState;

public class Java2DResourceLoader implements GameResourceLoader{
	
	private Map<String, List<GameResource>> resources;
	
	private int current_load_index = 0;
	
	private String currentload;
	
	
	public Java2DResourceLoader(){
		resources = Collections.synchronizedMap(new HashMap<String, List<GameResource>>());
	}

	@Override
	public GameImage loadGameImage(String file, boolean inproject) {
		GameImage image = new Java2DGameImage(file, resources.get(currentload).size(), inproject);
		resources.get(currentload).add((Java2DGameImage)image);
		KyperJGame.getGallery().addGameImage(image);;
		return image;
	}

	@Override
	public GameSound loadGameSound(String file, boolean inproject,SoundType type) {
		GameSound sound =  new SimpleGameSound(file,  resources.get(currentload).size(), inproject, type);
		resources.get(currentload).add(sound);
		KyperJGame.getSoundManager().add(sound);
		return sound;
	}
	
	public GameSheet loadGameSheet(String file, boolean inproject, int segment_size){
		GameSheet sheet = new Java2DGameSheet(file, inproject,  resources.get(currentload).size() ,segment_size);
		resources.get(currentload).add((Java2DGameSheet)sheet);
		KyperJGame.getGallery().addGameSheet(sheet);
		return sheet;
	}

	@Override
	public void reload() {
	}

	@Override
	public void load() {
		//create a separate thread to load game resources
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				//loop through resource list and load resources individually
				synchronized(resources){
					
					while(current_load_index<resources.size()){
						resources.get(currentload).get(current_load_index).load();
						current_load_index++;
						System.out.println("loading");
					}
					KyperJGame.getGSM().getGameState(currentload).finishLoading();;
				}
				current_load_index = 0;
			}
		}).start();
	}

	@Override
	public synchronized List<GameResource> getResources() {
		return resources.get(currentload);
	}

	@Override
	public void setResources(List<GameResource> resources) {
		this.resources.put(currentload, (ArrayList<GameResource>) Collections.synchronizedList(resources));
	}

	@Override
	public double getPercentageDone() {
		return current_load_index/resources.size()*100;
	}

	@Override
	public synchronized boolean  isDoneLoading() {
		return  KyperJGame.getGSM().getGameState(currentload).isDoneLoading();
	}

	@Override
	public void loadBegin(GameState state) {
		List<GameResource> list = Collections.synchronizedList(new ArrayList<GameResource>());
		resources.put(state.getStateName(),list);
		currentload = state.getStateName();
	}

	@Override
	public void loadEnd(GameState state) {
		
	}

	@Override
	public void load(final String state) {
		currentload = state;
		System.out.println("loading "+state);
		//create a separate thread to load game resources
				new Thread(new Runnable() {
					
					@Override
					public void run() {
						//loop through resource list and load resources individually
						synchronized(resources){
							
							while(current_load_index< resources.get(currentload).size()){
								resources.get(state).get(current_load_index).load();
								current_load_index++;
								System.out.println("loading");
							}
							KyperJGame.getGSM().getGameState(currentload).finishLoading();
						}
						current_load_index = 0;
					}
				}).start();
		
	}


}
