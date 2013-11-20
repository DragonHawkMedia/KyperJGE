package dragonhawk.kyperj.core.graphics;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;

import dragonhawk.kyperj.core.KyperSimpleUtils;
import dragonhawk.kyperj.core.load.GameResource;

public class Java2DGameSheet implements GameSheet, GameResource{
	
	private int tile_square_size = 0;
	private boolean loaded = false;
	private BufferedImage sheet;
	private ArrayList<java.awt.Color> colors;
	private int width;
	private int height;
	private String ref;
	private int id;
	private boolean xjct = false;
	
	private HashMap<Integer,Java2DGameImage> subimages;

	public Java2DGameSheet(String ref,boolean xjct,int id,int size){
		this.colors = new ArrayList<java.awt.Color>();
		this.subimages = new HashMap<Integer ,Java2DGameImage>();
		this.ref = ref;
		this.xjct = xjct;
		this.tile_square_size = size;
		this.id = id;
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
				sheet = KyperSimpleUtils.loadImageFromProject(ref);
			else
				sheet = KyperSimpleUtils.loadExternalImage(ref);
			//remove all colors specified
			{
				if(!colors.isEmpty()){
					for (int i = 0; i < colors.size(); i++) {
						sheet = KyperSimpleUtils.makeColorTransparent(sheet, colors.get(i));
					}
				}
				sheet = KyperSimpleUtils.toCompatibleImage(sheet); 
			}
			
			width = sheet.getWidth();
			height = sheet.getHeight();
			loaded = true;		
	}

	@Override
	public GameImage imageAt(int x, int y) {
		if(!subimages.containsKey(x+(y*(sheet.getWidth()/tile_square_size)))){
			Java2DGameImage sub = new Java2DGameImage(sheet.getSubimage(x*tile_square_size, y*tile_square_size, tile_square_size, tile_square_size),ref, subimages.size());
			subimages.put(x+(y*(sheet.getWidth()/tile_square_size)), sub);
		}	
		return subimages.get(x+(y*(sheet.getWidth()/tile_square_size)));
		 
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
	public GameImage imageAt(int x, int y, int width, int height) {
		return new Java2DGameImage(sheet.getSubimage(x, y, width, height),ref, id);
	}

	@Override
	public void setSize(int size) {
		tile_square_size = size;
		
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
	public void removeColor(Color color) {
		colors.add(color);
	}

	@Override
	public void removeColors(Color colors[]) {
		for (int i = 0; i < colors.length; i++) {
			this.colors.add(colors[i]);
		}
	}

}
