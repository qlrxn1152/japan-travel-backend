INSERT INTO destination (
    city_name,
    city_type,
    transport_level,
    cost_level,
    recommend_min_days,
    recommend_max_days
)
VALUES
    ('TOKYO', 'LARGE_CITY', 'EXCELLENT', 'HIGH', 3, 7),
    ('OSAKA', 'LARGE_CITY', 'EXCELLENT', 'MEDIUM', 3, 5),
    ('NAGOYA', 'LARGE_CITY', 'EXCELLENT', 'MEDIUM', 2, 4),
    ('KYOTO', 'LARGE_CITY', 'GOOD', 'MEDIUM', 2, 4),
    ('KANAZAWA', 'SMALL_CITY', 'GOOD', 'MEDIUM', 2, 4),
    ('YUFUIN', 'SMALL_CITY', 'GOOD', 'HIGH', 1, 2);