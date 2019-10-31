package com.objectway.stage.examples.resttemplate.provider.dto;

import com.objectway.stage.examples.resttemplate.provider.domain.Forecast;

import java.util.Objects;

/**
 * Weather sample for an hour.
 */
public class WeatherHourSample {
	private Forecast forecast;

	/**
	 * Celsius or Farenheit
	 */
	private int temperature;

	/**
	 * Percentage (0-100)
	 */
	private int rainfall;

	/**
	 * Percentage (0-100)
	 */
	private int humidity;

	/**
	 * Wind speed in km/h
	 */
	private int wind;

	public Forecast getForecast() {
		return forecast;
	}

	public void setForecast(Forecast forecast) {
		this.forecast = forecast;
	}

	public int getTemperature() {
		return temperature;
	}

	public void setTemperature(int temperature) {
		this.temperature = temperature;
	}

	public int getRainfall() {
		return rainfall;
	}

	public void setRainfall(int rainfall) {
		this.rainfall = rainfall;
	}

	public int getHumidity() {
		return humidity;
	}

	public void setHumidity(int humidity) {
		this.humidity = humidity;
	}

	public int getWind() {
		return wind;
	}

	public void setWind(int wind) {
		this.wind = wind;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		WeatherHourSample that = (WeatherHourSample) o;
		return temperature == that.temperature &&
				rainfall == that.rainfall &&
				humidity == that.humidity &&
				wind == that.wind &&
				Objects.equals(forecast, that.forecast);
	}

	@Override
	public int hashCode() {
		return Objects.hash(forecast, temperature, rainfall, humidity, wind);
	}

	@Override
	public String toString() {
		return "WeatherHourSample{" +
				"forecast='" + forecast + '\'' +
				", temperature=" + temperature +
				", rainfall=" + rainfall +
				", humidity=" + humidity +
				", wind=" + wind +
				'}';
	}
}
