package maps;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import maps.cities.Cities;
import maps.cities.City;
import maps.control.CitySelectListener;
import maps.control.SearchListener;
import maps.control.TranslateListener;
import maps.tiles.Tile;
import maps.tiles.TileUtils;

public class MapGUI {
	private Cities cities;
	private City city;
	private JTextField searchBar;
	private JComboBox<City> citiesBox;
	private JButton searchButton;
	private JLabel grid1 = new JLabel();
	private JLabel grid2 = new JLabel();
	private JLabel grid3 = new JLabel();
	private JLabel grid4 = new JLabel();
	private JLabel grid5 = new JLabel();
	private JLabel grid6 = new JLabel();
	private JLabel grid7 = new JLabel();
	private JLabel grid8 = new JLabel();
	private JLabel grid9 = new JLabel();
	private Tile previousTile;

	public MapGUI(Cities cities) {
		this.cities = cities;
		this.city = cities.getDefaultCity();
		setReferenceTile(TileUtils.getTile(this.city));
		this.searchBar = new JTextField(10);
		this.citiesBox = new JComboBox<>();
		for (City city : cities.getAllCities()) {
			this.citiesBox.addItem(city);
		}
		this.searchButton = new JButton("Go!");
	}

	public JPanel getSearchPanel() {
		JPanel panel = new JPanel();
		this.searchBar.addKeyListener(new SearchListener(this, this.cities));
		panel.add(this.searchBar);
		panel.add(this.citiesBox);
		this.searchButton.addActionListener(new CitySelectListener(this));
		panel.add(this.searchButton);
		return panel;
	}

	public JPanel getMapPanel() {
		JPanel panel = new JPanel();
		this.grid1.addMouseListener(new TranslateListener(this, -1, -1));
		panel.add(this.grid1);
		this.grid2.addMouseListener(new TranslateListener(this, 0, -1));
		panel.add(this.grid2);
		this.grid3.addMouseListener(new TranslateListener(this, 1, -1));
		panel.add(this.grid3);
		this.grid4.addMouseListener(new TranslateListener(this, -1, 0));
		panel.add(this.grid4);
		this.grid5.addMouseListener(new TranslateListener(this, 0, 0));
		panel.add(this.grid5);
		this.grid6.addMouseListener(new TranslateListener(this, 1, 0));
		panel.add(this.grid6);
		this.grid7.addMouseListener(new TranslateListener(this, -1, 1));
		panel.add(this.grid7);
		this.grid8.addMouseListener(new TranslateListener(this, 0, 1));
		panel.add(this.grid8);
		this.grid9.addMouseListener(new TranslateListener(this, 1, 1));
		panel.add(this.grid9);
		panel.setLayout(new GridLayout(3, 3));
		return panel;
	}

	public void setReferenceTile(Tile tile) {
		this.previousTile = tile;
		ArrayList<Tile> tiles = TileUtils.getTileMap(tile);
		this.grid1.setIcon(tiles.get(0).getImageIcon());
		this.grid2.setIcon(tiles.get(1).getImageIcon());
		this.grid3.setIcon(tiles.get(2).getImageIcon());
		this.grid4.setIcon(tiles.get(3).getImageIcon());
		this.grid5.setIcon(tiles.get(4).getImageIcon());
		this.grid6.setIcon(tiles.get(5).getImageIcon());
		this.grid7.setIcon(tiles.get(6).getImageIcon());
		this.grid8.setIcon(tiles.get(7).getImageIcon());
		this.grid9.setIcon(tiles.get(8).getImageIcon());
	}

	public JTextField getSearchBar() {
		return searchBar;
	}

	public void setSearchBar(JTextField searchBar) {
		this.searchBar = searchBar;
	}

	public JComboBox<City> getCitiesBox() {
		return citiesBox;
	}

	public void setCitiesBox(JComboBox<City> citiesBox) {
		this.citiesBox = citiesBox;
	}

	public JButton getSearchButton() {
		return searchButton;
	}

	public void setSearchButton(JButton searchButton) {
		this.searchButton = searchButton;
	}

	public Tile getPreviousTile() {
		return this.previousTile;
	}

}
