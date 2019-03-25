package com.app.tempplaylist.dto;

public class WeatherDto {

    public WeatherDto(Double temp) {
        temperature = temp;
    }

    private Double temperature;

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }
}
