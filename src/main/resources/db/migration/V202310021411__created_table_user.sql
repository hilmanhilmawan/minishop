CREATE TABLE `mini_shop`.`user_login`(
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `ref_id` VARCHAR(50),
    `username` VARCHAR(70),
    `password` VARCHAR(100),
    `fullname` VARCHAR(200),
    `email` VARCHAR(150),
    `no_handphone` VARCHAR(20),
    `role_id` BIGINT(20),
    `is_deleted` CHAR(1) DEFAULT 'N',
    `creator_id` VARCHAR(75),
    `creator_time` DATETIME,
    `modifier_id` VARCHAR(75),
    `modifier_time` DATETIME,
    PRIMARY KEY (`id`),
    UNIQUE INDEX `username` (`username`)
);