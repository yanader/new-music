package com.yanader.new_music.controller;

import com.yanader.new_music.entity.Statistics;
import com.yanader.new_music.service.AlbumService;
import com.yanader.new_music.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stats")
public class StatsController {

    private final StatisticsService statsService;

    public StatsController(StatisticsService statsService) {
        this.statsService = statsService;
    }

    @GetMapping
    public Statistics getStats() {
        return statsService.getStatistics();
    }
}
