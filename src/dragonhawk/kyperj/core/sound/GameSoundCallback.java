package dragonhawk.kyperj.core.sound;

public interface GameSoundCallback {
	
	public void started(GameSound sound);
	
	public void ended(GameSound sound);
	
	public void paused(GameSound sound);
	
	public void resumed(GameSound sound);
}
