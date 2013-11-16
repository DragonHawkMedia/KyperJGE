package dragonhawk.kyperj.core.load;

import java.util.ArrayList;

import dragonhawk.kyperj.core.graphics.GameImage;
import dragonhawk.kyperj.core.sound.GameSound;

public class Java2DResourceLoader implements GameResourceLoader{
	
	private ArrayList<GameResource> resources;
	
	public Java2DResourceLoader(){
		resources = new ArrayList<GameResource>();
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
	}

	@Override
	public boolean isLoading() {
		return false;
	}

	@Override
	public ArrayList<GameResource> getResources() {
		return resources;
	}

	@Override
	public void setResources(ArrayList<GameResource> resources) {
		this.resources = resources;
	}

}
