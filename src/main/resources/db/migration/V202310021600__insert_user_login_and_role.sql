INSERT INTO `mini_shop`.`user_login` (
    `ref_id`,
    `username`,
    `password`,
    `fullname`,
    `email`,
    `no_handphone`,
    `role_id`,
    `is_deleted`,
    `creator_id`,
    `creator_time`,
    `modifier_id`,
    `modifier_time`
)
VALUES
    (
        UUID(),
        'admin',
        '$2a$12$W4DGxBD/pOde3X05GXDYUOTPDqpcs2Vrjz2slVXD2NuoFRQKn5ryW',
        'Administrator',
        'administrator@mail.com',
        '08872222',
        1,
        'N',
        'admin',
        NOW(),
        'admin',
        NOW()
    ) ;


INSERT INTO `mini_shop`.`user_login` (
    `ref_id`,
    `username`,
    `password`,
    `fullname`,
    `email`,
    `no_handphone`,
    `role_id`,
    `is_deleted`,
    `creator_id`,
    `creator_time`,
    `modifier_id`,
    `modifier_time`
)
VALUES
    (
        UUID(),
        'user',
        '$2a$10$W7QhRBpYEDPiHeyYsaGIouy1DLDzq4ksxPPkl/OmRkIs0f9P46TtW',
        'Requestor',
        'requestor@mail.com',
        '08898333',
        2,
        'N',
        'admin',
        NOW(),
        'admin',
        NOW()
    ) ;

