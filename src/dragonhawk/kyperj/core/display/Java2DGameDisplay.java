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

import dragonhawk.kyperj.core.GameDisplay;
import dragonhawk.kyperj.core.KyperJGame;
import dragonhawk.kyperj.core.graphics.GraphicsComponent;
import dragonhawk.kyperj.core.graphics.Java2DGraphicsComponent;

public class Java2DGameDisplay implements GameDisplay {

	private JFrame frame;
	private Canvas game_canvas;
	private BufferStrategy render_strategy;
	private DisplaySettings Rsettings;
	private Image icon;
	private KyperJGame container;
	private Java2DGraphicsComponent j2dgc;
	private long lastFrame;


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
	
	public void sync(int sync) {
	      if (sync!=-1) {
	         long gapTo = 1000000000L / sync + lastFrame;
	         long timeNow = System.nanoTime();
	         
	         try {
	            while (gapTo > timeNow) {
	               Thread.sleep((gapTo-timeNow) / 2000000L);
	               timeNow = System.nanoTime();
	            }
	         } catch (Exception e) {}

	         lastFrame = timeNow;
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
