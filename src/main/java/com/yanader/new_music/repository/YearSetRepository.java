package com.yanader.new_music.repository;

import com.yanader.new_music.entity.YearSet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface YearSetRepository extends JpaRepository<YearSet, Long> {
    @Query("SELECT DISTINCT ys.listeningYear FROM YearSet ys ORDER BY ys.listeningYear")
    List<Integer> findAllDistinctListeningYears();

    @Query("SELECT DISTINCT ys.releaseYear FROM YearSet ys ORDER BY ys.releaseYear")
    List<Integer> findAllDistinctReleaseYears();
}
