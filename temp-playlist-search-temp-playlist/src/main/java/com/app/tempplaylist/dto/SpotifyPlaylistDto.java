package com.app.tempplaylist.dto;

import java.io.Serializable;
import java.util.Set;

public class SpotifyPlaylistDto implements Serializable {

    private TracksDto tracks;

    public TracksDto getTracks() {
        return tracks;
    }

    public void setTracks(TracksDto tracks) {
        this.tracks = tracks;
    }
}
