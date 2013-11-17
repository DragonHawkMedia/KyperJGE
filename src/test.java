
import dragonhawk.kyperj.core.KyperJGame;
import dragonhawk.kyperj.core.display.DisplaySettings;
import dragonhawk.kyperj.core.display.Resolution;
import dragonhawk.kyperj.core.graphics.GameImage;
import dragonhawk.kyperj.core.graphics.GraphicsComponent;
import dragonhawk.kyperj.core.state.GameStateManager;


public class test extends KyperJGame{

	GameStateManager gsm;
	GameImage test;
	
	public void initialize() {
		gsm = new GameStateManager();
		test = getLoader().loadGameImage("C:/Users/john/Desktop/pokemansmmo/100.gif", false);
	}

	@Override
	public void render(GraphicsComponent g) {
		g.setColor(java.awt.Color.green);
		g.fillRect(30, 30, 20, 20);
		gsm.render(g);
		g.draw(test, 100, 100);
	}

	@Override
	public void update(int delta) {
		gsm.update(delta);
	}
	
	public static void main(String args[]){
		test t = new test();
		t.setMode(JAVA2D);
		DisplaySettings settings = new DisplaySettings(new Resolution(300,4,3,3f));
		settings.setTripleBuffer(false);
		settings.setResize(false);
		settings.setSync(80);
		settings.setTitle("jonathanCREW");
		t.setDisplaySettings(settings);
		t.setUPS(45);
		t.start();
	}
	
	


}
