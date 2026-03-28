CREATE TABLE contributors (
                              id      BIGSERIAL PRIMARY KEY,
                              name    VARCHAR(255) NOT NULL,
                              alias   VARCHAR(255)
);

CREATE TABLE artists (
                         id                BIGSERIAL PRIMARY KEY,
                         name              VARCHAR(255) NOT NULL,
                         spotify_artist_id VARCHAR(255)
);

CREATE TABLE year_sets (
                           id             BIGSERIAL PRIMARY KEY,
                           listening_year SMALLINT NOT NULL,
                           release_year   SMALLINT NOT NULL,
                           CONSTRAINT uq_year_set UNIQUE (listening_year, release_year)
);

CREATE TABLE albums (
                        id               BIGSERIAL PRIMARY KEY,
                        artist_id        BIGINT NOT NULL REFERENCES artists(id),
                        set_id           BIGINT NOT NULL REFERENCES year_sets(id),
                        rating           SMALLINT CHECK (rating >= 1 AND rating <= 10),
                        notes            TEXT,
                        listened_on      DATE,
                        spotify_album_id VARCHAR(255)
);

CREATE TABLE suggestions (
                             id             BIGSERIAL PRIMARY KEY,
                             contributor_id BIGINT NOT NULL REFERENCES contributors(id),
                             album_id       BIGINT NOT NULL REFERENCES albums(id),
                             CONSTRAINT uq_suggestion UNIQUE (contributor_id, album_id)
);