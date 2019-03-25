package com.app.tempplaylist.dto;

import java.util.Set;

public class TracksDto {

    private Set<PlaylistDto> items;

    public Set<PlaylistDto> getItems() {
        return items;
    }

    public void setItems(Set<PlaylistDto> items) {
        this.items = items;
    }
}
