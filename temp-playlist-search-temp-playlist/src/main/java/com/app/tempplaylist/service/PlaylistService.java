package com.app.tempplaylist.service;

import com.app.tempplaylist.dto.PlaylistDto;

import java.util.Set;

public interface PlaylistService {

    public Set<PlaylistDto> getPlaylistByGenre(Genre genre);
}
