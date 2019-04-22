package com.app.tempplaylist.service;

import com.app.tempplaylist.dto.MusicDto;

import java.util.Set;

public interface PlaylistService {

    public Set<MusicDto> getPlaylistByGenre(Genre genre);
}
