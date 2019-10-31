package com.objectway.stage.examples.resttemplate.provider;

import com.objectway.stage.examples.resttemplate.provider.domain.TemperatureUnit;
import com.objectway.stage.examples.resttemplate.provider.domain.WeekDay;
import com.objectway.stage.examples.resttemplate.provider.dto.WeatherDaySample;
import com.objectway.stage.examples.resttemplate.provider.dto.WeatherWeekDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestClientResponseException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import javax.annotation.PostConstruct;

/**
 * Weather service client using {@link RestTemplate}.
 */
@Component
public class RestTemplateWeatherServiceProvider implements WeatherServiceProvider {
    private static final Logger logger = LoggerFactory.getLogger(RestTemplateWeatherServiceProvider.class);
    private final RestTemplate restTemplate;

    @Value("${providers.weather.url}")
    private String weatherServiceUrl;

    public RestTemplateWeatherServiceProvider(final RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @PostConstruct
    private void checkUrl() {
        // Make sure that the url does not end with a forward slash
        // Note: this is not needed when using UriComponentsBuilder
        if (weatherServiceUrl.endsWith("/")) {
            weatherServiceUrl = weatherServiceUrl.substring(0, weatherServiceUrl.length() - 1);
        }
    }

    @Override
    public WeatherWeekDTO getWeeklyForecast(final String location, final TemperatureUnit temperatureUnit) {
        final String url = weatherServiceUrl + String.format("/forecast/%s/week", location);
        try {
            logger.trace("GET {}", url);
            return restTemplate.getForObject(url, WeatherWeekDTO.class);
        } catch (RestClientResponseException ex) {
            // Http error response
            logger.error("GET {} - HTTP {} - {}", url, ex.getRawStatusCode(), ex.getResponseBodyAsString());
        } catch (ResourceAccessException ex) {
            // Connection error (ex. wrong URL), or unknown http code received
            logger.error("GET {} - {}", url, ex.getMessage());
        }

        // An error has occurred
        return null;
    }

    @Override
    public WeatherDaySample getDailyForecast(final String location, final WeekDay weekday, final TemperatureUnit temperatureUnit) {
//        final String url = weatherServiceUrl + String.format("/forecast/%s/day/%s", location, weekday.toString());
        final String url = UriComponentsBuilder.fromHttpUrl(weatherServiceUrl)
            .path("/forecast/{location}/day/{weekday}")
            .buildAndExpand(location, weekday)
            .toUriString();

        try {
            logger.trace("GET {}", url);

            final HttpHeaders headers = new HttpHeaders();
            headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);

            final HttpEntity<?> requestEntity = new HttpEntity<>(headers);
//            final ResponseEntity<WeatherDaySample> forEntity = restTemplate.getForEntity(url, WeatherDaySample.class);
            final ResponseEntity<WeatherDaySample> forEntity = restTemplate.exchange(url, HttpMethod.GET, requestEntity, WeatherDaySample.class);

            logger.trace("GET {} - HTTP {}", url, forEntity.getStatusCodeValue());

            return forEntity.getBody();
        } catch (RestClientResponseException ex) {
            // Http error response
            logger.error("GET {} - HTTP {} - {}", url, ex.getRawStatusCode(), ex.getResponseBodyAsString());
        } catch (ResourceAccessException ex) {
            // Connection error (ex. wrong URL), or unknown http code received
            logger.error("GET {} - {}", url, ex.getMessage());
        }

        // An error has occurred
        return null;
    }
}
