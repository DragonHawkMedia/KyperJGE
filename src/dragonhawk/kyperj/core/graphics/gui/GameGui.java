package dragonhawk.kyperj.core.graphics.gui;

import dragonhawk.kyperj.core.KyperJGame;
import dragonhawk.kyperj.core.graphics.GraphicsComponent;
import dragonhawk.kyperj.core.graphics.font.GameFont;
import dragonhawk.kyperj.core.input.GameInput;

public class GameGui {
	
	
	private GameContainer container;
	private GameFont font;
	private GameInput input;
	
	private GameGui(GameInput input){
		this.input = input;
	}
	
	public static GameGui createGameGui(GuiMode mode){
		GameGui gamegui = null;
		
		switch(mode){
		case DEFAULT: gamegui = new GameGui(KyperJGame.getInput());
					  gamegui.setDefaultContainer(new GameContainer());
			break;
		}
		
		return gamegui;
	}
	
	public void render(GraphicsComponent g){
		
	}
	
	public GameFont getFont(){
		return font;
	}
	
	public void setFont(GameFont font){
		this.font = font;
	}
	
	public void add(GameComponent comp){
		
	}
	
	public GameContainer getDefualtContainer(){
		return container;
	}
	
	public void setDefaultContainer(GameContainer container){
		container.setParent(this);
		this.container = container;
	}
	
	public void update(){
		
		
	}
	
	
	public static enum GuiMode{
		DEFAULT;
	}

}
