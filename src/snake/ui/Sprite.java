/**
 * 
 */
package snake.ui;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 * @author leo
 */
@SuppressWarnings({"serial", "unused"})
public class Sprite extends DrawableRectangle {

	// **********
	// * Fields *
	// **********
	protected volatile BufferedImage resource;
	protected volatile int srcX1, srcY1, srcX2, srcY2;
	
	
	

	// ****************
	// * Constructors *
	// ****************
	//Make inherited constructors invisible
	private Sprite() {
		super();
	}

	private Sprite(Dimension d) {
		super(d);
	}

	private Sprite(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	private Sprite(int width, int height) {
		super(width, height);
	}

	private Sprite(Point p, Dimension d) {
		super(p, d);
	}

	private Sprite(Point p) {
		super(p);
	}

	private Sprite(Rectangle r) {
		super(r);
	}
	
	

	
	public Sprite(BufferedImage image) {
		this(image, image.getWidth(), image.getHeight());
	}
	
	public Sprite(BufferedImage image, int srcWidth, int srcHeight) {
		this(image, 0, 0, srcWidth, srcHeight);
	}
	
	public Sprite(BufferedImage image, Rectangle textureRegion) {
		this(image, textureRegion.x, textureRegion.y, textureRegion.width, textureRegion.height);
	}
	
	public Sprite(BufferedImage image, int srcX, int srcY, int srcWidth, int srcHeight) {
		super(srcWidth, srcHeight);
		if(image == null) throw new NullPointerException("argument was null");
		this.resource = image;
		setRegion(srcX, srcY, srcWidth, srcHeight);
		setOrigin(0, 0);
	}
	
	
	

	// ******************
	// * Public Methods *
	// ******************
	public void setRegion(Rectangle region) {
		setRegion(region.x, region.y, region.width, region.height);
	}
	
	public void setRegion(int srcX, int srcY, int srcWidth, int srcHeigt) {
		this.srcX1 = srcX;
		this.srcY1 = srcY;
		this.srcX2 = srcX+srcWidth;
		this.srcY2 = srcY+srcHeigt;
	}
	
	@Override
	public void drawComponent(Graphics2D g) {
		g.drawImage(resource, -originX, -originY, -originX+width, -originY+height, srcX1, srcY1, srcX2, srcY2, null);
	}

}
