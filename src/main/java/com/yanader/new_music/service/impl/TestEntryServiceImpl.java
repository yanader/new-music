package com.yanader.new_music.service.impl;

import com.yanader.new_music.entity.TestEntry;
import com.yanader.new_music.repository.TestEntryRepository;
import com.yanader.new_music.service.TestEntryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestEntryServiceImpl implements TestEntryService {

    private final TestEntryRepository testEntryRepository;

    public TestEntryServiceImpl(TestEntryRepository testEntryRepository) {
        this.testEntryRepository = testEntryRepository;
    }

    @Override
    public TestEntry createTestEntry(TestEntry testEntry) {
        return testEntryRepository.save(testEntry);
    }

    @Override
    public List<TestEntry> getAllTestEntries() {
        return testEntryRepository.findAll();
    }
}