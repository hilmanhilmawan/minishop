CREATE TABLE `mini_shop`.`order_header`(
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `refid` VARCHAR(50),
    `user_id` BIGINT(20),
    `nama` VARCHAR(200),
    `no_telepon` INT(15),
    `alamat` TEXT,
    `subtotal` DOUBLE(18,2),
    `payment_type` ENUM('COD') DEFAULT 'COD',
    `status` TINYINT(4),
    `creator_id` VARCHAR(75),
    `creator_time` DATETIME,
    `modifier_id` VARCHAR(75),
    `modifier_time` DATETIME,
    PRIMARY KEY (`id`)
);

CREATE TABLE `mini_shop`.`order_detail`(
    `id` BIGINT(20) NOT NULL AUTO_INCREMENT,
    `refid` VARCHAR(50),
    `order_hdr_id` BIGINT(20),
    `produk_id` BIGINT(20),
    `harga` DOUBLE(18,2),
    `qty` INT(11),
    `creator_id` VARCHAR(75),
    `creator_time` DATETIME,
    `modifier_id` VARCHAR(75),
    `modifier_time` DATETIME,
    PRIMARY KEY (`id`)
);