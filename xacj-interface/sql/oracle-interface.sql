-- ----------------------------
-- 1、定时任务表
-- ----------------------------
create table INTERFACE_SCHEDULED_TASK
(
    ID              NUMBER not null
        constraint SYS_C0014143
            primary key,
    TASK_KEY        VARCHAR2(128 char),
    TASK_DESC       VARCHAR2(128 char),
    TASK_CRON       VARCHAR2(128 char),
    INIT_START_FLAG NUMBER,
    CREATE_TIME     DATE default sysdate,
    MODULE_CODE     NUMBER
)

comment on column INTERFACE_SCHEDULED_TASK.TASK_KEY is '任务key值(使用bean名称)'

comment on column INTERFACE_SCHEDULED_TASK.TASK_DESC is '任务描述'

comment on column INTERFACE_SCHEDULED_TASK.TASK_CRON is '任务表达式'

comment on column INTERFACE_SCHEDULED_TASK.INIT_START_FLAG is '程序初始化是否启动 1 是 0 否'

comment on column INTERFACE_SCHEDULED_TASK.CREATE_TIME is '创建时间'
-- ----------------------------
-- 初始化定时任务表数据
-- ----------------------------
INSERT INTO INTERFACE_SCHEDULED_TASK
VALUES ('1', 'DemoTask', '测试任务', '0/30 * * * * ?', '1', TO_DATE('2020-04-15 13:36:27', 'SYYYY-MM-DD HH24:MI:SS'),
        '999');
INSERT INTO INTERFACE_SCHEDULED_TASK
VALUES ('2', 'ClearLogTask', '日志清除任务', '0 0 0-12 * * ?', '1', TO_DATE('2020-04-15 13:40:58', 'SYYYY-MM-DD HH24:MI:SS'),
        '999');
INSERT INTO INTERFACE_SCHEDULED_TASK
VALUES ('3', 'DictTask', '获取平台字典', '0 0/1 * * * ?', '1', TO_DATE('2020-04-15 16:26:04', 'SYYYY-MM-DD HH24:MI:SS'),
        '999');
INSERT INTO INTERFACE_SCHEDULED_TASK
VALUES ('4', 'ReportTask', '上传报告结果', '0 0/4 * * * ?', '0', TO_DATE('2020-04-15 16:43:15', 'SYYYY-MM-DD HH24:MI:SS'),
        '999');
INSERT INTO INTERFACE_SCHEDULED_TASK
VALUES ('5', 'OrderTask', '获取申请单', '0 0/2 * * * ?', '0', TO_DATE('2020-04-15 18:06:24', 'SYYYY-MM-DD HH24:MI:SS'),
        '999');


-- ----------------------------
-- 2、接口日志表
-- ----------------------------
create table INTERFACE_LOG
(
    ID              VARCHAR2(50) not null
        primary key,
    TYPE            VARCHAR2(20),
    METHOD          VARCHAR2(30 char),
    STATUS          NUMBER,
    MESSAGE         VARCHAR2(100 char),
    EXCEPTION_INFO  CLOB,
    REQUEST_URL     VARCHAR2(200 char),
    REQUEST_PARAMS  CLOB,
    RESPONSE_PARAMS CLOB,
    EXECUTION_TIME  DATE default sysdate,
    MODULE_CODE     NUMBER,
    PARAMS_TYPE     VARCHAR2(10 char),
    REQUEST_TYPE    VARCHAR2(10 char)
)

comment on column INTERFACE_LOG.TYPE is '接口类型（客户端、服务器）'

comment on column INTERFACE_LOG.METHOD is '方法名（申请单、回传结果等）'

comment on column INTERFACE_LOG.STATUS is '0：成功；1：失败；2：其他'

comment on column INTERFACE_LOG.MESSAGE is '提示信息'

comment on column INTERFACE_LOG.EXCEPTION_INFO is '详细报错信息'

comment on column INTERFACE_LOG.REQUEST_URL is '接口地址'

comment on column INTERFACE_LOG.REQUEST_PARAMS is '入参'

comment on column INTERFACE_LOG.RESPONSE_PARAMS is '出参'

comment on column INTERFACE_LOG.EXECUTION_TIME is '执行时间'

comment on column INTERFACE_LOG.MODULE_CODE is '模块编号'

comment on column INTERFACE_LOG.PARAMS_TYPE is '参数格式'


