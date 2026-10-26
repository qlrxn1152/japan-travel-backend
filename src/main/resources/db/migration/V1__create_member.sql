CREATE TABLE member (
                        member_id BIGINT NOT NULL AUTO_INCREMENT,
                        username VARCHAR(20) NOT NULL,
                        password VARCHAR(255) NOT NULL,
                        member_grade ENUM('ADMIN', 'MEMBER') NOT NULL,

                        PRIMARY KEY (member_id),

                        CONSTRAINT UK_MEMBER_USERNAME
                            UNIQUE (username)
);