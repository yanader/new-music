package com.yanader.new_music.service.impl;

import com.yanader.new_music.repository.YearSetRepository;
import com.yanader.new_music.service.YearSetService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YearSetServiceImpl implements YearSetService {

    private final YearSetRepository yearSetRepository;

    public YearSetServiceImpl(YearSetRepository yearSetRepository) {
        this.yearSetRepository = yearSetRepository;
    }

    @Override
    public List<Integer> getAllListeningYears() {
        return yearSetRepository.findAllDistinctListeningYears();
    }

    @Override
    public List<Integer> getAllReleaseYears() {
        return yearSetRepository.findAllDistinctReleaseYears();
    }
}
