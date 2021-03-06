package snake.ui.tiles;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

@SuppressWarnings("serial")
public class Button extends Tile {

	private boolean pressed;
	private boolean focussed;
	private boolean stateChanged;
	private BufferedImage[] resources;
	private ActionListener l;
	
	// NOT IMPLEMENTED YET
	@Deprecated
	public Button(BufferedImage[] resources, float xRatio, float yRatio, float widthRatio, float heightRatio) {
		super(resources[0], xRatio, yRatio, widthRatio, heightRatio);
		this.resources = resources;
	}
	
	public Button(BufferedImage[] resources, int x, int y, int width, int height) {
		super(resources[0], x, y, width, height);
		this.resources = resources;
		pressed = false;
		focussed = false;
		stateChanged = false;
	}

	@Override
	public void update() {
		if (stateChanged) {
			if (pressed)
				resource = resources[2];
			else if (focussed)
				resource = resources[1];
			else
				resource = resources[0];
			stateChanged = false;
		}
	}

	public void fireClickEvent(MouseEvent e) {
		if (l != null)
			l.actionPerformed(new ActionEvent(e.getSource(), e.getID(), null));
	}
	
	public void addActionListener(ActionListener l) {
		this.l = l;
	}

	public boolean isFocussed() {
		return focussed;
	}

	public void focus() {
		stateChanged = true;
		focussed = true;
	}

	public void unfocus() {
		stateChanged = true;
		focussed = false;
	}

	public boolean isPressed() {
		return pressed;
	}

	public void press() {
		stateChanged = true;
		pressed = true;
	}

	public void unpress() {
		stateChanged = true;
		pressed = false;
	}

}
