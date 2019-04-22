package com.app.tempplaylist.dto;

import java.util.Set;

public class TracksDto {

    private Set<MusicDto> items;

    public Set<MusicDto> getItems() {
        return items;
    }

    public void setItems(Set<MusicDto> items) {
        this.items = items;
    }
}
