package dragonhawk.kyperj.core.sound;

import dragonhawk.kyperj.core.load.GameResource;

public interface GameSound extends GameResource{
	
	public boolean isPlaying();
	
	public String getRef();
	
	public SoundType getType();
	
	/**
	 * play the current sound
	 * @param loop - whether sound loops
	 */
	public void play(boolean loop);
	
	/**
	 * stop and reset the current sound
	 */
	public void stop();
	
	/**
	 * pause the sound at its current location
	 */
	public void pause();
	
	/**
	 * resume the sound at its current location
	 */
	public void resume();

	/**
	 * reset the current sound to the beginning
	 */
	public void reset();
	
	/**
	 * add a callback to the sound
	 * */
	public void addCallBack(GameSoundCallback callback);
	
	/**
	 * get the sounds unique id
	 * @return - sound id
	 */
	public int getID();
	
	/**
	 * get the sounds reference
	 * @return reference
	 */
	public String ref();
	
	/**
	 * set the sound volume 
	 */
    public void setGain(float gain);
    
    public boolean isMuted();
    
    public void mute();
    
    public float getGain();
    
    
    public static enum SoundType{
    	MUSIC,
    	CLIP;
    }
}
