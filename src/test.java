
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
	GameInput input;
	float x = 100, y = 100;
	
	public void initialize() {
		input = new Java2DGameInput(this);
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
		float speed = (delta*.1f);
		if(input.isKeyDown(KeyEvent.VK_W)){
			y-= speed;
		}
		if(input.isKeyDown(KeyEvent.VK_S)){
			y+= speed;
		}
		if(input.isKeyDown(KeyEvent.VK_A)){
			x-= speed;
		}
		if(input.isKeyDown(KeyEvent.VK_D)){
			x+= speed;
		}
	}
	
	public static void main(String args[]){
		test t = new test();
		t.setMode(JAVA2D);
		DisplaySettings settings = new DisplaySettings(new Resolution(300,4,3,2.5f));
		settings.setTripleBuffer(false);
		settings.setResize(false);
		settings.setSync(80);
		settings.setTitle("jonathanCREW");
		t.setDisplaySettings(settings);
		t.setUPS(30);
		t.start();
		
	}
	
	


}
