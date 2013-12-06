package dragonhawk.kyperj.core.graphics.gui;

public interface GameButtonCallback {
	
	public void buttonEntered(GameButton button);
	
	public void buttonExited(GameButton button);
	
	public void buttonPressed(GameButton button);
	
	public void buttonReleased(GameButton button);

}
