package com.app.tempplaylist.service;

import com.app.tempplaylist.dto.PlaylistDto;
import com.app.tempplaylist.dto.SpotifyPlaylistDto;
import com.app.tempplaylist.dto.TokenDto;
import com.app.tempplaylist.exception.NoResultException;
import com.app.tempplaylist.exception.PlaylistException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.support.BasicAuthenticationInterceptor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Set;

@Service
public class SpotifyService implements PlaylistService {

    private static final String URI = "https://api.spotify.com/v1";
    private static final String TOKEN_URI = "https://accounts.spotify.com/api/token";
    private static final String CLIENT_ID = "c71e1bb871494e78a40abcfe6fa62bfd";
    private static final String CLIENT_SECRET = "91c460b8fc59447880db261506701c81";

    private RestTemplate restTemplate;

    public SpotifyService() {
        restTemplate = new RestTemplate();
    }

    @Override
    public Set<PlaylistDto> getPlaylistByGenre(Genre genre) {
        if(genre == null) {
            throw new PlaylistException("The music genre is mandatory");
        }

        UriComponentsBuilder uriBuilder =  UriComponentsBuilder.fromUriString(URI + "/search")
                .queryParam("q", getGenreParam(genre))
                .queryParam("type", "track")
                .queryParam("limit", 50);

        HttpHeaders header = generateHttpHeader();

        final ResponseEntity<SpotifyPlaylistDto> response = restTemplate.exchange(uriBuilder.build().toUri(),
                HttpMethod.GET,
                new HttpEntity<Object>(header),
                SpotifyPlaylistDto.class);

        try {
            Set<PlaylistDto> items =  response.getBody().getTracks().getItems();
            if (items.size() < 0) {
                throw new NoResultException("No musics found.");
            }

            return items;
        } catch(NullPointerException e) {
            throw new NoResultException("No musics found.");
        }
    }

    private HttpHeaders generateHttpHeader() {
        HttpHeaders header = new HttpHeaders();
        header.add("Authorization", "Bearer " + generateToken().getAccessToken());
        return header;
    }

    private TokenDto generateToken() {
        UriComponentsBuilder uriBuilder =  UriComponentsBuilder.fromUriString(TOKEN_URI)
                .queryParam("grant_type", "client_credentials");

        restTemplate.getInterceptors().add(new BasicAuthenticationInterceptor(CLIENT_ID, CLIENT_SECRET));

        return restTemplate.postForObject(uriBuilder.build().toUri(), null, TokenDto.class);
    }

    private String getGenreParam(Genre genre) {
        if(genre != null) {
            if(genre.equals(Genre.POP)) {
                return "genre:pop";
            } else if(genre.equals(Genre.PARTY)) {
                return "genre:eletronic";
            } else if(genre.equals(Genre.ROCK)) {
                return "genre:classic+rock";
            } else if(genre.equals(Genre.CLASSIC)) {
                return "genre:classic";
            }
        }

        return null;
    }
}
