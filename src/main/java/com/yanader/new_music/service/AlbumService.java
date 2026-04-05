package com.yanader.new_music.service;

import com.yanader.new_music.entity.Album;

import java.util.List;
import java.util.Optional;

public interface AlbumService {
    List<Album> getAllAlbums();
    List<Album> getAlbumsByListeningYear(int listeningYear);
    List<Album> getAlbumsByReleaseYear(int releaseYear);
    Optional<Album> getAlbumById(Long id);
}
