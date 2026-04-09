package com.yanader.new_music.service;

import com.yanader.new_music.entity.Album;
import com.yanader.new_music.entity.Statistics;

import java.util.List;

public interface StatisticsService {
    List<Integer> getDistinctListeningYears();
    List<Integer> getDistinctReleaseYears();
    Statistics getStatistics(List<Album> albums);
}
