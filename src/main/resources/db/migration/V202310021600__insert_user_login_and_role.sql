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
        '4acb4bc224acbbe3c2bfdcaa39a4324e',
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
        'f67c683f0f3e98cb9dd5582e8cbbcd04',
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
