package com.yanader.new_music.controller;

import com.yanader.new_music.entity.Album;
import com.yanader.new_music.service.AlbumService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/albums")
public class AlbumController {

    private final AlbumService albumService;

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

    @GetMapping("{id}")
    public Album getAlbumById(@RequestParam long id) {
        /*
        End point to get the details of one album. Will be used ahead of submitting a review
         */
        return null;
    }

    @PatchMapping("{}")
    public Album reviewAlbum(@RequestBody Album album) {
        /* The end point through which we will submit an album rating and notes to add to the album entity
            Will require:
            Service level logic to get the album (by ID or Name?) from the repo
        */

        return null;
    }
}
