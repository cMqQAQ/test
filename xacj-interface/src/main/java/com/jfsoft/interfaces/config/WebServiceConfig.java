package com.jfsoft.interfaces.config;

import com.jfsoft.interfaces.business.service.IDemoService;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

@Configuration
public class WebServiceConfig {

    @Autowired
    private IDemoService demoService;


    @Autowired
    private Bus bus;

    @Bean
    public Endpoint endpoint() {
        // 绑定要发布的服务
        EndpointImpl demoPoint = new EndpointImpl(bus, demoService);
        // 显示要发布的名称
        demoPoint.publish("/demo");

        return demoPoint;
    }
}
