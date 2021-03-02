package snake.ui;

import java.awt.Graphics2D;

/**
 * @author leo
 */
public interface Drawable {

	/**
	 * Draws this component and potential subcomponents directly onto the given Graphics 
	 * without altering loaction, scale, rotation, etc.
	 * 
	 * @param g the Graphics to draw onto
	 */
	public void drawComponent(Graphics2D g);
	
	/**
	 * Draws this component and potential subcomponents onto the given Graphics
	 * with location, scale, rotation, etc defined by the component itself.
	 * 
	 * @param g the Graphics to draw onto
	 */
	public void render(Graphics2D g);
	
}