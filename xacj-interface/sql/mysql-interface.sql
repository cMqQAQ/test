-- ----------------------------
-- 1、定时任务表
-- ----------------------------
drop table if exists interface_scheduled_task;
create table interface_scheduled_task
(
    id              int auto_increment,
    task_key        varchar(128)                         null comment '任务key值（使用bean名称）',
    task_desc       varchar(128)                         null comment '任务描述',
    task_cron       varchar(128)                         null comment '任务表达式',
    init_start_flag bit      default b'1'                null comment '程序初始化是否启动 1 是 0 否',
    create_time     datetime default current_timestamp() null comment '创建时间',
    module_code     int                                  null comment 'module_code',
    primary key (id)
) engine = innodb
  auto_increment = 2000 comment = '定时任务表';

-- ----------------------------
-- 初始化定时任务表数据
-- ----------------------------
insert into interface_scheduled_task (task_key, task_desc, task_cron, init_start_flag, module_code)
values ('DemoTask', '测试任务', '0/30 * * * * ?', 1, 999);
insert into interface_scheduled_task (task_key, task_desc, task_cron, init_start_flag, module_code)
values ('ClearLogTask', '日志清除任务', '0 0 0-12 * * ?', 1, 999);

-- ----------------------------
-- 2、接口日志表
-- ----------------------------
drop table if exists interface_log;
create table interface_log
(
    id              varchar(128)                         not null comment 'uuid',
    type            varchar(20)                          null comment '接口类型（客户端、服务器）',
    method          varchar(50)                          null comment '方法名（申请单、回传结果等）',
    status          int                                  null comment '0：成功；1：失败；2：其他',
    message         varchar(100)                         null comment '提示信息',
    exception_info  text                                 null comment '详细报错信息',
    request_url     varchar(100)                         null comment '接口地址',
    request_params  text                                 null comment '入参',
    response_params text                                 null comment '出参',
    execution_time  datetime default current_timestamp() null comment '执行时间',
    module_code     int                                  null comment '模块编号',
    params_type     varchar(100)                         null comment '参数格式',
    request_type    varchar(100)                         null comment '请求类型',
    primary key (id)
) engine = innodb
  auto_increment = 2000 comment = '接口日志表';
