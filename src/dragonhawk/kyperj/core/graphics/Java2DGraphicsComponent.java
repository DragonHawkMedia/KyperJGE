package dragonhawk.kyperj.core.graphics;

import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import dragonhawk.kyperj.core.display.DisplaySettings;
import dragonhawk.kyperj.core.display.GameDisplay;
import dragonhawk.kyperj.core.display.Java2DGameDisplay;
import dragonhawk.kyperj.core.display.Resolution;

public class Java2DGraphicsComponent implements GraphicsComponent{
	
	//BufferedImage display_image;
	//private int pixels[];
	private BufferStrategy strat;
	private Graphics2D graphics;
	private GameDisplay display;
	//private Java2DPixRenderer j2dr;
	private java.awt.Color clear_color;
	
	private Image test1;
	
	
	public Java2DGraphicsComponent(GameDisplay display){
		clear_color = java.awt.Color.black;
		this.display = display;
	//	int width = display.getDisplaySettings().getWidth();
	//	int height = display.getDisplaySettings().getHeight();
		this.strat = ((Java2DGameDisplay)display).getStrategy();
	 //   display_image = toCompatibleImage(new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB));
	 //   pixels = ((DataBufferInt)display_image.getRaster().getDataBuffer()).getData();
	 //   j2dr = new Java2DPixRenderer(width, height);
	    
	    try {
			test1 = ImageIO.read(new File("C:/Users/john/Desktop/KyperbeltJGE/logo.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    test1 = toCompatibleImage((BufferedImage) test1);
	    
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
	}

	@Override
	public void setClearColor(java.awt.Color color) {
		clear_color = color;
	}
	
	
	private BufferedImage toCompatibleImage(BufferedImage image)
	{
		// obtain the current system graphical settings
		GraphicsConfiguration gfx_config = GraphicsEnvironment.
			getLocalGraphicsEnvironment().getDefaultScreenDevice().
			getDefaultConfiguration();

		/*
		 * if image is already compatible and optimized for current system 
		 * settings, simply return it
		 */
		if (image.getColorModel().equals(gfx_config.getColorModel()))
			return image;

		// image is not optimized, so create a new image that is
		BufferedImage new_image = gfx_config.createCompatibleImage(
				image.getWidth(), image.getHeight(), image.getTransparency());

		// get the graphics context of the new image to draw the old image on
		Graphics2D g2d = (Graphics2D) new_image.getGraphics();

		// actually draw the image and dispose of context no longer needed
		g2d.drawImage(image, 0, 0, null);
		g2d.dispose();

		// return the new optimized image
		return new_image; 
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

}
