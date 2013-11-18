package dragonhawk.kyperj.core.graphics.animation;

import dragonhawk.kyperj.core.graphics.GameImage;

public interface Animation {
	
	/**
	 * add a call back to do things at certain points of the 
	 * animation process
	 * @param callback the animation callback used
	 */
	public void addAnimationCallback(AnimationCallback callback);
	
	/**
	 * get all the frames in this animation
	 * @return the frames in this animation
	 */
	public GameImage[] getFrames();
	
	/**
	 * get the amount of frames in this animation
	 * @return frame count
	 */
	public int getFrameCount();
	
	/**
	 * forcibly skip to the next frame
	 */
	public void forceNext();
	
	/**
	 * Get the current frame in the animation
	 * @return current animation
	 */
	public GameImage getCurrentFrame();
	
	/**
	 * set all the animation frames
	 * @param frames the frames in the animation
	 * @param duration the interval at which the animations end
	 */
	public void setFrames(GameImage[] frames, int duration);
	
	/**
	 * set all the frames in the animation 
	 * using the default interval time
	 * @param frames frames in the animation
	 */
	public void setFrames(GameImage[] frames);
	
	/**
	 * set the amount of time a frame should remain active
	 * @param duration - frame duration
	 */
	public void setFrameDuration(int duration);
	
	/**
	 * add a frame to the end of the animation chain
	 * @param frame frame to be added
	 */
	public void addFrame(GameImage frame);
	
	/**
	 * add a frame to the end of the animation chain with a specified frame duration
	 * @param frame frame to be added
	 * @param duration frame duration
	 */
	public void addFrame(GameImage frame,int duration);
	
	/**
	 * set whether the animation repeats itself once it ends
	 * @param repeat
	 */
	public void setRepeat(boolean repeat);

}
