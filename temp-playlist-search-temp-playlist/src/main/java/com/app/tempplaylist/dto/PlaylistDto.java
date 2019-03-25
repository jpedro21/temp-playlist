package com.app.tempplaylist.dto;

import java.io.Serializable;
import java.util.Set;

public class PlaylistDto {

    private String name;

    private Set<ArtistsDto> artists;

    private AlbumDto album;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<ArtistsDto> getArtists() {
        return artists;
    }

    public void setArtists(Set<ArtistsDto> artists) {
        this.artists = artists;
    }

    public AlbumDto getAlbum() {
        return album;
    }

    public void setAlbum(AlbumDto album) {
        this.album = album;
    }
}
