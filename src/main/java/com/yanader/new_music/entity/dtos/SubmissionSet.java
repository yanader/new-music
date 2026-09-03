package com.yanader.new_music.entity.dtos;

import java.util.List;

public record SubmissionSet(
   List<AlbumDTO> albums,
   Integer listeningYear
) {}
