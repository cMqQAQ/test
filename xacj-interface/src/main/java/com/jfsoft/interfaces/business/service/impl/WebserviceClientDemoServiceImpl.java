package com.jfsoft.interfaces.business.service.impl;

import com.jfsoft.interfaces.business.service.IWebserviceClientDemoService;
import com.jfsoft.interfaces.core.constant.BaseConstants;
import com.jfsoft.interfaces.core.entity.InterfaceLog;
import com.jfsoft.interfaces.core.manager.AsyncManager;
import com.jfsoft.interfaces.core.manager.factory.AsyncFactory;
import com.jfsoft.interfaces.webservice.client.DemoServiceImplService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.xml.namespace.QName;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;

@Service
public class WebserviceClientDemoServiceImpl implements IWebserviceClientDemoService {

    private static final QName SERVICE_NAME = new QName("http://service.business.interfaces.jfsoft.com/", "DemoServiceImplService");

    @Value("${app.webservice.url}")
    private String url;

    @Override
    public String webserviceClientDemo(String name) {
        String response = "";
        String requsetParam = null;
        String responseParam = null;

        // 记录日志
        InterfaceLog log = new InterfaceLog();
        log.setType(BaseConstants.INTERFACE_CLIENT);
        log.setMethod(BaseConstants.WEBSERVICE_CLIENT_DEMO);
        log.setRequestUrl(url);
        try {
            //调用服务的代码从IDemoService_DemoServiceImplPort_Client中复制
            URL wsdlURL = new URL(url);
            DemoServiceImplService ss = new DemoServiceImplService(wsdlURL, SERVICE_NAME);
            com.jfsoft.interfaces.webservice.client.IDemoService port = ss.getDemoServiceImplPort();

            //调用服务端的 String hello(String name) 方法
            requsetParam = name;
            responseParam = port.hello(requsetParam);
            response = responseParam;

            log.setStatus(BaseConstants.STATUS_SUCCESS);
            log.setMessage(BaseConstants.SUCCESS_MESSAGE);
        } catch (Exception e) {
            StringWriter stringWriter = new StringWriter();
            PrintWriter printWriter = new PrintWriter(stringWriter);
            e.printStackTrace(printWriter);
            log.setStatus(BaseConstants.STATUS_FAILURE);
            log.setMessage(BaseConstants.FAILURE_MESSAGE);
            log.setExceptionInfo(stringWriter.toString().substring(0, 2000));
        }
        log.setRequestParams(requsetParam);
        log.setResponseParams(responseParam);
        // 记录日志
        AsyncManager.me().execute(AsyncFactory.recordLog(log));
        return response;
    }
}
