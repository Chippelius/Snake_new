package snake.ui.states;

import java.awt.Graphics2D;
import snake.Game;

public class GameStatePaused extends State {

//	private ImageTile backgroundImage;
//	
//	private Button quit, save, yes, no, options, load;
//	private ImageTile buttonBox;
	
	public GameStatePaused(Game game) {
		super(game);
	}

	@Override
	public void render(Graphics2D g) {
		// TODO Auto-generated method stub
		
	}
	
//	@Override
//	public void onSet() {
//		Logger.getDefaultLogger().logInfo("Pausing game");
//		//TODO: change, now that pause doesen't exist anymore
//		//game.pause();
//		BufferedImage img = ImageLoader.applyGaussian(display.getNextRenderedImage(), 25);
//		display.setNextRenderingImage(img);
//
//		// CREATE TILES
//		// TODO: Paste in right values!
//		backgroundImage = new ImageTile(img, 1, 1, 1, 1);
//		quit = new Button(null, 0, 0, 0, 0);
//		save = new Button(null, 0, 0, 0, 0);
//		yes = new Button(null, 0, 0, 0, 0);
//		no = new Button(null, 0, 0, 0, 0);
//		options = new Button(null, 0, 0, 0, 0);
//		load = new Button(null, 0, 0, 0, 0);
//		buttonBox = new ImageTile(null, 0, 0, 0, 0);
//		// END CREATE TILES
//		
//		// ADD TILES
//		display.addDisplayElement(backgroundImage);
//		display.addDisplayElement(quit);
//		display.addDisplayElement(save);
//		display.addDisplayElement(yes);
//		display.addDisplayElement(no);
//		display.addDisplayElement(options);
//		display.addDisplayElement(load);
//		display.addDisplayElement(buttonBox);
//		// END ADD TILES
//	}

}
