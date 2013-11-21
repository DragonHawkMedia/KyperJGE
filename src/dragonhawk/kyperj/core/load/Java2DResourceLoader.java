package dragonhawk.kyperj.core.load;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import dragonhawk.kyperj.core.KyperJGame;
import dragonhawk.kyperj.core.graphics.GameImage;
import dragonhawk.kyperj.core.graphics.GameSheet;
import dragonhawk.kyperj.core.graphics.Java2DGameImage;
import dragonhawk.kyperj.core.graphics.Java2DGameSheet;
import dragonhawk.kyperj.core.sound.GameSound;

public class Java2DResourceLoader implements GameResourceLoader{
	
	private List<GameResource> resources;
	
	private int current_load_index = 0;
	
	private boolean done = false;
	
	
	public Java2DResourceLoader(){
		resources = Collections.synchronizedList(new ArrayList<GameResource>());
	}

	@Override
	public GameImage loadGameImage(String file, boolean inproject) {
		GameImage image = new Java2DGameImage(file, resources.size(), inproject);
		resources.add((Java2DGameImage)image);
		KyperJGame.getGallery().addGameImage(image);;
		return image;
	}

	@Override
	public GameSound loadGameSound(String file, boolean inproject) {
		GameSound sound =  null;
		
		return sound;
	}
	
	public GameSheet loadGameSheet(String file, boolean inproject, int segment_size){
		GameSheet sheet = new Java2DGameSheet(file, inproject, resources.size() ,segment_size);
		resources.add((Java2DGameSheet)sheet);
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
						resources.get(current_load_index).load();
						current_load_index++;
						System.out.println("locading");
					}
					done = true;
				}
				
			}
		}).start();
	}

	@Override
	public synchronized List<GameResource> getResources() {
		return resources;
	}

	@Override
	public void setResources(List<GameResource> resources) {
		this.resources = Collections.synchronizedList(resources);
	}

	@Override
	public double getPercentageDone() {
		return current_load_index/resources.size()*100;
	}

	@Override
	public boolean isDoneLoading() {
		return  done;
	}


}
