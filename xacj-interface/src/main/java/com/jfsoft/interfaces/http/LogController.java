package com.jfsoft.interfaces.http;

import com.jfsoft.interfaces.core.constant.BaseConstants;
import com.jfsoft.interfaces.core.entity.InterfaceLog;
import com.jfsoft.interfaces.core.entity.LogForm;
import com.jfsoft.interfaces.core.service.IInterfaceLogService;
import com.jfsoft.interfaces.utils.ParamUtil;
import com.jfsoft.interfaces.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author chenxc
 * @email 997909544@qq.com
 * @date 2020/4/1  17:54
 */
@RestController()
@RequestMapping("/log")
public class LogController {

    @Autowired
    IInterfaceLogService iInterfaceLogService;

    @RequestMapping("/list")
    public R list(@RequestBody LogForm log) {
        List<InterfaceLog> list = iInterfaceLogService.list(log);
        list.forEach(item -> {
            if (item.getParamsType().equals(BaseConstants.PARAMS_XML)) {
                item.setRequestParams(ParamUtil.formatXml(item.getRequestParams()));
                item.setResponseParams(ParamUtil.formatXml(item.getResponseParams()));
            }
            if (item.getParamsType().equals(BaseConstants.PARAMS_JSON)) {
                item.setRequestParams(ParamUtil.formatJson(item.getRequestParams()));
                item.setResponseParams(ParamUtil.formatJson(item.getResponseParams()));
            }
        });
        Integer count = iInterfaceLogService.count(log);
        return R.ok().put("data", list).put("count", count);
    }
}
