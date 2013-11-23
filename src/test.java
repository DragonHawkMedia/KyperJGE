
import java.awt.Color;
import java.awt.event.KeyEvent;

import dragonhawk.kyperj.core.KyperJGame;
import dragonhawk.kyperj.core.display.DisplaySettings;
import dragonhawk.kyperj.core.display.Resolution;
import dragonhawk.kyperj.core.graphics.GameImage;
import dragonhawk.kyperj.core.graphics.GameSheet;
import dragonhawk.kyperj.core.graphics.GraphicsComponent;
import dragonhawk.kyperj.core.graphics.animation.KyperAnimation;
import dragonhawk.kyperj.core.input.GameInput.InputState;
import dragonhawk.kyperj.core.state.GameStateManager;


public class test extends KyperJGame{

	GameStateManager gsm;
	GameImage test;
	GameSheet sheet;
	KyperAnimation anim,anim2,anim3,anim4;
	float x = 100, y = 100;
	
	public void initialize() {
		gsm = new GameStateManager();
		test = getLoader().loadGameImage("C:/Users/john/Desktop/pokemansmmo/100.gif", false);
		sheet = getLoader().loadGameSheet("C:/Users/john/Desktop/KyperJ/resources/senorviro.png", false, 16);
		sheet.removeColor(new Color(0xff00ff));
		
	}
	
	
	@Override
	public void safeInit() {
		anim = new KyperAnimation();
		anim.addFrame(sheet.imageAt(0, 3));
		anim.addFrame(sheet.imageAt(1, 3));
		anim.addFrame(sheet.imageAt(2, 3));
		anim.setFrameDuration(400);
		anim.setRepeat(true);
		
		anim2 = new KyperAnimation();
		anim2.addFrame(sheet.imageAt(0, 1));
		anim2.addFrame(sheet.imageAt(1, 1));
		anim2.addFrame(sheet.imageAt(2, 1));
		anim2.setFrameDuration(120);
		anim2.setRepeat(true);
		
		anim3 = new KyperAnimation();
		anim3.addFrame(sheet.imageAt(0, 2));
		anim3.addFrame(sheet.imageAt(1, 2));
		anim3.addFrame(sheet.imageAt(2, 2));
		anim3.setFrameDuration(80);
		anim3.setRepeat(true);
		
		anim4 = new KyperAnimation();
		anim4.addFrame(sheet.imageAt(0, 0));
		anim4.addFrame(sheet.imageAt(1, 0));
		anim4.addFrame(sheet.imageAt(2, 0));
		anim4.setFrameDuration(260);
		anim4.setRepeat(true);
	}

	@Override
	public void render(GraphicsComponent g) {
		g.setColor(java.awt.Color.green);
		g.fillRect(30, 30, 20, 20);
		gsm.render(g);
		g.draw(test, (int)x, (int)y);
		g.draw(sheet.imageAt(0, 0), (int)x, (int)y);
		g.draw(sheet.imageAt(0, 2), (int)x+16, (int)y);
		g.draw(anim.getCurrentFrame(), (int)(x*.80), 20);
		g.draw(anim2.getCurrentFrame(), (int)(x*.5), 40);
		g.draw(anim3.getCurrentFrame(), (int)(x*.4), 60);
		g.draw(anim4.getCurrentFrame(), (int)(x*.7), 80);
		
		
		g.setClearColor(new Color(0x97FFFF));
	}

	@Override
	public void update(int delta) {
		gsm.update(delta);
		
		float speed = (delta*(getUPS()*2))/1000;
		if(getInput().getKeyState(KeyEvent.VK_W)==InputState.PRESSED){
			y-= speed;
		}
		if(getInput().getKeyState(KeyEvent.VK_S)==InputState.PRESSED){
			y+= speed;
		}
		if(getInput().getKeyState(KeyEvent.VK_A)==InputState.PRESSED){
			x-= speed;
		}
		if(getInput().getKeyState(KeyEvent.VK_D)==InputState.PRESSED){
			x+= speed;
		}
		
		if(getInput().getKeyState(KeyEvent.VK_P)==InputState.PRESSED_ONCE){
			System.out.println("animation paued");
			if(anim.isPaused()){
				anim.resume();
			}else{
				anim.pause();
			}
		}	
	}
	
	public static void main(String args[]){
		                         
		test t = new test();
		t.setMode(JAVA2D);
		DisplaySettings settings = new DisplaySettings(new Resolution(300,4,3,3f));
		settings.setTripleBuffer(false);
		settings.setResize(false);
		settings.setSync(60);
		settings.setTitle("jonathanCREW");
		t.setDisplaySettings(settings);
		t.setUPS(40);
		t.start();
		
	}

	
	


}
