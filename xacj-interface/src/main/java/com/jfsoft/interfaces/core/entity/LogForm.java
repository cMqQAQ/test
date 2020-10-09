package com.jfsoft.interfaces.core.entity;

import lombok.Data;

/**
 * @author chenxc
 * @email 997909544@qq.com
 * @date 2020/4/1  18:30
 */
@Data
public class LogForm {
    private Integer index;
    private Integer size;
    private Integer status;
    private String beginTime;
    private String endTime;
    private String reqStr;
    private String rspStr;
}
