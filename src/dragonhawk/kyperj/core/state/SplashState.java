package dragonhawk.kyperj.core.state;

import java.awt.Point;

import dragonhawk.kyperj.core.graphics.GraphicsComponent;

public class SplashState implements GameState{

	@Override
	public int getStateID() {
		return 0;
	}

	@Override
	public void update(int delta) {
		
	}

	@Override
	public void render(GraphicsComponent g) {
		g.setColor(java.awt.Color.red);
		g.drawRect(20, 30, 20, 20);
		g.fillRect(0, 0, 10, 10);
		g.setColor(java.awt.Color.blue);
		g.drawLine(new Point(0, 0), new Point(100,100));
		
	}

}
