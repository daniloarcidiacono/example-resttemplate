package com.objectway.stage.examples.resttemplate.controller;

import com.objectway.stage.examples.resttemplate.provider.WeatherServiceProvider;
import com.objectway.stage.examples.resttemplate.provider.domain.Forecast;
import com.objectway.stage.examples.resttemplate.provider.domain.TemperatureUnit;
import com.objectway.stage.examples.resttemplate.provider.domain.WeekDay;
import com.objectway.stage.examples.resttemplate.provider.dto.WeatherDaySample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {
    @Autowired
    private WeatherServiceProvider weatherProvider;

    @GetMapping("/umbrella/{location}")
    public String shouldIBringTheUmbrella(@PathVariable final String location) {
        final WeatherDaySample daySample = weatherProvider.getDailyForecast(location, WeekDay.MONDAY, TemperatureUnit.CELSIUS);
        if (daySample == null) {
            return "Unknown";
        }

        return Forecast.RAINY.equals(Forecast.valueOf(daySample.getForecast())) ? "Yes" :"No";
    }
}
