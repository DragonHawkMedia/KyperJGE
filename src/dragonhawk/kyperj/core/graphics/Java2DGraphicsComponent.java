package dragonhawk.kyperj.core.graphics;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import dragonhawk.kyperj.core.display.GameDisplay;
import dragonhawk.kyperj.core.display.Java2DGameDisplay;

public class Java2DGraphicsComponent implements GraphicsComponent{
	
	BufferedImage display_image;
	private int pixels[];
	private BufferStrategy strat;
	private Graphics2D graphics;
	private GameDisplay display;
	private Java2DPixRenderer j2dr;
	
	private Image test1;
	
	
	public Java2DGraphicsComponent(GameDisplay display){
		this.display = display;
		int width = display.getDisplaySettings().getWidth();
		int height = display.getDisplaySettings().getHeight();
		this.strat = ((Java2DGameDisplay)display).getStrategy();
	    display_image = toCompatibleImage(new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB));
	    pixels = ((DataBufferInt)display_image.getRaster().getDataBuffer()).getData();
	    j2dr = new Java2DPixRenderer(width, height);
	    
	    try {
			test1 = ImageIO.read(new File("C:/Users/john/Desktop/KyperbeltJGE/logo.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    test1 = toCompatibleImage((BufferedImage) test1);
	    
	}

	@Override
	public void setColor(Color color) {
		
	}

	@Override
	public void fillRect(int x, int y, int width, int height) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drawLine(Point point1, Point point2) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(GameImage image, int x, int y) {
		
	}

	@Override
	public void setClearColor(Color color) {
		// TODO Auto-generated method stub
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
		
		j2dr.render();
		for (int i = 0; i < pixels.length; i++) {
			pixels[i] = j2dr.pixels[i];
		}
		
		graphics = (Graphics2D) strat.getDrawGraphics();
		graphics.setColor(java.awt.Color.black);
		graphics.fillRect(0, 0, display.getWidth(), display.getHeight());
		graphics.drawImage(display_image, 0 , 0, display.getWidth()	, display.getHeight(), null);
	
	}

	@Override
	public void show() {
		
		graphics.dispose();
		strat.show();
		
		j2dr.clear();
		
	}

}
