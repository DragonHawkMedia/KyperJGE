package dragonhawk.kyperj.core.graphics.font;

import java.awt.Color;

import dragonhawk.kyperj.core.graphics.GameImage;
import dragonhawk.kyperj.core.graphics.GameSheet;
import dragonhawk.kyperj.core.graphics.Java2DGameSheet;

public class SimpleGameFont implements GameFont{

	private boolean loaded = false;
	private GameSheet sheet;
	private int size;
	private java.awt.Color color;
	
	public SimpleGameFont(String ref,boolean xct,int width,int height){
		this.sheet = new Java2DGameSheet(ref, xct, 0x00ff00, width);
		this.sheet.removeColor(new Color(0xff00ff));
		this.sheet.setDimension(width, height);
	}
	
	@Override
	public boolean isloaded() {
		return loaded;
	}

	@Override
	public void load() {
		
		sheet.load();
		
		loaded = true;
		
	}

	@Override
	public GameImage[] getString(String s) {
		GameImage[] images = new GameImage[s.length()];
		
		for (int i = 0; i < images.length; i++) {
			images[i] = getChar(""+s.charAt(i));
		}
		
		return images;
	}

	@Override
	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public GameImage getChar(String c) {
		GameImage image=null;
		int index = 0;
		for (int i = 0; i < GameFont.FONT_REF.length(); i++) {
			
			if(c.equals(""+FONT_REF.charAt(i))){
				index = i;
				break;
			}
			
				
		}
		image = sheet.getImage(index);
		
		return image;
	}

	@Override
	public void setColor(Color color) {
		this.color = color;
	}

}
