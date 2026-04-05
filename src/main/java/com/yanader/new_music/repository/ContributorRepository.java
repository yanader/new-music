package com.yanader.new_music.repository;

import com.yanader.new_music.entity.Contributor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContributorRepository extends JpaRepository<Contributor, Long> {
}
