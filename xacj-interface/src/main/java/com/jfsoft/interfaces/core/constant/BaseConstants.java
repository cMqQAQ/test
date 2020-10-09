package com.jfsoft.interfaces.core.constant;

/**
 * @author chenxc
 * @email 997909544@qq.com
 * @date 2020/3/31  14:34
 */
public final class BaseConstants {
    /**
     * 接口类型
     */
    public final static String INTERFACE_SERVER = "客户端";
    public final static String INTERFACE_CLIENT = "服务端";
    /**
     * 方法名
     */
    public final static String RETURN_RESULT = "获取申请单";
    public final static String RETURN_ORDER = "回传结果";

    /**
     * 操作
     */
    public final static String SUCCESS_MESSAGE = "操作成功";
    public final static String FAILURE_MESSAGE = "操作失败";

    /**
     * 参数格式
     */
    public final static String PARAMS_JSON = "json";
    public final static String PARAMS_XML = "xml";
    public final static String PARAMS_HL7 = "hl7";

    /**
     * 调用状态
     */
    public final static Integer STATUS_SUCCESS = 0;
    public final static Integer STATUS_FAILURE = 1;
    public final static Integer STATUS_OTHER = 2;

    /**
     * 请求方式
     */
    public final static String REQUEST_GET = "GET";
    public final static String REQUEST_POST = "POST";
    public final static String REQUEST_WEBSERVICE = "WebService";
    public final static String REQUEST_TCP = "TCP";

    public final static String WEBSERVICE_CLIENT_DEMO = "webservice客户端demo";
}
