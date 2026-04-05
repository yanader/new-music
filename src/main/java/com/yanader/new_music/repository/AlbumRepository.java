package com.yanader.new_music.repository;

import com.yanader.new_music.entity.Album;
import com.yanader.new_music.entity.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {
    Optional<Album> findByNameIgnoreCase(String artistName);
}
