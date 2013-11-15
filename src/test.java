
import java.awt.Point;

import dragonhawk.kyperj.core.KyperJGame;
import dragonhawk.kyperj.core.display.DisplaySettings;
import dragonhawk.kyperj.core.display.Resolution;
import dragonhawk.kyperj.core.graphics.GraphicsComponent;


public class test extends KyperJGame{

	public void initialize() {
		setMode(JAVA2D);
		DisplaySettings settings = new DisplaySettings(new Resolution(400,4,3,1f));
		settings.setTripleBuffer(false);
		settings.setResize(false);
		settings.setSync(80);
		settings.setTitle("Priscilla has no GAME");
		setDisplaySettings(settings);
		setUPS(45);
		
	}

	@Override
	public void render(GraphicsComponent g) {
		
		g.setColor(java.awt.Color.red);
		g.drawRect(20, 30, 20, 20);
		g.fillRect(0, 0, 10, 10);
		g.setColor(java.awt.Color.blue);
		g.drawLine(new Point(0, 0), new Point(100,100));
	}

	@Override
	public void update(int delta) {
		
	}
	
	public static void main(String args[]){
		test t = new test();
		t.start();
	}
	
	


}
