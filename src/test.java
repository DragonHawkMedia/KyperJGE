
import java.awt.Color;
import java.awt.event.KeyEvent;

import dragonhawk.kyperj.core.KyperJGame;
import dragonhawk.kyperj.core.display.DisplaySettings;
import dragonhawk.kyperj.core.display.Resolution;
import dragonhawk.kyperj.core.graphics.GameImage;
import dragonhawk.kyperj.core.graphics.GameSheet;
import dragonhawk.kyperj.core.graphics.GraphicsComponent;
import dragonhawk.kyperj.core.graphics.animation.KyperAnimation;
import dragonhawk.kyperj.core.state.GameStateManager;


public class test extends KyperJGame{

	GameStateManager gsm;
	GameImage test;
	GameSheet sheet;
	KyperAnimation anim;
	float x = 100, y = 100;
	
	public void initialize() {
		gsm = new GameStateManager();
		test = getLoader().loadGameImage("C:/Users/john/Desktop/pokemansmmo/100.gif", false);
		sheet = getLoader().loadGameSheet("C:/Users/john/Desktop/KyperJ/resources/senorviro.png", false, 16);
		sheet.removeColor(new Color(0xff00ff));
		
		
	}

	@Override
	public void render(GraphicsComponent g) {
		g.setColor(java.awt.Color.green);
		g.fillRect(30, 30, 20, 20);
		gsm.render(g);
		g.draw(test, (int)x, (int)y);
		g.draw(sheet.imageAt(0, 0), (int)x, (int)y);
		g.draw(sheet.imageAt(0, 2), (int)x+16, (int)y);
		if(anim == null){
			anim = new KyperAnimation();
			anim.addFrame(sheet.imageAt(0, 3));
			anim.addFrame(sheet.imageAt(1, 3));
			anim.addFrame(sheet.imageAt(2, 3));
			anim.setFrameDuration(140);
			anim.setRepeat(true);
		}
		
		g.draw(anim.getCurrentFrame(), (int)x, 20);
		
		
		g.setClearColor(new Color(0x97FFFF));
	}

	@Override
	public void update(int delta) {
		gsm.update(delta);
		
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
		DisplaySettings settings = new DisplaySettings(new Resolution(300,16,9,3f));
		settings.setTripleBuffer(false);
		settings.setResize(false);
		//settings.setSync(60);
		settings.setTitle("jonathanCREW");
		t.setDisplaySettings(settings);
		t.setUPS(40);
		t.start();
		
	}
	
	


}
