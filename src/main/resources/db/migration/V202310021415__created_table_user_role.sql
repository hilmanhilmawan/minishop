CREATE TABLE `mini_shop`.`user_role`(
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `ref_id` VARCHAR(50),
    `role_name` VARCHAR(100),
    `creator_id` VARCHAR(75),
    `creator_time` DATETIME,
    `modifier_id` VARCHAR(75),
    `modifier_time` DATETIME,
    PRIMARY KEY (`id`)
);