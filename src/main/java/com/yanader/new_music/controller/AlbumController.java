package com.yanader.new_music.controller;

import com.yanader.new_music.entity.Album;
import com.yanader.new_music.service.AlbumService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/albums")
public class AlbumController {

    private AlbumService albumService;

    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @GetMapping
    public List<Album> getAllAlbums() {
        return albumService.getAllAlbums();
    }

    @GetMapping("/listening/{year}")
    public List<Album> getAlbumsByListeningYear(@PathVariable Integer year) {
        return albumService.getAlbumsByListeningYear(year);
    }

    @GetMapping("/release/{year}")
    public List<Album> getAlbumsByReleaseYear(@PathVariable Integer year) {
        return albumService.getAlbumsByReleaseYear(year);
    }
}
