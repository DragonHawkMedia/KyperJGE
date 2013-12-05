package dragonhawk.kyperj.core.graphics.font;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.HashMap;

import dragonhawk.kyperj.core.graphics.GameImage;
import dragonhawk.kyperj.core.graphics.GameSheet;
import dragonhawk.kyperj.core.graphics.Java2DGameImage;
import dragonhawk.kyperj.core.graphics.Java2DGameSheet;

public class SimpleGameFont implements GameFont{

	private boolean loaded = false;
	private HashMap<String , Integer> indexs; 
	private HashMap<String , GameImage[]> premadechars; 
	private HashMap<String , GameImage> premadestrings; 
	private GameSheet sheet;
	private int size;
	private java.awt.Color color;
	
	public SimpleGameFont(String ref,boolean xct,int width,int height){
		this.sheet = new Java2DGameSheet(ref, xct, 0x00ff00, width);
		this.sheet.removeColor(new Color(0xff00ff));
		this.sheet.setDimension(width, height);
		this.indexs = new HashMap<String, Integer>();
		this.premadechars = new HashMap<String , GameImage[]>();
		this.premadestrings = new HashMap<String , GameImage>();
		
		for (int i = 0; i < GameFont.FONT_REF.length(); i++) {
			indexs.put(""+FONT_REF.charAt(i), i);
		}
		
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
	public GameImage[] getStringChars(String s) {
		if(premadechars.containsKey(s)){
			return premadechars.get(s);
			
		}
			
		GameImage[] images = new GameImage[s.length()];
		
		for (int i = 0; i < images.length; i++) {
			images[i] = getChar(""+s.charAt(i));
		}
		premadechars.put(s, images);
		return images;
	}
	
	public GameImage getString(String s){
		if(premadestrings.containsKey(s))
			return premadestrings.get(s);
		premadestrings.put(s, createOneImage(getStringChars(s), s));
		return premadestrings.get(s);
	}

	@Override
	public void setSize(int size) {
		this.size = size;
	}

	@Override
	public GameImage getChar(String c) {
		GameImage image=null;
		int index = indexs.get(c);
		image = sheet.getImage(index);
		return image;
	}

	@Override
	public void setColor(Color color) {
		this.color = color;
	}
	
	private GameImage createOneImage(GameImage[] images,String ref){
		int addedsize = 0;
		for (int i = 0; i < images.length; i++) {
			addedsize+=i;
		}
		BufferedImage image = new BufferedImage(((Java2DGameImage)images[0]).getImage().getWidth()*images.length+addedsize, images[0].getHeight(), ((Java2DGameImage)images[0]).getImage().getType());
		Graphics2D g = (Graphics2D) image.getGraphics();
		for (int i = 0; i < images.length; i++) {
			BufferedImage img = ((Java2DGameImage) images[i]).getImage();
			g.drawImage(img, i*img.getWidth()+i,0,null);
		}
		g.dispose();
		return new Java2DGameImage(image, "ref", (int)Math.random());
	}

}
