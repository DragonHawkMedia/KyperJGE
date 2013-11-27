package dragonhawk.kyperj.core.graphics.font;

import dragonhawk.kyperj.core.graphics.GameImage;
import dragonhawk.kyperj.core.graphics.GameSheet;

public class Font {
	
	private GameSheet sheet;
	private int size;
	private String fontIndex;
	
	
	public Font(GameSheet sheet, int size, String font_index){
		this.sheet = sheet;
		this.size = size;
		this.fontIndex = font_index;
	}

	public GameImage getFontChar(char fc){
		int index = 0;
		int x = 0;
		int y = 0;
		for (int i = 0; i < fontIndex.length(); i++) {
			
		}
		
		return sheet.imageAt(x, y);
	}
}
