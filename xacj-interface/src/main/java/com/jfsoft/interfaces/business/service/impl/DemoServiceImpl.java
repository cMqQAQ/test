package com.jfsoft.interfaces.business.service.impl;

import com.jfsoft.interfaces.business.service.IDemoService;
import org.springframework.stereotype.Service;

import javax.jws.WebService;

/**
 * @author chenxc
 * @email 997909544@qq.com
 * @date 2020/3/30  13:40
 */
@WebService(targetNamespace = "http://service.business.interfaces.jfsoft.com/"// 与接口中的命名空间一致,一般是接口的包名倒
        , endpointInterface = "com.jfsoft.interfaces.business.service.IDemoService"// 接口地址
)
@Service
public class DemoServiceImpl implements IDemoService {

    /**
     * say hello
     *
     * @param name
     * @return
     */
    @Override
    public String hello(String name) {
        return "Hello " + name;
    }
}
