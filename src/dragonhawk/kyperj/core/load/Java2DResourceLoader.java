package dragonhawk.kyperj.core.load;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import dragonhawk.kyperj.core.graphics.GameImage;
import dragonhawk.kyperj.core.sound.GameSound;

public class Java2DResourceLoader implements GameResourceLoader{
	
	private List<GameResource> resources;
	
	private int current_load_index = 0;
	
	private boolean loading = false;
	
	public Java2DResourceLoader(){
		resources = Collections.synchronizedList(new ArrayList<GameResource>());
	}

	@Override
	public GameImage loadGameImage(String file, boolean inproject) {
		GameImage image = null;
		
		return image;
	}

	@Override
	public GameSound loadGameSound(String file, boolean inproject) {
		GameSound sound = null;
		
		return sound;
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
				//loop through resource list and load resoruces individually
				
			}
		}).start();
	}

	@Override
	public boolean isLoading() {
		return loading;
	}

	@Override
	public synchronized List<GameResource> getResources() {
		return resources;
	}

	@Override
	public void setResources(ArrayList<GameResource> resources) {
		this.resources = resources;
	}

}