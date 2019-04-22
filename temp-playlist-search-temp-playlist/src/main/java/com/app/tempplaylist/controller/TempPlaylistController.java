package com.app.tempplaylist.controller;

import com.app.tempplaylist.dto.DataDto;
import com.app.tempplaylist.dto.MusicDto;
import com.app.tempplaylist.service.TempPlaylistServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping(value = "/api/playlist")
public class TempPlaylistController {

    @Autowired
    private TempPlaylistServer tempPlaylistServer;

    @GetMapping("locale/{locale}")
    public ResponseEntity<DataDto<Set<MusicDto>>> tempPlaylist(@PathVariable String locale) {
        return ResponseEntity.ok(tempPlaylistServer.tempPlaylist(locale));
    }

    @GetMapping("lat/{lat}/lon/{lon}")
    public ResponseEntity<DataDto<Set<MusicDto>>> redirectPage(@PathVariable Float lat, @PathVariable Float lon) {
        return ResponseEntity.ok(tempPlaylistServer.tempPlaylist(lat, lon));
    }

}
