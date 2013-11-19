
import java.awt.event.KeyEvent;

import dragonhawk.kyperj.core.KyperJGame;
import dragonhawk.kyperj.core.display.DisplaySettings;
import dragonhawk.kyperj.core.display.Resolution;
import dragonhawk.kyperj.core.graphics.GameImage;
import dragonhawk.kyperj.core.graphics.GraphicsComponent;
import dragonhawk.kyperj.core.input.GameInput;
import dragonhawk.kyperj.core.input.Java2DGameInput;
import dragonhawk.kyperj.core.state.GameStateManager;


public class test extends KyperJGame{

	GameStateManager gsm;
	GameImage test;
	float x = 100, y = 100;
	
	public void initialize() {
		gsm = new GameStateManager();
		test = getLoader().loadGameImage("C:/Users/john/Desktop/pokemansmmo/100.gif", false);
	}

	@Override
	public void render(GraphicsComponent g) {
		g.setColor(java.awt.Color.green);
		g.fillRect(30, 30, 20, 20);
		gsm.render(g);
		g.draw(test, (int)x, (int)y);
	}

	@Override
	public void update(int delta) {
		gsm.update(delta);
		
		System.out.println("XonScreen:"+getInput().getMouseX()+" YonScreen:"+getInput().getMouseY());
		float speed = (delta*(getUPS()*2))/1000;
		if(getInput().isKeyDown(KeyEvent.VK_W)){
			y-= speed;
		}
		if(getInput().isKeyDown(KeyEvent.VK_S)){
			y+= speed;
		}
		if(getInput().isKeyDown(KeyEvent.VK_A)){
			x-= speed;
		}
		if(getInput().isKeyDown(KeyEvent.VK_D)){
			x+= speed;
		}
	}
	
	public static void main(String args[]){
		if(System.getProperty("os.name").startsWith("Win"))
            System.setProperty("sun.java2d.d3d","true");
		else
            System.setProperty("sun.java2d.opengl", "true");
		test t = new test();
		t.setMode(JAVA2D);
		DisplaySettings settings = new DisplaySettings(new Resolution(400,16,9,2f));
		settings.setTripleBuffer(false);
		settings.setResize(false);
		//settings.setSync(80);
		settings.setTitle("jonathanCREW");
		t.setDisplaySettings(settings);
		t.setUPS(40);
		t.start();
		
	}
	
	


}
