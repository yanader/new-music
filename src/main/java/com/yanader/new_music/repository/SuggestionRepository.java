package com.yanader.new_music.repository;

import com.yanader.new_music.entity.Album;
import com.yanader.new_music.entity.Contributor;
import com.yanader.new_music.entity.Suggestion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SuggestionRepository extends JpaRepository<Suggestion, Long> {
    List<Suggestion> findByAlbum(Album album);
    List<Suggestion> findByContributor(Contributor contributor);
}
