package dragonhawk.kyperj.core.graphics;

public interface GameImage {
	
	public int getWidth();
	
	public int getHeight();
	
	public String getRef();
	
	public int getID();
	
	public boolean isSubImage();

	public int getInnerX();
	
	public int getInnerY();
}
