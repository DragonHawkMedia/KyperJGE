package dragonhawk.kyperj.core.sound;

import java.io.File;

import kuusisto.tinysound.Music;
import kuusisto.tinysound.Sound;
import kuusisto.tinysound.TinySound;
import dragonhawk.kyperj.core.load.GameResource;

public class SimpleGameSound implements GameSound{
	
	private String ref;
	private GameSoundCallback callback;
	private int id;
	private boolean muted = false;
	private boolean loaded = false;
	private boolean inproject = false;
	private boolean paused = false;
	private float gain = 1f;
	private boolean looped = false;
	private SoundType type;
	private Sound clip;
	private Music music;

	public SimpleGameSound(String ref, int id, boolean inproject,SoundType type){
		SimpleGameSound.begin();
		this.ref = ref;
		this.id = id;
		this.inproject = inproject;
		this.type = type;
		callback = new GameSoundCallback() {
			public void unmuted(GameSound sound) {}
			public void started(GameSound sound) {}
			public void resumed(GameSound sound) {}
			public void paused(GameSound sound) {}
			public void muted(GameSound sound) {}
			public void ended(GameSound sound) {}
		};
	}
	
	@Override
	public boolean isloaded() {
		return loaded;
	}

	@Override
	public void load() {
		
		switch (type) {
		case CLIP: if(inproject)
					   clip = TinySound.loadSound(this.getClass().getResource(ref));
				   else
					   clip = TinySound.loadSound(new File(ref));
			break;
		case MUSIC:if(inproject)
			   			music = TinySound.loadMusic(this.getClass().getResource(ref));
					else
						music = TinySound.loadMusic(new File(ref));
			break;

		}
		
		loaded = true;
	}

	@Override
	public void play(boolean loop) {
		this.looped = loop;
		if(loaded){
			switch (type) {
			case CLIP: clip.play(); 
					   callback.started(this);
				break;
			case MUSIC: music.play(looped);
						callback.started(this);
				break;
			}
		}
	}

	@Override
	public void stop() {
		if(loaded){
			switch (type) {
			case CLIP: clip.stop(); 
					   callback.ended(this);
				break;
			case MUSIC: music.stop();
						callback.ended(this);
				break;
			}
		}
	}

	@Override
	public void pause() {
		paused = true;
		if(loaded){
			switch (type) {
			case CLIP: clip.stop(); 
				break;
			case MUSIC: music.pause();
						callback.paused(this);
				break;
			}
		}
	}

	@Override
	public void resume() {
		paused = false;
		if(loaded){
			switch (type) {
			case CLIP: clip.play();
				break;
			case MUSIC: music.resume();
						callback.resumed(this);
				break;
			}
		}
	}

	@Override
	public void reset() {
		if(loaded){
			switch (type) {
			case CLIP: 
				break;
			case MUSIC: music.rewind();
				break;
			}
		}
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
	public void setGain(float gain) {
		this.gain = gain;
		if(loaded){
			switch (type) {
			case CLIP: 
				break;
			case MUSIC: music.setVolume(gain);
				break;
			}
		}
	}
	@Override
	public boolean isMuted() {
		return muted;
	}

	@Override
	public void mute() {
		if(muted){
			muted = false;
			if(callback!=null)
				callback.unmuted(this);
		}else{
			muted = true;
			if(callback!=null)
				callback.muted(this);
		}
			
			
		
	}

	@Override
	public float getGain() {
		return gain;
	}
	
	public static void begin(){
		if(!TinySound.isInitialized())
			TinySound.init();
	}
	
	public static void end(){
		if(TinySound.isInitialized())
			TinySound.shutdown();
	}

	@Override
	public SoundType getType() {
		return type;
	}

	@Override
	public String getRef() {
		return ref;
	}

	@Override
	public boolean isPlaying() {
		boolean playing = false;
		if(loaded){
			switch (type) {
			case CLIP: playing = false;
				break;
			case MUSIC: playing = music.playing();
				break;
			}
		}
		
		return playing;
	}

}
