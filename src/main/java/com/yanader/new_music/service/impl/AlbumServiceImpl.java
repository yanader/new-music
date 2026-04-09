package com.yanader.new_music.service.impl;

import com.yanader.new_music.entity.Album;
import com.yanader.new_music.repository.AlbumRepository;
import com.yanader.new_music.service.AlbumService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlbumServiceImpl implements AlbumService {

    private final AlbumRepository albumRepository;

    public AlbumServiceImpl(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @Override
    public List<Album> getAllAlbums() {
        return albumRepository.findAll();
    }

    @Override
    public List<Album> getAlbumsByListeningYear(int listeningYear) {
        return albumRepository.findByYearSet_ListeningYear(listeningYear);
    }

    @Override
    public List<Album> getAlbumsByReleaseYear(int releaseYear) {
        return albumRepository.findByYearSet_ReleaseYear(releaseYear);
    }

    @Override
    public Optional<Album> getAlbumById(Long id) {
        return albumRepository.findById(id);
    }

    @Override
    public List<Album> getAlbumsByListeningYear(Integer listeningYear) {
        return albumRepository.findByYearSet_ListeningYear(listeningYear);
    }

    @Override
    public List<Album> getAlbumsByReleaseYear(Integer releaseYear) {
        return albumRepository.findByYearSet_ReleaseYear(releaseYear);
    }
}
