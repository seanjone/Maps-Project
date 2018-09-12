package maps.control;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import maps.MapGUI;
import maps.tiles.Tile;

public class TranslateListener implements MouseListener {
	private int dx;
	private int dy;
	private MapGUI gui;

	public TranslateListener(MapGUI gui, int x, int y) {
		this.dx = x;
		this.dy = y;
		this.gui = gui;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		gui.setReferenceTile(new Tile(gui.getPreviousTile().getX() + this.dx, gui.getPreviousTile().getY() + dy));
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
