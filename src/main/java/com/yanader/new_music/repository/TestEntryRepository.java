package com.yanader.new_music.repository;

import com.yanader.new_music.entity.TestEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestEntryRepository extends JpaRepository<TestEntry, Long> {
}