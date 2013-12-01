package dragonhawk.kyperj.core.state;
import java.awt.event.KeyEvent;

import dragonhawk.kyperj.core.KyperJGame;
import dragonhawk.kyperj.core.graphics.GameSheet;
import dragonhawk.kyperj.core.graphics.GraphicsComponent;
import dragonhawk.kyperj.core.graphics.animation.Animation;
import dragonhawk.kyperj.core.graphics.animation.AnimationCallback;
import dragonhawk.kyperj.core.graphics.animation.KyperAnimation;
import dragonhawk.kyperj.core.input.GameInput;
import dragonhawk.kyperj.core.input.GameInput.InputState;
import dragonhawk.kyperj.core.load.GameResourceLoader;

public class SplashState extends GameState{

	private KyperAnimation splashanim;
	private GameSheet splashsheet;
	private int frames = 20;
	private long anim_end_time;
	private boolean anim_end = false;
	private long start_of_state;
	private boolean anim_started = false;
	
	@Override
	public int getStateID() {
		return 0;
	}

	@Override
	public void load() {
		splashsheet = KyperJGame.getLoader().loadGameSheet("/kyperjsplash.png", true, 0);
		splashsheet.createFadeIn(frames, 1f/frames);
	}

	@Override
	public boolean SafeInit() {
		start_of_state = System.nanoTime();
		splashanim = new KyperAnimation();
		for (int i = 0; i < frames-1; i++) {
			splashanim.addFrame(splashsheet.imageAt(0, i));
		}
		splashanim.setFrameDuration(160);
		splashanim.setRepeat(false);
		splashanim.addAnimationCallback(new AnimationCallback() {
			public void animationStart(Animation anim) {}
			public void animationPauce(Animation anim) {}
			public void animationEnd(Animation anim) {
				System.out.println("animation ended");
				anim_end_time = System.nanoTime();
				KyperJGame.getLoader().load(GameState.MAIN_MENU_STATE);
				anim_end = true;
			}
		});
		return true;
	}

	@Override
	public void update(int delta) {
		if(anim_end){
			if(KyperJGame.getGSM().getGameState(MAIN_MENU_STATE).isDoneLoading()&&System.nanoTime()-anim_end_time>2000*1000000L)
				KyperJGame.getGSM().changeState(MAIN_MENU_STATE);
		}
		
		if(System.nanoTime()-start_of_state > 1000*1000000L){
			anim_started = true;
		}
		
	}

	@Override
	public void render(GraphicsComponent g) {
		if(anim_started){
			int screenwidth = KyperJGame.getGame().getGameDisplay().getDisplaySettings().getWidth();
			int screenheight = KyperJGame.getGame().getGameDisplay().getDisplaySettings().getHeight();
			int x = (screenwidth/2)-(splashanim.getCurrentFrame().getWidth()/2); 
			int y = (screenheight/2)-(splashanim.getCurrentFrame().getHeight()/2);
			g.draw(splashanim.getCurrentFrame(), x , y);
		}
		
	}

	@Override
	public void end() {
		// TODO Auto-generated method stub
		
	}
	
	

}
