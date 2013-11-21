package dragonhawk.kyperj.core.graphics;

import java.util.HashMap;


public class SimpleGraphicsGallery implements GraphicsGallery{

	private HashMap<String, GameSheet> sheets;
	private HashMap<String, GameImage> images;
	
	public SimpleGraphicsGallery(){
		this.sheets = new HashMap<String , GameSheet>();
		this.images = new HashMap<String , GameImage>();
	}
	
	@Override
	public GameImage getGameImageByID(int id) {
		return null;
	}

	@Override
	public GameImage getGameImage(String ref) {
		if(images.containsKey(ref)){
			return images.get(ref);
		}
		return null;
	}

	@Override
	public GameSheet getGameSheet(String ref) {
		if(sheets.containsKey(ref))
			return sheets.get(ref);
		return null;
	}

	@Override
	public void addGameImage(GameImage image) {
		if(images.containsKey(image.getRef()))
			return;
		images.put(image.getRef(), image);
	}

	@Override
	public void addGameSheet(GameSheet sheet) {
		if(sheets.containsKey(sheet.getRef()))
			return;
		sheets.put(sheet.getRef(), sheet);
	}


}
