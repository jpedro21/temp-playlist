package com.app.tempplaylist.service;

import com.app.tempplaylist.dto.OpenWeatherMapDto;
import com.app.tempplaylist.dto.WeatherDto;
import com.app.tempplaylist.exception.NoResultException;
import com.app.tempplaylist.exception.WeatherException;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class OpenWeatherService implements WeatherService {

    public static final String URI = "http://api.openweathermap.org/data/2.5/weather";
    public static final String API_CODE = "55a085a9d1b6f648eac7d6ca892c065f";
    public static final String CELSIUS = "metric";

    private RestTemplate restTemplate;

    public OpenWeatherService() {
        this.restTemplate = new RestTemplate();
    }

    @Override
    @HystrixCommand(
            ignoreExceptions = {NoResultException.class, WeatherException.class},
            raiseHystrixExceptions = {HystrixException.RUNTIME_EXCEPTION})
    public WeatherDto getTempByLocale(String locale) {

        UriComponentsBuilder uriBuilder =  this.prepareUri()
                .queryParam("q", locale);

        OpenWeatherMapDto response = restTemplate.getForObject(uriBuilder.build().toUri(),
                OpenWeatherMapDto.class);
        return mapperResponse(response);
    }

    @Override
    @HystrixCommand(
            ignoreExceptions = {NoResultException.class, WeatherException.class},
            raiseHystrixExceptions = {HystrixException.RUNTIME_EXCEPTION})
    public WeatherDto getTempByLonLat(Float lat, Float lon) {

        if(lon == null || lat == null) {
            throw new WeatherException("Longitude e latitude are mandatory.");
        }

        UriComponentsBuilder uriBuilder =  this.prepareUri()
                .queryParam("lat", lat)
                .queryParam("lon", lon);

        OpenWeatherMapDto response = restTemplate.getForObject(uriBuilder.build().toUri(),
                OpenWeatherMapDto.class);
        return mapperResponse(response);
    }

    private UriComponentsBuilder prepareUri() {

        UriComponentsBuilder uriBuilder =  UriComponentsBuilder.fromUriString(URI);
        uriBuilder.queryParam("appid", API_CODE)
                .queryParam("units", CELSIUS);

        return uriBuilder;
    }

    private WeatherDto mapperResponse(OpenWeatherMapDto dto) {
        try {
            return new WeatherDto(dto.getMain().getTemp());
        } catch (NullPointerException e) {
            throw new NoResultException("Weather data not found.");
        }
    }
}
