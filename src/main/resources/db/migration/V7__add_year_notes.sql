ALTER TABLE year_sets ADD COLUMN notes VARCHAR(255);

UPDATE year_sets
SET notes = 'This was the first year I did it and I really enjoyed it so I''m doing it every year'
WHERE listening_year = 2024;

UPDATE year_sets
SET notes = 'I started with Pic Records top 100 and it was far too much so from now on it''s Pitchfork 50 + recs from friends'
WHERE listening_year = 2025;
