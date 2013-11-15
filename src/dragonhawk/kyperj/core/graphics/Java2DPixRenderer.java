package dragonhawk.kyperj.core.graphics;

/**
 * Experimental pixel renderer
 *
 */
public class Java2DPixRenderer {
	
	int width , height;
	
	int pixels[];
	
	public Java2DPixRenderer(int width, int height){
		this.width = width;
		this.height = height;
		pixels = new int[width*height];
	}
	
	public void clear(){
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				pixels[x + (y*width)] = 0;
			}
		}
	}
	
	public void render(){
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				pixels[0 + (0*width)] = 0xFF00FF;
			}
		}
	}
	
	

}
