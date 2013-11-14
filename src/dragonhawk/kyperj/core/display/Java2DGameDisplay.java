package dragonhawk.kyperj.core.display;


import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.image.BufferStrategy;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import dragonhawk.kyperj.core.KyperJGame;
import dragonhawk.kyperj.core.graphics.GraphicsComponent;
import dragonhawk.kyperj.core.graphics.Java2DGraphicsComponent;

public class Java2DGameDisplay implements GameDisplay {

	/*our displays frame*/
	private JFrame frame;
	/*the canvas our game will be constantly drawn on*/
	private Canvas game_canvas;
	/*the strategy used for buffering our game*/
	private BufferStrategy render_strategy;
	/*the settings for our game*/
	private DisplaySettings Rsettings;
	/*our displays icon*/
	private Image icon;
	/*the game containing this display*/
	private KyperJGame container;
	/*the graphics component for this type of display*/
	private Java2DGraphicsComponent j2dgc;
	/*the last time a frame happened*/
	private long lastFrame;
	/*is the display fullscreen?*/
	private boolean fullscreen = false;

	
	public Java2DGameDisplay(KyperJGame container){
		Rsettings = new DisplaySettings(
				DisplaySettings.DEFAULT_WIDTH,
				DisplaySettings.DEFAULT_HEIGHT);
		this.container = container;
	}
	
	@Override
	public void setIcon(String icon) {
		try {
			this.icon = ImageIO.read(new File(icon));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void setDisplaySettings(DisplaySettings settings) {
		Rsettings = settings;
	}

	@Override
	public void startDisplay() throws Exception{
		frame = new JFrame();
		game_canvas = new Canvas();
		game_canvas.setPreferredSize(new Dimension((int) (Rsettings.getWidth()*Rsettings.getScale()),
				(int) (Rsettings.getHeight()*Rsettings.getScale())));
		game_canvas.setVisible(true);
		frame.setLayout(new GridLayout(1,1));
		frame.add(game_canvas);
		if (Rsettings.getTitle() != null)
			frame.setTitle(Rsettings.getTitle());
		if (icon != null)
			frame.setIconImage(icon);
		frame.setVisible(true);
		
		frame.setResizable(Rsettings.isResize());
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.addWindowListener(new WindowListener() {
			public void windowOpened(WindowEvent arg0) {}
			public void windowIconified(WindowEvent arg0) {}
			public void windowDeiconified(WindowEvent arg0) {}
			public void windowDeactivated(WindowEvent arg0) {}
			public void windowClosing(WindowEvent arg0) {
				getGameContainer().stop();
			}
			public void windowClosed(WindowEvent arg0) {
				getGameContainer().stop();
			}
			public void windowActivated(WindowEvent arg0) {}
		});
		if (Rsettings.isTripleBuffered())
			game_canvas.createBufferStrategy(3);
		else
			game_canvas.createBufferStrategy(2);
		
		frame.pack();
		frame.setLocationRelativeTo(null);
		
		render_strategy = game_canvas.getBufferStrategy();
		
		j2dgc = new Java2DGraphicsComponent(this);
		lastFrame = System.nanoTime();
	}

	@Override
	public void updateDisplay() {
		sync(Rsettings.getSync());
	}
	
	/**
	 * sync the display to the desired digit
	 * @param sync
	 */
	public void sync(int sync) {
	      if (sync!=-1) {
	         long diff = 1000000000L / sync + lastFrame;
	         long now = System.nanoTime();
	         
	         try {
	            while (diff > now) {
	               Thread.sleep((diff-now) / 2000000L);
	               now = System.nanoTime();
	            }
	         } catch (Exception e) {}

	         lastFrame = now;
	      } 
	 }

	@Override
	public void setFullScreen(boolean fullscreen) {
		this.fullscreen = fullscreen;
	}

	@Override
	public boolean isFullscreen() {
		return fullscreen;
	}

	@Override
	public void setSync(int sync) {
		Rsettings.setSync(sync);
	}

	@Override
	public GraphicsComponent getGraphicsComponent() {
		return j2dgc;
	}

	@Override
	public KyperJGame getGameContainer() {
		return container;
	}

	@Override
	public void destroy() {
		render_strategy.dispose();
		frame.dispose();
	}
	
	public BufferStrategy getStrategy(){
		return render_strategy;
	}

	@Override
	public int getWidth() {
		return frame.getWidth();
	}

	@Override
	public int getHeight() {
		return frame.getHeight();
	}

	@Override
	public DisplaySettings getDisplaySettings() {
		return Rsettings;
	}


}
