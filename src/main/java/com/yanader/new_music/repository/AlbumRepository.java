package com.yanader.new_music.repository;

import com.yanader.new_music.entity.Album;
import org.jspecify.annotations.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {
    Optional<Album> findByNameIgnoreCase(String artistName);
    List<Album> findByYearSet_ListeningYear(Integer listeningYear);
    List<Album> findByYearSet_ReleaseYear(Integer releaseYear);
}
