package maps.cities;

public class City {
	private String population;
	private String latitude;
	private String longitude;
	private String name;
	private String country;
	private String region;

	public City(String population, String latitude, String longitude, String name, String country, String region) {
		this.population = population;
		this.latitude = latitude;
		this.longitude = longitude;
		this.name = name;
		this.country = country;
		this.region = region;
	}

	public String getPopulation() {
		return population;
	}

	public void setPopulation(String population) {
		this.population = population;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	@Override
	public String toString() {

		return this.population + " - " + this.name + ", " + this.region + ", " + this.country;
	}

}
