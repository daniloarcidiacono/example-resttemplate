package com.objectway.stage.examples.resttemplate.provider.dto;


import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Weather forecast for a week.
 */
public class WeatherWeekDTO {
	private String location;

	/**
	 * Week day -> day sample
	 */
	private Map<String, WeatherDaySample> days = new HashMap<>();

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Map<String, WeatherDaySample> getDays() {
		return days;
	}

	public void setDays(Map<String, WeatherDaySample> days) {
		this.days = days;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		WeatherWeekDTO that = (WeatherWeekDTO) o;
		return Objects.equals(location, that.location) &&
				Objects.equals(days, that.days);
	}

	@Override
	public int hashCode() {
		return Objects.hash(location, days);
	}

	@Override
	public String toString() {
		return "WeatherWeekDTO{" +
				"location='" + location + '\'' +
				", days=" + days +
				'}';
	}
}

