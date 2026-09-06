package com.yanader.new_music.repository;

import com.yanader.new_music.entity.Artist;
import com.yanader.new_music.entity.Contributor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ContributorRepository extends JpaRepository<Contributor, Long> {
    Optional<Contributor> findByNameIgnoreCase(String contributorName);
}
