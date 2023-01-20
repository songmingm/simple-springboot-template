-- 创建库
create database if not exists fanta;

-- 切换库
use fanta;

-- 用户表
create table if not exists sys_user
(
    id            bigint auto_increment comment 'id' primary key,
    username      varchar(50)                            null comment '用户昵称',
    user_account  varchar(50)                            not null comment '账号',
    user_avatar   varchar(1024)                          null comment '用户头像',
    user_gender   tinyint                                null comment '性别',
    user_role     varchar(256) default 'user'            not null comment '用户角色：user / admin',
    user_password varchar(512)                           not null comment '密码',
    user_status   int          default 0                 not null comment '用户状态',
    create_time   datetime     default CURRENT_TIMESTAMP not null comment '创建时间',
    update_time   datetime     default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    is_delete     tinyint      default 0                 not null comment '是否删除',
    constraint uni_userAccount
        unique (user_account)
) comment '用户表';
