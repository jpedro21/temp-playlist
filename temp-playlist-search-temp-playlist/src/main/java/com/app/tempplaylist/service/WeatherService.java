package com.app.tempplaylist.service;

import com.app.tempplaylist.dto.WeatherDto;

public interface WeatherService {

    public WeatherDto getTempByLocale(String locale);
    public WeatherDto getTempByLonLat(Float lat, Float lon);
}
