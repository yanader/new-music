package com.yanader.new_music.service.impl;

import com.yanader.new_music.entity.Album;
import com.yanader.new_music.entity.Statistics;
import com.yanader.new_music.service.AlbumService;
import com.yanader.new_music.service.StatisticsService;
import com.yanader.new_music.service.YearSetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticsServiceImpl implements StatisticsService {

    @Autowired
    private YearSetService yearSetService;
    @Autowired
    private AlbumService albumService;


    @Override
    public List<Integer> getDistinctListeningYears() {
        return yearSetService.getAllListeningYears();
    }

    @Override
    public List<Integer> getDistinctReleaseYears() {
        return yearSetService.getAllReleaseYears();
    }

    @Override
    public Statistics getStatistics() {

        return new Statistics(albumService.getAllAlbums(), getDistinctListeningYears());
    }
}
