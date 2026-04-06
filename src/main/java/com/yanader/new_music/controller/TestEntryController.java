package com.yanader.new_music.controller;

import com.yanader.new_music.entity.TestEntry;
import com.yanader.new_music.service.TestEntryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestEntryController {

    private final TestEntryService testEntryService;

    public TestEntryController(TestEntryService testEntryService) {
        this.testEntryService = testEntryService;
    }

    @GetMapping
    public List<TestEntry> getAllTestEntries() {
        return testEntryService.getAllTestEntries();
    }

    @PostMapping
    public TestEntry createTestEntry(@RequestBody TestEntry testEntry) {
        return testEntryService.createTestEntry(testEntry);
    }
}