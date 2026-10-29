CREATE TABLE city (
                      city_id BIGINT NOT NULL AUTO_INCREMENT,
                      city_name VARCHAR(100) NOT NULL,
                      recommend_trip_days INT NOT NULL,
                      city_type ENUM('LARGE_CITY', 'SMALL_CITY') NOT NULL,

                      PRIMARY KEY (city_id),

                      CONSTRAINT UK_CITY_NAME
                          UNIQUE (city_name),

                      CONSTRAINT CK_CITY_RECOMMEND_TRIP_DAYS
                          CHECK (
                              recommend_trip_days >= 1
                              )
);