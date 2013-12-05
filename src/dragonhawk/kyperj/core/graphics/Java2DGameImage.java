package dragonhawk.kyperj.core.graphics;

import java.awt.image.BufferedImage;

import dragonhawk.kyperj.core.KyperSimpleUtils;
import dragonhawk.kyperj.core.load.GameResource;


public class Java2DGameImage implements GameImage, GameResource{
	
	private BufferedImage image;
	private boolean loaded = false;
	private boolean subimage = false;
	private int inner_x = 0;
	private int inner_y = 0;
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
	
	public Java2DGameImage(BufferedImage image,String ref, int id){
		this.image = KyperSimpleUtils.toCompatibleImage(image);
		this.ref = ref;
		this.width = image.getWidth();
		this.height = image.getHeight();
		this.id = id;
		this.xjct = true;
		this.loaded = true;
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
		if(loaded)
			return ;
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

	@Override
	public boolean isSubImage() {
		return subimage;
	}

	@Override
	public int getInnerX() {
		return inner_x;
	}

	@Override
	public int getInnerY() {
		return inner_y;
	}

}
