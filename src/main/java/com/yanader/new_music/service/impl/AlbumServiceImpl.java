package com.yanader.new_music.service.impl;

import com.yanader.new_music.entity.Album;
import com.yanader.new_music.entity.dtos.AlbumDTO;
import com.yanader.new_music.entity.dtos.RateAlbumRequestDTO;
import com.yanader.new_music.mapper.AlbumMapper;
import com.yanader.new_music.repository.AlbumRepository;
import com.yanader.new_music.service.AlbumService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AlbumServiceImpl implements AlbumService {

    private final AlbumRepository albumRepository;
    private final AlbumMapper mapper;

    public AlbumServiceImpl(AlbumRepository albumRepository, AlbumMapper albumMapper) {
        this.albumRepository = albumRepository;
        this.mapper = albumMapper;
    }

    @Override
    public List<Album> getAllAlbums() {
        return albumRepository.findAllWithDetails(); // was findAll()
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

    @Override
    public Album rateAlbum(Long id, RateAlbumRequestDTO req) {
        Optional<Album> optionalAlbum = albumRepository.findById(id);
        if (optionalAlbum.isEmpty()) return null;
        Album albumToRate = optionalAlbum.get();
        albumToRate.setRating(req.rating());
        albumToRate.setNotes(req.notes());
        return albumRepository.save(albumToRate);
    }

    @Override
    public Album saveAlbum(AlbumDTO req) {
        Album album = mapper.toAlbumEntity(req);
        return albumRepository.save(album);
    }

    @Override
    public List<Album> saveAlbums(List<AlbumDTO> reqs) {
        return reqs.stream()
                .map(this::saveAlbum)
                .collect(Collectors.toList());
    }
}
