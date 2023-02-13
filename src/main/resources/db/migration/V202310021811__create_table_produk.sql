CREATE TABLE `mini_shop`.`produk`(
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `refid` VARCHAR(50),
    `nama` VARCHAR(200),
    `harga` INT(11),
    `deskripsi` TEXT,
    `is_deleted` bit(1),
    `creator_id` BIGINT(20),
    `creator_time` DATETIME,
    `modifier_id` BIGINT(20),
    `modifier_time` DATETIME,
    PRIMARY KEY (`id`)
);