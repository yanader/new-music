package com.yanader.new_music.mapper;

import com.yanader.new_music.entity.Album;
import com.yanader.new_music.entity.Artist;
import com.yanader.new_music.entity.Contributor;
import com.yanader.new_music.entity.dtos.AlbumDTO;
import com.yanader.new_music.repository.ArtistRepository;
import com.yanader.new_music.repository.ContributorRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AlbumMapper {

    private final ArtistRepository artistRepo;
    private final ContributorRepository contributorRepo;

    public AlbumMapper(ArtistRepository artistRepo, ContributorRepository contributorRepo) {
        this.artistRepo = artistRepo;
        this.contributorRepo = contributorRepo;
    }

    public Album toAlbumEntity(AlbumDTO dto) {
        Album album = new Album();
        album.setName(dto.name());

        Artist artist = artistRepo.findByNameIgnoreCase(dto.artist())
                .orElseGet(() -> {
                    Artist newArtist = new Artist();
                    newArtist.setName(dto.artist());
                    return artistRepo.save(newArtist);
                });

        album.setArtist(artist);

        List<Contributor> contributors = dto.contributors() == null
                ? List.of()
                : dto.contributors().stream()
                .map(name -> contributorRepo.findByNameIgnoreCase(name)
                        .orElseGet(() -> {
                            Contributor newCont = new Contributor();
                            newCont.setName(name);
                            return contributorRepo.save(newCont);
                        }))
                .collect(Collectors.toList());

        album.setContributors(contributors);
        return album;
    }
}
