package dragonhawk.kyperj.core.display;

public class Resolution {
	
	public int width, height;
	public float scale;
	
	public Resolution(int width, int ratiow,int ratioh){
		this(width,ratiow,ratioh,1f);
	}
	
	public Resolution(int width, int height){
		this.width = width;
		this.height = height;
		this.scale = 1f;
	}
	
	public Resolution(int width, int ratiow, int ratioh, float scale){
		this.width = width;
		this.height = (int) (width/ratiow)*ratioh;
		this.scale = scale;
	}

}
