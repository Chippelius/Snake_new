/**
 * 
 */
package snake.ui;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 * @author leo
 */
public class Button extends Sprite {
	
	protected volatile int x1, y1, x2, y2, x3, y3;
	
	
	

	public Button(BufferedImage image) {
		this(image, image.getWidth(), image.getHeight());
	}

	public Button(BufferedImage image, int srcWidth, int srcHeight) {
		this(image, 0, 0, srcWidth, srcHeight);
	}

	public Button(BufferedImage image, Rectangle textureRegion) {
		this(image, textureRegion.x, textureRegion.y, textureRegion.width, textureRegion.height);
	}

	public Button(BufferedImage image, int srcX, int srcY, int srcWidth, int srcHeight) {
		this(image, srcX, srcY, srcX, srcY, srcX, srcY, srcWidth, srcHeight);
	}
	
	public Button(BufferedImage image, int x1, int y1, int x2, int y2, int x3, int y3, int width, int height) {
		super(image, x1, y1, width, height);
		
	}

}
