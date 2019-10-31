package com.objectway.stage.examples.resttemplate.provider.dto;

import java.util.Arrays;
import java.util.Objects;

/**
 * Weather sample for day.
 */
public class WeatherDaySample {
	/**
	 * Average forecast of the day
	 */
	private String forecast;

	/**
	 * Minimum temperature of the day (Celsius or Farenheit)
	 */
	private int minTemperature;

	/**
	 * Maximum temperature of the day (Celsius or Farenheit)
	 */
	private int maxTemperature;

	/**
	 * Hour samples (whole day)
	 */
	private WeatherHourSample[] samples = new WeatherHourSample[24];

	public String getForecast() {
		return forecast;
	}

	public void setForecast(String forecast) {
		this.forecast = forecast;
	}

	public int getMinTemperature() {
		return minTemperature;
	}

	public void setMinTemperature(int minTemperature) {
		this.minTemperature = minTemperature;
	}

	public int getMaxTemperature() {
		return maxTemperature;
	}

	public void setMaxTemperature(int maxTemperature) {
		this.maxTemperature = maxTemperature;
	}

	public WeatherHourSample[] getSamples() {
		return samples;
	}

	public void setSamples(WeatherHourSample[] samples) {
		this.samples = samples;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		WeatherDaySample that = (WeatherDaySample) o;
		return Objects.equals(forecast, that.forecast) &&
				Objects.equals(minTemperature, that.minTemperature) &&
				Objects.equals(maxTemperature, that.maxTemperature) &&
				Arrays.equals(samples, that.samples);
	}

	@Override
	public int hashCode() {
		int result = Objects.hash(forecast, minTemperature, maxTemperature);
		result = 31 * result + Arrays.hashCode(samples);
		return result;
	}

	@Override
	public String toString() {
		return "WeatherDaySample{" +
				"forecast='" + forecast + '\'' +
				", minTemperature='" + minTemperature + '\'' +
				", maxTemperature='" + maxTemperature + '\'' +
				", samples=" + Arrays.toString(samples) +
				'}';
	}
}

