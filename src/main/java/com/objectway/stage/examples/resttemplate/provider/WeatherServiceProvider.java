package com.objectway.stage.examples.resttemplate.provider;

import com.objectway.stage.examples.resttemplate.provider.domain.TemperatureUnit;
import com.objectway.stage.examples.resttemplate.provider.domain.WeekDay;
import com.objectway.stage.examples.resttemplate.provider.dto.WeatherDaySample;
import com.objectway.stage.examples.resttemplate.provider.dto.WeatherWeekDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

public interface WeatherServiceProvider {
    /**
     * Fetches the weekly forecast for the specific location
     * @param location the location
     * @param temperatureUnit the temperature unit
     * @return the requested forecast, or null if it could not be retrieved
     */
    @GetMapping("/forecast/{location}/week")
    WeatherWeekDTO getWeeklyForecast(@PathVariable("location") final String location, @RequestParam(value = "temperatureUnit", required = false, defaultValue = "CELSIUS") final TemperatureUnit temperatureUnit);

    /**
     * Fetches the daily forecast for the specific location and weekday
     * @param location the location
     * @param weekday the week day
     * @param temperatureUnit the temperature unit
     * @return the requested forecast, or null if it could not be retrieved
     */
    @GetMapping("/forecast/{location}/day/{weekday}")
    WeatherDaySample getDailyForecast(@PathVariable("location") final String location, @PathVariable("weekday") final WeekDay weekday, @RequestParam(value = "temperatureUnit", required = false, defaultValue = "CELSIUS") final TemperatureUnit temperatureUnit);
}
