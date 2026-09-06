package com.yanader.new_music.service.impl;

import com.yanader.new_music.entity.dtos.AlbumDTO;
import com.yanader.new_music.repository.AlbumRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AlbumServiceImplTest {

    @Mock
    AlbumRepository mockRepository;

    @InjectMocks
    AlbumServiceImpl service;

    AlbumDTO album = new AlbumDTO("Joan of Arc", "A portable model of", null);

    @Test
    void shouldSaveAlbum(){
        assertNull(service.saveAlbum(album));
    }
}