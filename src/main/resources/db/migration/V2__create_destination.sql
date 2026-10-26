CREATE TABLE destination (
                             destination_id BIGINT NOT NULL AUTO_INCREMENT,

                             city_name ENUM(
    'TOKYO',
    'OSAKA',
    'NAGOYA',
    'KYOTO',
    'KANAZAWA',
    'YUFUIN'
) NOT NULL,

                             city_type ENUM(
        'LARGE_CITY',
        'SMALL_CITY'
    ) NOT NULL,

                             transport_level ENUM(
        'EXCELLENT',
        'GOOD',
        'NORMAL',
        'POOR'
    ) NOT NULL,

                             cost_level ENUM(
        'LOW',
        'MEDIUM',
        'HIGH'
    ) NOT NULL,

                             recommend_min_days INT NOT NULL,
                             recommend_max_days INT NOT NULL,

                             PRIMARY KEY (destination_id),

                             CONSTRAINT uq_destination_city_name
                                 UNIQUE (city_name)
);