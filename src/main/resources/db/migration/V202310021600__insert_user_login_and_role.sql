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
        1,
        NOW(),
        1,
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
        1,
        NOW(),
        1,
        NOW()
    ) ;


INSERT INTO `mini_shop`.`user_role` (
    `ref_id`,
    `role_name`,
    `creator_id`,
    `creator_time`,
    `modifier_id`,
    `modifier_time`
)
VALUES
    (
        UUID(),
        'Administrator',
        1,
        NOW(),
        1,
        NOW()
    ) ;

INSERT INTO `mini_shop`.`user_role` (
    `ref_id`,
    `role_name`,
    `creator_id`,
    `creator_time`,
    `modifier_id`,
    `modifier_time`
)
VALUES
    (
        UUID(),
        'User',
        1,
        NOW(),
        1,
        NOW()
    ) ;
