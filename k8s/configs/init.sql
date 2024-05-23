CREATE SCHEMA IF NOT EXISTS `halmang` DEFAULT CHARACTER SET utf8mb4;

GRANT ALL ON *.* TO 'root'@'localhost' IDENTIFIED BY 'root' WITH GRANT OPTION;
GRANT ALL ON halmang.* TO 'root'@'localhost';
FLUSH PRIVILEGES;

USE `halmang`;

-- 기존 테이블 삭제
DROP TABLE IF EXISTS `member_stamp`;
DROP TABLE IF EXISTS `member`;
DROP TABLE IF EXISTS `stamp`;

-- Member 테이블 생성
CREATE TABLE `member` (
    `member_id` BIGINT NOT NULL AUTO_INCREMENT,
    PRIMARY KEY (`member_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- Stamp 테이블 생성
CREATE TABLE `stamp` (
    `stamp_id` BIGINT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(255) NOT NULL,
    PRIMARY KEY (`stamp_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- 연관 테이블 생성 (Many-to-Many 관계)
CREATE TABLE `member_stamp` (
    `member_id` BIGINT NOT NULL,
    `stamp_id` BIGINT NOT NULL,
    PRIMARY KEY (`member_id`, `stamp_id`),
    FOREIGN KEY (`member_id`) REFERENCES `member`(`member_id`) ON DELETE CASCADE,
    FOREIGN KEY (`stamp_id`) REFERENCES `stamp`(`stamp_id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- 샘플 데이터 삽입 (필요한 경우 추가)
INSERT INTO `stamp` (`name`) VALUES ('Sample Stamp 1'), ('Sample Stamp 2');

INSERT INTO `member` VALUES ();  -- 기본 값 삽입
INSERT INTO `member_stamp` (`member_id`, `stamp_id`) VALUES (1, 1), (1, 2);