package dragonhawk.kyperj.core;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.FilteredImageSource;
import java.awt.image.ImageFilter;
import java.awt.image.ImageProducer;
import java.awt.image.RGBImageFilter;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class KyperSimpleUtils {
	
	public static BufferedImage loadImageFromProject(String ref){
		BufferedImage image = null;
		try {
			image =  ImageIO.read(KyperSimpleUtils.class.getResource(ref));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return image;
	}
	
	public static BufferedImage loadExternalImage(String ref){
		BufferedImage image = null;
		try {
			image =  ImageIO.read(new File(ref));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return image;
	}
	
	public static BufferedImage toCompatibleImage(BufferedImage image)
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
	
	/**
	 * Make a certain pixel transparent
	 * @param im
	 * @param color
	 * @return
	 */
    public static BufferedImage makeColorTransparent(BufferedImage im, final Color color) {
    	ImageFilter filter = new RGBImageFilter() {

    		// the color we are looking for... Alpha bits are set to opaque
    		public int markerRGB = color.getRGB() | 0xFF000000;

    		public final int filterRGB(int x, int y, int rgb) {
    			if ((rgb | 0xFF000000) == markerRGB) {
    				// Mark the alpha bits as zero - transparent
    				return 0x00FFFFFF & rgb;
    			} else {
    				// nothing to do
    				return rgb;
    			}
    		}
    	};
    	
    	ImageProducer ip = new FilteredImageSource(im.getSource(), filter);
    	Image image = Toolkit.getDefaultToolkit().createImage(ip);
    	BufferedImage bufim = new BufferedImage(image.getWidth(null), image.getHeight(null), BufferedImage.TYPE_4BYTE_ABGR);
    	Graphics2D g = (Graphics2D) bufim.getGraphics();
    	g.drawImage(image, 0, 0,null);
    	g.dispose();
    	return bufim;
    }
    
    public static BufferedImage createCompatibleBlendedSheet(BufferedImage image,int frames,float fi){
    	BufferedImage newimage = new BufferedImage(image.getWidth(), image.getHeight()*frames, BufferedImage.TYPE_4BYTE_ABGR);
    	Graphics2D g2 = (Graphics2D) newimage.getGraphics();
    	float alpha = 0.0f;
    	for (int i = 0; i < frames; i++) {
    		g2.setComposite(AlphaComposite.getInstance(
    	            AlphaComposite.SRC_OVER, alpha));
    	    g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
    	    g2.drawImage(image, 0, i*image.getHeight(), null);
    	    
    	    alpha += fi;
    	    if (alpha >= 1.0f) 
    	        alpha = 1.0f;
		}
    	g2.dispose();
    	
    	newimage = toCompatibleImage(newimage);
    	
    	return newimage;
    }
    
    public static int milliDiffFromNanos(long now ,long last){
    	return (int) ((now-last)/1000000L);
    }

	/**
	 * get the closest power of 2
	 * 
	 * @param x
	 * @return
	 */
	public static int getPowerOfTwo(int x){
		int ret = 2;
        while (ret < x) {
            ret *= 2;
        }
        return ret;
	}
}
