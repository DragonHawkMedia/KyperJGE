import java.awt.Color;
import java.awt.Point;
import java.awt.event.KeyEvent;

import dragonhawk.kyperj.core.KyperJGame;
import dragonhawk.kyperj.core.graphics.GameImage;
import dragonhawk.kyperj.core.graphics.GameSheet;
import dragonhawk.kyperj.core.graphics.GraphicsComponent;
import dragonhawk.kyperj.core.graphics.animation.KyperAnimation;
import dragonhawk.kyperj.core.graphics.font.GameFont;
import dragonhawk.kyperj.core.graphics.font.SimpleGameFont;
import dragonhawk.kyperj.core.input.GameInput.InputState;
import dragonhawk.kyperj.core.sound.GameSound;
import dragonhawk.kyperj.core.sound.GameSound.SoundType;
import dragonhawk.kyperj.core.state.GameState;


public class teststate extends GameState{

	GameImage test;
	GameSheet sheet;
	GameFont font;
	KyperAnimation anim,anim2,anim3,anim4;
	GameSound sound1,sound2;
	float x = 200, y = 100;
	private int id = 0;
	
	@Override
	public int getStateID() {
		return id;
	}

	@Override
	public void update(int delta) {
		
		float speed = (delta*(KyperJGame.getGame().getUPS()*2))/1000;
		if(KyperJGame.getInput().getKeyState(KeyEvent.VK_W)==InputState.PRESSED){
			y-= speed;
		}
		if(KyperJGame.getInput().getKeyState(KeyEvent.VK_S)==InputState.PRESSED){
			y+= speed;
		}
		if(KyperJGame.getInput().getKeyState(KeyEvent.VK_A)==InputState.PRESSED){
			x-= speed;
		}
		if(KyperJGame.getInput().getKeyState(KeyEvent.VK_D)==InputState.PRESSED){
			x+= speed;
		}
		
		if(KyperJGame.getInput().getKeyState(KeyEvent.VK_P)==InputState.PRESSED_ONCE){
			System.out.println("animation paued");
			if(anim.isPaused()){
				anim.resume();
			}else{
				anim.pause();
			}
		}
		
		if(KyperJGame.getInput().getKeyState(KeyEvent.VK_SPACE)==InputState.PRESSED_ONCE){
		//	sound2.play(false);
		}
		
		if(sound1.isloaded() && !sound1.isPlaying());
		//	sound1.play(true);
	}

	@Override
	public void render(GraphicsComponent g) {
		g.setColor(java.awt.Color.red);
		g.drawRect(20, 30, 20, 20);
		g.fillRect(0, 0, 10, 10);
		g.setColor(java.awt.Color.blue);
		g.drawLine(new Point(0, 0), new Point(100,100));
		
		
		g.setColor(java.awt.Color.green);
		g.fillRect(30, 30, 20, 20);
		g.draw(test, (int)x, (int)y);
		g.draw(sheet.imageAt(0, 0), (int)x, (int)y);
		g.draw(sheet.imageAt(0, 2), (int)x+16, (int)y);
		g.draw(anim.getCurrentFrame(), (int)(x*.80), 20);
		g.draw(anim2.getCurrentFrame(), (int)(x*.5), 40);
		g.draw(anim3.getCurrentFrame(), (int)(x*.4), 60);
		g.draw(anim4.getCurrentFrame(), (int)(x*.7), 80);
		
		
		g.drawString("FPS:"+KyperJGame.getGame().getFPS(), 0, 20, font,7);
		g.drawString("UPS:"+KyperJGame.getGame().getUPS(), 0, 27, font,7);
		g.setClearColor(new Color(0x97FFFF));
		
	}

	@Override
	public boolean SafeInit() {
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
		
		return true;
	}

	@Override
	public void end() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void load() {
		test = KyperJGame.getLoader().loadGameImage("C:/Users/john/Desktop/pokemansmmo/100.gif", false);
		sheet = KyperJGame.getLoader().loadGameSheet("C:/Users/john/Desktop/KyperJ/resources/senorviro.png", false, 16);
		sheet.removeColor(new Color(0xff00ff));
		
		font = KyperJGame.getLoader().loadGameFont("/simplefont.png", true, 10,16);
		
		sound1 = KyperJGame.getLoader().loadGameSound("C:/Users/john/Desktop/old_desktop/GitHub/JavaGroup/JavaGroup/resource/tab.ogg", false, SoundType.MUSIC);
		sound2 = KyperJGame.getLoader().loadGameSound("C:/Users/john/Desktop/old_desktop/Maescool-Catacomb-Snatch-bd32dfd/res/sound/coin1.wav", false, SoundType.CLIP);
		
	}

}
