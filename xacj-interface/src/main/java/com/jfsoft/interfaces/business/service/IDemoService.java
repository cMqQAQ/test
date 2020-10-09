package com.jfsoft.interfaces.business.service;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 * @author chenxc
 * @email 997909544@qq.com
 * @date 2020/3/30  13:39
 */
@WebService
public interface IDemoService {

    /**
     * say hello
     *
     * @param name
     * @return
     */
    @WebMethod
    public String hello(String name);
}
