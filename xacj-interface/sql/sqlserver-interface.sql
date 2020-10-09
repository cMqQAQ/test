-- ----------------------------
-- 1、定时任务表
-- ----------------------------
create table interface_scheduled_task
(
    id              int identity,
    task_key        varchar(128),
    task_desc       varchar(128),
    task_cron       varchar(128),
    init_start_flag bit,
    create_time     datetime default getdate(),
    module_code     int
)
go

exec sp_addextendedproperty 'MS_Description', '任务key值（使用bean名称）', 'SCHEMA', 'dbo', 'TABLE', 'interface_scheduled_task',
     'COLUMN', 'task_key'
go

exec sp_addextendedproperty 'MS_Description', '任务描述', 'SCHEMA', 'dbo', 'TABLE', 'interface_scheduled_task', 'COLUMN',
     'task_desc'
go

exec sp_addextendedproperty 'MS_Description', '任务表达式', 'SCHEMA', 'dbo', 'TABLE', 'interface_scheduled_task', 'COLUMN',
     'task_cron'
go

exec sp_addextendedproperty 'MS_Description', '程序初始化是否启动 1 是 0 否', 'SCHEMA', 'dbo', 'TABLE', 'interface_scheduled_task',
     'COLUMN', 'init_start_flag'
go

exec sp_addextendedproperty 'MS_Description', '创建时间', 'SCHEMA', 'dbo', 'TABLE', 'interface_scheduled_task', 'COLUMN',
     'create_time'
go

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
create table interface_log
(
    id              varchar(128)
        constraint interface_log_pk
            primary key nonclustered,
    type            varchar(20),
    method          varchar(50),
    status          int,
    message         varchar(100),
    exception_info  text,
    request_url     varchar(200),
    request_params  text,
    response_params text,
    execution_time  datetime default getdate(),
    module_code     int,
    params_type     varchar(10),
    request_type    varchar(10)
)
go

exec sp_addextendedproperty 'MS_Description', '接口日志表', 'SCHEMA', 'dbo', 'TABLE', 'interface_log'
go

exec sp_addextendedproperty 'MS_Description', '接口类型（客户端、服务器）', 'SCHEMA', 'dbo', 'TABLE', 'interface_log', 'COLUMN',
     'type'
go

exec sp_addextendedproperty 'MS_Description', '方法名（申请单、回传结果等）', 'SCHEMA', 'dbo', 'TABLE', 'interface_log', 'COLUMN',
     'method'
go

exec sp_addextendedproperty 'MS_Description', '0：成功；1：失败；2：其他', 'SCHEMA', 'dbo', 'TABLE', 'interface_log', 'COLUMN',
     'status'
go

exec sp_addextendedproperty 'MS_Description', '提示信息', 'SCHEMA', 'dbo', 'TABLE', 'interface_log', 'COLUMN', 'message'
go

exec sp_addextendedproperty 'MS_Description', '详细报错信息', 'SCHEMA', 'dbo', 'TABLE', 'interface_log', 'COLUMN',
     'exception_info'
go

exec sp_addextendedproperty 'MS_Description', '接口地址', 'SCHEMA', 'dbo', 'TABLE', 'interface_log', 'COLUMN', 'request_url'
go

exec sp_addextendedproperty 'MS_Description', '入参', 'SCHEMA', 'dbo', 'TABLE', 'interface_log', 'COLUMN',
     'request_params'
go

exec sp_addextendedproperty 'MS_Description', '出参', 'SCHEMA', 'dbo', 'TABLE', 'interface_log', 'COLUMN',
     'response_params'
go

exec sp_addextendedproperty 'MS_Description', '执行时间', 'SCHEMA', 'dbo', 'TABLE', 'interface_log', 'COLUMN',
     'execution_time'
go

exec sp_addextendedproperty 'MS_Description', '模块编号', 'SCHEMA', 'dbo', 'TABLE', 'interface_log', 'COLUMN', 'module_code'
go

exec sp_addextendedproperty 'MS_Description', '参数格式', 'SCHEMA', 'dbo', 'TABLE', 'interface_log', 'COLUMN', 'params_type'
go

