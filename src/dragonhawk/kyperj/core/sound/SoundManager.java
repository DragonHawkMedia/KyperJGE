package dragonhawk.kyperj.core.sound;


import java.util.ArrayList;
import java.util.HashMap;

import dragonhawk.kyperj.core.sound.GameSound.SoundType;

public class SoundManager {
	
	private float master = 1f;
	private float sfx = 1f;
	private float music = 1f;
	private HashMap<String,GameSound> clips;
	private HashMap<String,GameSound> musics;
	private ArrayList<String> playlist;
	private int current_playlist_index = -1;
	private int mode = -1;
	
	public SoundManager(){
		clips = new HashMap<String, GameSound>();
		musics = new HashMap<String, GameSound>();
		playlist = new ArrayList<String>();
	}
	
	public void add(GameSound sound){
		switch (sound.getType()) {
		case CLIP: clips.put(sound.getRef(), sound);
			break;
		case MUSIC: musics.put(sound.getRef(), sound);
			break;
		}
	}
	
	public void addToPlayList(GameSound sound){
			if(sound.getType()==SoundType.MUSIC)
				playlist.add(sound.getRef());
	}
	
	public GameSound getClipByRef(String ref){
		if(clips.containsKey(ref))
			return clips.get(ref);
		else 
			return null;
	}
	
	public GameSound getMusicByRef(String ref){
		if(musics.containsKey(ref))
			return musics.get(ref);
		else
			return null ;
	}
	
	public void startPlayList(){
		
	}
	
	public void stopPlayList(){
		
	}
	
	public void pausePlayList(){
		
	}
	
	public void resumePlayList(){
		
	}
	
	public void nextOnPlaylist(){
		
	}
	
	public void prevOnPlaylist(){
		
	}
	
	public float getMaster(){
		return master;
	}
	
	public float getSFX(){
		return sfx;
	}
	
	public float getMusic(){
		return music;
	}
	
	public void setMaster(float master){
		this.master = master;
		sfxVolumeChanged();
		musicVolumeChanged();
	}
	
	private void musicVolumeChanged() {
		
	}

	private void sfxVolumeChanged() {
		
	}

	public void setSFX(float sfx){
		this.sfx = sfx;
		sfxVolumeChanged();
	}
	
	public void setMusic(float music){
		this.music = music;
		musicVolumeChanged();
	}

}
