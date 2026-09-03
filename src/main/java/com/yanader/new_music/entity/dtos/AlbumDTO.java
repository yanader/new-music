package com.yanader.new_music.entity.dtos;

import java.util.List;

public record AlbumDTO(
       String artist,
       String name,
       List<String> contributors
) {}
