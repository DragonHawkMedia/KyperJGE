
import dragonhawk.kyperj.core.KyperJGame;
import dragonhawk.kyperj.core.display.DisplaySettings;
import dragonhawk.kyperj.core.display.Resolution;
import dragonhawk.kyperj.core.graphics.GraphicsComponent;


public class test extends KyperJGame{

	public void initialize() {
		setMode(JAVA2D);
		DisplaySettings settings = new DisplaySettings(new Resolution(50,16,9,20f));
		settings.setTripleBuffer(true);
		settings.setResize(true);
		//settings.setSync(100);
		settings.setTitle("Priscilla has no GAME");
		setDisplaySettings(settings);
		
	}

	@Override
	public void render(GraphicsComponent g) {
		
	}

	@Override
	public void update(int delta) {
		
	}
	
	public static void main(String args[]){
		test t = new test();
		t.start();
	}
	
	


}
