CREATE TABLE `mini_shop`.`keranjang`(
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `refid` VARCHAR(50),
    `produk_id` BIGINT(20),
    `user_id` BIGINT(20),
    `qty` INT(11),
    `creator_id` VARCHAR(75),
    `creator_time` DATETIME,
    `modifier_id` VARCHAR(75),
    `modifier_time` DATETIME,
    PRIMARY KEY (`id`)
);