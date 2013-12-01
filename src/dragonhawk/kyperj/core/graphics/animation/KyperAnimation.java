package dragonhawk.kyperj.core.graphics.animation;

import java.util.ArrayList;

import dragonhawk.kyperj.core.KyperSimpleUtils;
import dragonhawk.kyperj.core.graphics.GameImage;

public class KyperAnimation implements Animation{
	
	private ArrayList<GameImage> frames;
	private AnimationCallback callback;
	private int curr_frame = -1;
	private boolean repeat = false;
	private int duration = 300;
	private long lastChange ;
	private boolean paused = false;
	private boolean animation_ended = false;
	
	public KyperAnimation(){
		frames = new ArrayList<GameImage>();
	}

	@Override
	public void addAnimationCallback(AnimationCallback callback) {
		this.callback = callback;
		
	}

	@Override
	public GameImage[] getFrames() {
		if(!frames.isEmpty()){
			GameImage[] framess  = new GameImage[frames.size()];
			for (int i = 0; i < framess.length; i++) {
				framess[i] = frames.get(i);
			}
			return framess;
		}
		return null;
	}

	@Override
	public int getFrameCount() {
		return frames.size();
	}

	@Override
	public void forceNext() {
		curr_frame++;
		if(curr_frame>=frames.size())
			if(repeat)
				curr_frame = 0;
			else{
				if(callback!=null)
					callback.animationEnd(this);
			}
			
	}

	@Override
	public GameImage getCurrentFrame() {
		GameImage image = null;
			if (curr_frame == -1) {
				curr_frame = 0;
				lastChange = System.nanoTime();
				if(callback!=null)
					callback.animationStart(this);
			}else{
				if(!paused){
					long now = System.nanoTime();
					if(KyperSimpleUtils.milliDiffFromNanos(now, lastChange)>= duration){
						curr_frame++;
						lastChange = now;
					}
					
					if(curr_frame>frames.size()-1){
						if(repeat)
							curr_frame = 0;
						else{
							curr_frame--;
							if(callback!=null&&!animation_ended){
								callback.animationEnd(this);
								animation_ended = true;
							}
						}
					}
				}
				
			}
			image = frames.get(curr_frame);
		return image;	
	}

	@Override
	public void setFrames(GameImage[] frames, int duration) {
		for (int i = 0; i < frames.length; i++) {
			this.frames.add(frames[i]);
		}
		this.duration = duration;
	}

	@Override
	public void setFrames(GameImage[] frames) {
		setFrames(frames, duration);
		
	}

	@Override
	public void setFrameDuration(int duration) {
		this.duration = duration;
	}

	@Override
	public void addFrame(GameImage frame) {
		addFrame(frame, duration);
	}

	@Override
	public void addFrame(GameImage frame, int duration) {
		frames.add(frame);
		this.duration = duration;
	}

	@Override
	public void setRepeat(boolean repeat) {
		this.repeat = repeat;
	}

	@Override
	public void forceEnd() {
		curr_frame = frames.size()-1;
		repeat = false;
		if(callback!=null)
			callback.animationEnd(this);
		
	}

	@Override
	public void pause() {
		paused = true;
		if(callback != null)
			callback.animationPauce(this);
	}

	@Override
	public void resume() {
		paused = false;
		if(callback != null)
			callback.animationPauce(this);
		
	}

	@Override
	public boolean isPaused() {
		return paused;
	}

}
