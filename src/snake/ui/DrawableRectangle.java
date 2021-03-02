/**
 * 
 */
package snake.ui;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

/**
 * @author leo
 */
@SuppressWarnings("serial")
public abstract class DrawableRectangle extends Rectangle implements Drawable {

	// **********
	// * Fields *
	// **********
	protected volatile double radRotation = 0;
	protected volatile int originX = 0, originY = 0;
	
	
	

	// ****************
	// * Constructors *
	// ****************
	public DrawableRectangle() {
		super();
	}

	public DrawableRectangle(Dimension d) {
		super(d);
	}

	public DrawableRectangle(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	public DrawableRectangle(int width, int height) {
		super(width, height);
	}

	public DrawableRectangle(Point p, Dimension d) {
		super(p, d);
	}

	public DrawableRectangle(Point p) {
		super(p);
	}

	public DrawableRectangle(Rectangle r) {
		super(r);
	}
	
	
	

	// ******************
	// * Public Methods *
	// ******************
	public void setOrigin(Point p) {
		setOrigin(p.x, p.y);
	}
	
	public void setOrigin(int x, int y) {
		this.originX = x;
		this.originY = y;
	}
	
	public void centerOrigin() {
		setOrigin(width/2, height/2);
	}
	
	public void setRotation(double degrees) {
		this.radRotation = Math.toRadians(degrees);
	}
	
	public void rotate(double degrees) {
		this.radRotation += Math.toRadians(degrees);
	}
	
	@Override
	public void render(Graphics2D g) {
		g.translate(x, y);
		g.rotate(radRotation);
		drawComponent(g);
		g.rotate(-radRotation);
		g.translate(-x, -y);
	}
	
}
