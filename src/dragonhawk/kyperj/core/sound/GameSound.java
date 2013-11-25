package dragonhawk.kyperj.core.sound;

public interface GameSound {
	
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
	 * set the sound amplification 
	 */
    public void setAmp(float amp);
}
