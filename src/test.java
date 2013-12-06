

import dragonhawk.kyperj.core.KyperJGame;
import dragonhawk.kyperj.core.display.DisplaySettings;
import dragonhawk.kyperj.core.display.Resolution;
import dragonhawk.kyperj.core.state.GameState;


public class test extends KyperJGame{

	
	public void initialize() {
		setGame(this);
		//getGSM().add(new teststate(), GameState.MAIN_MENU_STATE);
		//getGSM().changeState(GameState.MAIN_MENU_STATE);
	}
	
	
	@Override
	public void safeInit() {

	}
	
	public static void main(String args[]){
		                         
		test t = new test();
		t.setMode(JAVA2D);
		DisplaySettings settings = new DisplaySettings(new Resolution(300,16,10,2f));
		settings.setTripleBuffer(false);
		settings.setResize(false);
		//settings.setSync(100);
		settings.setTitle("kyperjdemo");
		t.setDisplaySettings(settings);
		t.setUPS(40);
		t.start();
		
	}


	
	


}
