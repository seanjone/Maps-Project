package maps.control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import maps.MapGUI;
import maps.cities.Cities;
import maps.cities.City;

public class SearchListener implements KeyListener {
	private Cities cities;
	private MapGUI gui;

	public SearchListener(MapGUI gui, Cities cities) {
		this.cities = cities;
		this.gui = gui;
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		ArrayList<City> citiesSearched = this.cities.searchByName(gui.getSearchBar().getText());
		gui.getCitiesBox().removeAllItems();
		for (City city : citiesSearched) {
			gui.getCitiesBox().addItem(city);

		}

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
