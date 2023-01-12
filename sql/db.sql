use fanta;


-- 接口信息
create table if not exists fanta.`interface_info`
(
    `id`              bigint                             not null auto_increment comment '主键' primary key,
    `name`            varchar(50)                        not null comment '名称',
    `description`     varchar(100)                       null comment '描述',
    `request_url`     varchar(512)                       not null comment '接口地址',
    `request_params`  text                               not null comment '请求参数',
    `request_header`  text                               null comment '请求头',
    `response_header` text                               null comment '响应头',
    `status`          int      default 0                 not null comment '接口状态（0-关闭，1-开启）',
    `method`          varchar(10)                        not null comment '请求类型',
    `create_by`       bigint                             not null comment '创建人',
    `create_time`     datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    `update_time`     datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    `is_delete`       tinyint  default 0                 not null comment '是否删除(0-未删, 1-已删)'
) comment '接口信息';


-- 用户调用接口关系表
create table if not exists fanta.`user_interface_info`
(
    `id`              bigint                             not null auto_increment comment '主键' primary key,
    `userId`          bigint                             not null comment '调用用户 id',
    `interfaceInfoId` bigint                             not null comment '接口 id',
    `totalNum`        int      default 0                 not null comment '总调用次数',
    `leftNum`         int      default 0                 not null comment '剩余调用次数',
    `status`          int      default 0                 not null comment '0-正常，1-禁用',
    `createTime`      datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    `updateTime`      datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    `isDelete`        tinyint  default 0                 not null comment '是否删除(0-未删, 1-已删)'
) comment '用户调用接口关系';