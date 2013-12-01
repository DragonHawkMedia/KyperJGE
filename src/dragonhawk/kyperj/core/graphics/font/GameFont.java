package dragonhawk.kyperj.core.graphics.font;

import dragonhawk.kyperj.core.graphics.GameImage;

public interface GameFont {
	
	public GameImage[] getString(String s);
	
	public void setSize(int size);
	
	public GameImage getChar(char c);
	
	public void setColor(java.awt.Color color);
}
