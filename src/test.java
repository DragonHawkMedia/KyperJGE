
import dragonhawk.kyperj.core.KyperJGame;
import dragonhawk.kyperj.core.display.DisplaySettings;
import dragonhawk.kyperj.core.display.Resolution;
import dragonhawk.kyperj.core.graphics.GraphicsComponent;


public class test extends KyperJGame{

	public void initialize() {
		setMode(JAVA2D);
		DisplaySettings settings = new DisplaySettings(new Resolution(1024,4,3,.5f));
		settings.setTripleBuffer(false);
		settings.setResize(false);
		settings.setSync(80);
		settings.setTitle("Priscilla has no GAME");
		setDisplaySettings(settings);
		
	}

	@Override
	public void render(GraphicsComponent g) {
		
		g.setColor(java.awt.Color.pink);
		g.fillRect(0, 0, 20, 20);
	}

	@Override
	public void update(int delta) {
		
	}
	
	public static void main(String args[]){
		test t = new test();
		t.start();
	}
	
	


}
