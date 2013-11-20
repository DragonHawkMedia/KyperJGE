package dragonhawk.kyperj.core.graphics.animation;

public interface AnimationCallback {
	
	/**
	 * when the animation ends do this
	 */
	public void animationEnd(Animation anim);
	
	/**
	 * do this if animation is stopped half way
	 */
	public void animationPauce(Animation anim);
	
	/**
	 * do this when animation starts
	 */
	public void animationStart(Animation anim);

}
