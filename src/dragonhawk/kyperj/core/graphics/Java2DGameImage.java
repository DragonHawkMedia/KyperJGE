package dragonhawk.kyperj.core.graphics;

import java.awt.image.BufferedImage;

import dragonhawk.kyperj.core.KyperSimpleUtils;
import dragonhawk.kyperj.core.load.GameResource;


public class Java2DGameImage implements GameImage, GameResource{
	
	private BufferedImage image;
	private boolean loaded = false;
	private String ref = "";
	private int id = 0;
	private int width , height;
	private boolean xjct = false;
	
	public Java2DGameImage(String ref, int id,boolean xjct){
		image = null;
		this.ref = ref;
		this.id = id;
		this.xjct = xjct;
	}
	
	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public String getRef() {
		return ref;
	}

	@Override
	public int getID() {
		return id;
	}

	@Override
	public boolean isloaded() {
		return loaded;
	}

	@Override
	public void load() {
		if(xjct)
			image = KyperSimpleUtils.loadImageFromProject(ref);
		else
			image = KyperSimpleUtils.loadExternalImage(ref);
		
		width = image.getWidth();
		height = image.getHeight();
		loaded = true;		
	}
	
	public BufferedImage getImage(){
		return image;
	}

}
