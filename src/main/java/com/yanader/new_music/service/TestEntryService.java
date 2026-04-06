package com.yanader.new_music.service;

import com.yanader.new_music.entity.TestEntry;

import java.util.List;

public interface TestEntryService {
    TestEntry createTestEntry(TestEntry testEntry);
    List<TestEntry> getAllTestEntries();
}