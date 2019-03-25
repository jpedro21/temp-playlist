package com.app.tempplaylist.dto;

import java.io.Serializable;

public class OpenWeatherMapDto implements Serializable {

    private MainDto main;

    public MainDto getMain() {
        return main;
    }

    public void setMain(MainDto main) {
        this.main = main;
    }
}
