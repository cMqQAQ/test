package com.jfsoft.interfaces.http;

import com.jfsoft.interfaces.business.service.IDemoService;
import com.jfsoft.interfaces.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenxc
 * @email 997909544@qq.com
 * @date 2020/3/30  13:43
 */
@RestController
public class DemoController {

    @Autowired
    private IDemoService demoService;

    @GetMapping("/hello")
    public R hello(String name) {
        String hello = demoService.hello(name);
        return R.ok(hello);
    }
}
