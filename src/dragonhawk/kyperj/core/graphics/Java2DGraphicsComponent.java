package dragonhawk.kyperj.core.graphics;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferStrategy;

import dragonhawk.kyperj.core.display.DisplaySettings;
import dragonhawk.kyperj.core.display.GameDisplay;
import dragonhawk.kyperj.core.display.Java2DGameDisplay;
import dragonhawk.kyperj.core.graphics.font.GameFont;

public class Java2DGraphicsComponent implements GraphicsComponent{
	
	//BufferedImage display_image;
	//private int pixels[];
	private BufferStrategy strat;
	private Graphics2D graphics;
	private GameDisplay display;
	//private Java2DPixRenderer j2dr;
	private java.awt.Color clear_color;
	
	
	public Java2DGraphicsComponent(GameDisplay display){
		clear_color = java.awt.Color.black;
		this.display = display;
	//	int width = display.getDisplaySettings().getWidth();
	//	int height = display.getDisplaySettings().getHeight();
		this.strat = ((Java2DGameDisplay)display).getStrategy();
	 //   display_image = toCompatibleImage(new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB));
	 //   pixels = ((DataBufferInt)display_image.getRaster().getDataBuffer()).getData();
	 //   j2dr = new Java2DPixRenderer(width, height);
	    
	    
	}

	@Override
	public void setColor(java.awt.Color color) {
		graphics.setColor(color);
	}

	@Override
	public void fillRect(int x, int y, int width, int height) {
		DisplaySettings s = display.getDisplaySettings();
		graphics.fillRect((int)(x*s.getScale()), (int)(y*s.getScale()), 
				 (int)(width*s.getScale()), (int)(height*s.getScale()));
		
	}
	
	public void drawRect(int x, int y, int width, int height){
		DisplaySettings s = display.getDisplaySettings();
		graphics.drawRect((int)(x*s.getScale()),(int) (y*s.getScale()),
				 (int)(width*s.getScale()), (int)(height*s.getScale()));
	}

	@Override
	public void drawLine(Point point1, Point point2) {
		DisplaySettings s = display.getDisplaySettings();
		graphics.drawLine((int)(point1.x*s.getScale()), (int)(point1.y*s.getScale()), 
				 (int)(point2.x*s.getScale()), (int)(point2.y*s.getScale()));
		
	}

	@Override
	public void draw(GameImage image, int x, int y) {
		DisplaySettings s = display.getDisplaySettings();
		graphics.drawImage(((Java2DGameImage)image).getImage(),(int)(x*s.getScale()),(int) (y*s.getScale()),
				 (int)(image.getWidth()*s.getScale()), (int)(image.getHeight()*s.getScale()),null);
	}

	@Override
	public void setClearColor(java.awt.Color color) {
		clear_color = color;
	}

	@Override
	public void clear() {
		if(strat==null)
			try {
				throw new Exception("could not clear graphics component");
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		graphics = (Graphics2D) strat.getDrawGraphics();
		graphics.setColor(clear_color);
		graphics.fillRect(0, 0, display.getWidth(), display.getHeight());
		//graphics.drawImage(test1, 0 , 0, display.getWidth()	, display.getHeight(), null);
	
	}

	@Override
	public void show() {
		
		graphics.dispose();
		strat.show();
		
		
	}

	@Override
	public void drawString(String string, float x, float y, GameFont font) {
		
	}

}
