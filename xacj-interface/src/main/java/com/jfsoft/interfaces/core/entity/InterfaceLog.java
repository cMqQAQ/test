package com.jfsoft.interfaces.core.entity;

import com.baomidou.mybatisplus.annotation.IdType;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

import com.jfsoft.interfaces.config.GlobalConfig;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 接口日志表
 * </p>
 *
 * @author chenxc
 * @since 2020-03-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value = "InterfaceLog对象", description = "接口日志表")
public class InterfaceLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.UUID)
    private String id;

    @ApiModelProperty(value = "接口类型（客户端、服务器）")
    private String type;

    @ApiModelProperty(value = "方法名（申请单、回传结果等）")
    private String method;

    @ApiModelProperty(value = "0：成功；1：失败；2：其他")
    private Integer status;

    @ApiModelProperty(value = "提示信息")
    private String message;

    @ApiModelProperty(value = "详细报错信息")
    private String exceptionInfo;

    @ApiModelProperty(value = "接口地址")
    private String requestUrl;

    @ApiModelProperty(value = "入参")
    private String requestParams;

    @ApiModelProperty(value = "出参")
    private String responseParams;

    @ApiModelProperty(value = "执行时间")
    private Date executionTime;

    @ApiModelProperty(value = "模块编号")
    private Integer moduleCode = GlobalConfig.MODULE_CODE;

    @ApiModelProperty(value = "参数格式")
    private String paramsType;

    @ApiModelProperty(value = "请求方式")
    private String requestType;
}
