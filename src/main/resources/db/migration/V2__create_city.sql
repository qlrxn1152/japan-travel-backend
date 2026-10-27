CREATE TABLE city (
                      city_id BIGINT NOT NULL AUTO_INCREMENT,
                      city_name VARCHAR(100) NOT NULL,
                      recommend_min_days INT NOT NULL,
                      recommend_max_days INT NOT NULL,
                      city_type ENUM('LARGE_CITY', 'SMALL_CITY') NOT NULL,

                      PRIMARY KEY (city_id),

                      CONSTRAINT UK_CITY_NAME
                          UNIQUE (city_name),

                      CONSTRAINT CK_CITY_RECOMMEND_DAYS
                          CHECK (
                              recommend_min_days >= 1
                                  AND recommend_max_days >= recommend_min_days
                              )
);