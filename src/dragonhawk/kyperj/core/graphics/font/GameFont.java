package dragonhawk.kyperj.core.graphics.font;

import dragonhawk.kyperj.core.graphics.GameImage;
import dragonhawk.kyperj.core.load.GameResource;

public interface GameFont extends GameResource{
	
	public static final String FONT_REF = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890,.'\";:!?@#$%^&*()_-+={}[]<>/|\\ ";
	
	public GameImage[] getString(String s);
	
	public void setSize(int size);
	
	public GameImage getChar(String c);
	
	public void setColor(java.awt.Color color);
}
