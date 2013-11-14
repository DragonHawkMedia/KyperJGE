package dragonhawk.kyperj.core.graphics;

import java.awt.Point;

public interface GraphicsComponent {
	
	public void setGraphicsComponent(Object gc);
	
	public void setColor(java.awt.Color color);
	
	public void fillRect(int x, int y , int width, int height);
	
	public void drawLine(Point point1, Point point2);
	
	public void draw(GameImage image, int x, int y);
	
	public void setClearColor(java.awt.Color color);
	
	public void clear();
	
	public void show();

}
