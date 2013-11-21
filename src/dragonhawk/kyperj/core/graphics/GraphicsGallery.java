package dragonhawk.kyperj.core.graphics;

public interface GraphicsGallery {

	public GameImage getGameImageByID(int id);
	
	public GameImage getGameImage(String ref);
	
	public GameSheet getGameSheet(String ref);
	
	public void addGameImage(GameImage image);
	
	public void addGameSheet(GameSheet sheet);
}
