
import java.awt.Point;

import dragonhawk.kyperj.core.KyperJGame;
import dragonhawk.kyperj.core.display.DisplaySettings;
import dragonhawk.kyperj.core.display.Resolution;
import dragonhawk.kyperj.core.graphics.GraphicsComponent;
import dragonhawk.kyperj.core.state.GameStateManager;


public class test extends KyperJGame{

	GameStateManager gsm;
	
	public void initialize() {
		gsm = new GameStateManager();
		setMode(JAVA2D);
		DisplaySettings settings = new DisplaySettings(new Resolution(300,4,3,2f));
		settings.setTripleBuffer(false);
		settings.setResize(false);
		settings.setSync(80);
		settings.setTitle("Priscilla has no GAME");
		setDisplaySettings(settings);
		setUPS(45);
		
	}

	@Override
	public void render(GraphicsComponent g) {
		
		gsm.render(g);
	}

	@Override
	public void update(int delta) {
		gsm.update(delta);
	}
	
	public static void main(String args[]){
		test t = new test();
		t.start();
	}
	
	


}
