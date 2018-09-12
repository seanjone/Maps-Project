package maps.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import maps.MapGUI;
import maps.cities.City;
import maps.tiles.TileUtils;

public class CitySelectListener implements ActionListener {
	private MapGUI gui;

	public CitySelectListener(MapGUI gui) {
		this.gui = gui;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		City city = (City) gui.getCitiesBox().getSelectedItem();
		gui.setReferenceTile(TileUtils.getTile(city));

	}

}
