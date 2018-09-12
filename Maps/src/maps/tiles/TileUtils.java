package maps.tiles;

import java.util.ArrayList;

import maps.cities.City;

public class TileUtils {
	public static Tile getTile(City city) {
		int x = xCoordinate(city.getLongitude());
		int y = yCoordinate(city.getLatitude());
		return new Tile(x, y);
	}

	public static ArrayList<Tile> getTileMap(Tile tile) {
		ArrayList<Tile> tileMap = new ArrayList<>();
		tileMap.add(new Tile(tile.getX() - 1, tile.getY() - 1));
		tileMap.add(new Tile(tile.getX(), tile.getY() - 1));
		tileMap.add(new Tile(tile.getX() + 1, tile.getY() - 1));
		tileMap.add(new Tile(tile.getX() - 1, tile.getY()));
		tileMap.add(new Tile(tile.getX(), tile.getY()));
		tileMap.add(new Tile(tile.getX() + 1, tile.getY()));
		tileMap.add(new Tile(tile.getX() - 1, tile.getY() + 1));
		tileMap.add(new Tile(tile.getX(), tile.getY() + 1));
		tileMap.add(new Tile(tile.getX() + 1, tile.getY() + 1));
		return tileMap;
	}

	public static int xCoordinate(String longitude) {
		double lon = new Double(longitude);
		return (int) (((lon + 180) / 360) * Math.pow(2, 6));
	}

	public static int yCoordinate(String latitude) {
		double lat = new Double(latitude);
		double tanLat = Math.tan((lat * Math.PI) / 180);
		double cosLat = Math.cos((lat * Math.PI) / 180);
		double lnLat = Math.log(tanLat + (1 / cosLat));
		return new Integer((int) ((1 - (lnLat / Math.PI)) * Math.pow(2, 5)));
	}

}
