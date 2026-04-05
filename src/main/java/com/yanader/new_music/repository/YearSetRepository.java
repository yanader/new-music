package com.yanader.new_music.repository;

import com.yanader.new_music.entity.YearSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface YearSetRepository extends JpaRepository<YearSet, Long> {
}
