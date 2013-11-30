package dragonhawk.kyperj.core.state;

import java.awt.Color;
import java.awt.Point;
import java.awt.event.KeyEvent;

import dragonhawk.kyperj.core.KyperJGame;
import dragonhawk.kyperj.core.graphics.GameImage;
import dragonhawk.kyperj.core.graphics.GameSheet;
import dragonhawk.kyperj.core.graphics.GraphicsComponent;
import dragonhawk.kyperj.core.graphics.animation.KyperAnimation;
import dragonhawk.kyperj.core.input.GameInput;
import dragonhawk.kyperj.core.input.GameInput.InputState;
import dragonhawk.kyperj.core.load.GameResourceLoader;
import dragonhawk.kyperj.core.sound.GameSound;
import dragonhawk.kyperj.core.sound.GameSound.SoundType;

public class SplashState extends GameState{

	@Override
	public int getStateID() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void load() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean SafeInit() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void update(int delta) {
		GameInput in = KyperJGame.getInput();
		GameStateManager gsm = KyperJGame.getGSM();
		GameResourceLoader l = KyperJGame.getLoader();
		
		if(in.getKeyState(KeyEvent.VK_L)==InputState.PRESSED_ONCE){
			l.load("teststate");
		}
		
		if(in.getKeyState(KeyEvent.VK_C)==InputState.PRESSED_ONCE){
			gsm.changeState("teststate");
		}
		
	}

	@Override
	public void render(GraphicsComponent g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void end() {
		// TODO Auto-generated method stub
		
	}
	
	

}
