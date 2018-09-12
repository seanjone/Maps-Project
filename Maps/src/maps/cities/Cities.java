package maps.cities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Cities {
	private String fileName;
	private ArrayList<City> allCities;

	public Cities(String file) {
		this.fileName = file;
		this.allCities = new ArrayList<>();
		parseCities();
	}

	public void parseCities() {
		try {
			for (String line : Files.readAllLines(Paths.get(this.fileName))) {
				String[] temp = line.split(",");
				City city = new City(temp[3], temp[4], temp[5], temp[1], temp[0], temp[2]);
				this.allCities.add(city);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public City getDefaultCity() {
		City defaultCity = null;
		for (City city : allCities) {
			if (city.getName().equals("buffalo") && city.getRegion().equals("NY")) {
				defaultCity = city;
				break;
			}
		}
		return defaultCity;
	}

	public ArrayList<City> searchByName(String name) {
		ArrayList<City> sameName = new ArrayList<>();
		for (City city : allCities) {
			if (city.getName().contains(name)) {
				sameName.add(city);
			}
		}
		Collections.sort(sameName, new Comparator<City>() {
			@Override
			public int compare(City arg0, City arg1) {
				int pop1 = new Integer(arg0.getPopulation());
				int pop2 = new Integer(arg1.getPopulation());
				if (pop1 > pop2) {
					return -1;
				} else if (pop1 < pop2) {
					return 1;
				} else {
					return 0;
				}
			}
		});
		return sameName;
	}

	public ArrayList<City> getAllCities() {
		return this.allCities;
	}
}
