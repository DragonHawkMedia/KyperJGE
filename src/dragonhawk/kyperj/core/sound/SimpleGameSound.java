package dragonhawk.kyperj.core.sound;

import dragonhawk.kyperj.core.load.GameResource;

public class SimpleGameSound implements GameSound,GameResource{
	
	private String ref;
	private GameSoundCallback callback;
	private int id;
	private boolean loaded = false;
	private boolean paused = false;
	private float amp = 1f;
	private boolean looped = false;

	public SimpleGameSound(String ref, int id, boolean inproject){
		
	}
	
	@Override
	public boolean isloaded() {
		return loaded;
	}

	@Override
	public void load() {
		
		loaded = true;
	}

	@Override
	public void play(boolean loop) {
		this.looped = loop;
	}

	@Override
	public void stop() {
		
	}

	@Override
	public void pause() {
		
	}

	@Override
	public void resume() {
		
	}

	@Override
	public void reset() {
		
		
	}

	@Override
	public void addCallBack(GameSoundCallback callback) {
		this.callback = callback;
	}

	@Override
	public int getID() {
		return id;
	}

	@Override
	public String ref() {
		return ref;
	}

	@Override
	public void setAmp(float amp) {
		// TODO Auto-generated method stub
		
	}

}
