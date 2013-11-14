package dragonhawk.kyperj.core.display;

public class Resolution {
	
	/*pixel width and height of resolution*/
	public int width, height;
	/*the scale of the resolution*/
	public float scale;
	
	/**
	 * create a new resolution with the current width and aspect ratio
	 * @param width desired width
	 * @param ratiow ratio of with  ex. 16:9 or 4:3
	 * @param ratioh ratio of height ex. 16:9 or 4:3
	 */
	public Resolution(int width, int ratiow,int ratioh){
		this(width,ratiow,ratioh,1f);
	}
	
	/**
	 * create a resolution with the desired width and height
	 * @param width the width of resolution
	 * @param height the height of resolution
	 */
	public Resolution(int width, int height){
		this.width = width;
		this.height = height;
		this.scale = 1f;
	}
	
	/**
	 * create a resolution with the desired width and aspect ratio 
	 * and scale it to the desired value
	 * @param width the width of resolution
	 * @param ratiow ratio of width
	 * @param ratioh ratio of height
	 * @param scale how much to scale resolution by
	 */
	public Resolution(int width, int ratiow, int ratioh, float scale){
		this.width = width;
		this.height = (int) (width/ratiow)*ratioh;
		this.scale = scale;
	}

}
