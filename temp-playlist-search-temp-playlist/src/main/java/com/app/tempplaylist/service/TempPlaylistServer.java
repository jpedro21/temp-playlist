package com.app.tempplaylist.service;


import com.app.tempplaylist.dto.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TempPlaylistServer {

    private final Logger logger = LoggerFactory.getLogger(TempPlaylistServer.class);

    @Autowired
    private WeatherService weatherService;

    @Autowired
    private PlaylistService playlistService;

    public DataDto tempPlaylist(String locale) {
        final WeatherDto weatherDto = weatherService.getTempByLocale(locale);
        Double temp = weatherDto.getTemperature();
        Genre genre = getPlaylistGenre(temp);

        return new DataDto(playlistService.getPlaylistByGenre(genre), genre.name());
    }

    public DataDto tempPlaylist(String lat, String lon) {
        final WeatherDto weatherDto = weatherService.getTempByLonLat(lat, lon);
        Double temp = weatherDto.getTemperature();
        Genre genre = getPlaylistGenre(temp);

        return new DataDto(playlistService.getPlaylistByGenre(genre), genre.name());
    }

    private Genre getPlaylistGenre(Double temp) {

        if(temp > 30) {
            return Genre.PARTY;
        } else if(temp >= 15 && temp <=30 ) {
            return Genre.POP;
        } else if(temp >= 10 && temp <= 14) {
            return Genre.ROCK;
        } else {
            return Genre.CLASSIC;
        }
    }
}