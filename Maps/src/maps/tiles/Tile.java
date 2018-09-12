package maps.tiles;

import java.io.IOException;
import java.net.URL;

import javax.swing.ImageIcon;

public class Tile {
	private static String root = "http://a.tile.openstreetmap.org/";
	private int x;
	private int y;
	private static int zoom = 6;

	public Tile(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public String getTileURL() {
		return Tile.root + Tile.zoom + "/" + this.x + "/" + this.y + ".png";
	}

	public ImageIcon getImageIcon() {
		ImageIcon image = null;
		try {
			String longURL = this.getTileURL();
			URL url = new URL(longURL);
			image = new ImageIcon(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return image;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	@Override
	public String toString() {
		return this.getTileURL();
	}

}
