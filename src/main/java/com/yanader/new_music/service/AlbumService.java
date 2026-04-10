package com.yanader.new_music.service;

import com.yanader.new_music.entity.Album;

import java.util.List;
import java.util.Optional;

public interface AlbumService {
    List<Album> getAllAlbums();
    Optional<Album> getAlbumById(Long id);
    List<Album> getAlbumsByListeningYear(Integer listeningYear);
    List<Album> getAlbumsByReleaseYear(Integer releaseYear);
}
