package com.yanader.new_music.entity.dtos;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record RateAlbumRequestDTO(

        @NotNull(message = "Rating is required")
        @Min(value = 1, message = "Rating must be at least 1")
        @Max(value = 10, message = "Rating must be no more than 10")
        Integer rating,

        @Size(max = 1000, message = "Notes must be 1000 characters or fewer")
        String notes

) {}