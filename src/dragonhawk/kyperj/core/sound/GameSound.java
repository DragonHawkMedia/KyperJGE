package dragonhawk.kyperj.core.sound;

public interface GameSound {
	
	/**
	 * play the current sound
	 */
	public void play();
	
	/**
	 * stop and reset the current sound
	 */
	public void stop();
	
	/**
	 * pause the sound at its current location
	 */
	public void pause();

	/**
	 * reset the current sound to the beginning
	 */
	public void reset();
	
	/**
	 * get the sounds unique id
	 * @return - sound id
	 */
	public int getID();

}
