

import dragonhawk.kyperj.core.KyperJGame;
import dragonhawk.kyperj.core.display.DisplaySettings;
import dragonhawk.kyperj.core.display.Resolution;


public class test extends KyperJGame{

	
	public void initialize() {
		setGame(this);
	}
	
	
	@Override
	public void safeInit() {

	}
	
	public static void main(String args[]){
		                         
		test t = new test();
		t.setMode(JAVA2D);
		DisplaySettings settings = new DisplaySettings(new Resolution(300,16,9,3f));
		settings.setTripleBuffer(false);
		settings.setResize(false);
		settings.setSync(60);
		settings.setTitle("kyperjdemo");
		t.setDisplaySettings(settings);
		t.setUPS(40);
		t.start();
		
	}


	
	


}
