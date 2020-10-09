package com.jfsoft.interfaces.business.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author chenxc
 * @since 2020-09-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("PatientBase")
@ApiModel(value="PatientBase对象", description="")
public class PatientBase implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "Id", type = IdType.AUTO)
    private Integer Id;

    @TableField("HID")
    private Integer hid;

    @TableField("PID")
    private String pid;

    @TableField("Name")
    private String Name;

    @TableField("Age")
    private String Age;

    @TableField("AuCode")
    private Integer AuCode;

    @TableField("Sex")
    private String Sex;

    @TableField("BedNum")
    private String BedNum;

    @TableField("Department")
    private Integer Department;

    @TableField("Doctor")
    private Integer Doctor;

    @TableField("Sfname")
    private String Sfname;

    @TableField("Sfcode")
    private Integer Sfcode;

    @TableField("Sfmoney")
    private BigDecimal Sfmoney;

    @TableField("Sftime")
    private Date Sftime;

    @TableField("SfDate")
    private String SfDate;

    private String fph;

    @TableField("Lczd")
    private String Lczd;

    @TableField("Barcode")
    private String Barcode;

    @TableField("Pattype")
    private Integer Pattype;

    @TableField("HisID")
    private String HisID;

    @TableField("PyCode")
    private String PyCode;

    @TableField("TestTypeCode")
    private Integer TestTypeCode;

    @TableField("feeMark")
    private Integer feeMark;

    @TableField("PatInfoID")
    private Integer PatInfoID;

    @TableField("InputCode")
    private Integer InputCode;

    private Boolean backflag;

    @TableField("Sampletime")
    private Date Sampletime;

    @TableField("BarCodetime")
    private Date BarCodetime;

    @TableField("SampleUser")
    private String SampleUser;

    @TableField("BarCodeUser")
    private String BarCodeUser;

    @TableField("SampleState")
    private String SampleState;

    private String caseid;

    @TableField("Drugmemo")
    private String Drugmemo;

    @TableField("Ordersmemo")
    private String Ordersmemo;

    @TableField("Samplesource")
    private String Samplesource;

    @TableField("rejectOpt")
    private Integer rejectOpt;

    private Date rejecttime;

    private String sampletype;

    private String reciveplace;

    @TableField("SamplePosition")
    private String SamplePosition;

    @TableField("SecurityLevel")
    private String SecurityLevel;

    @TableField("Phonenumber")
    private String Phonenumber;

    @TableField("BirthDate")
    private Date BirthDate;

    @TableField("IdCardNumber")
    private String IdCardNumber;

    @TableField("Company")
    private String Company;

    @TableField("HospitalTimes")
    private Integer HospitalTimes;

    @TableField("PrintBarcodeTime")
    private Date PrintBarcodeTime;

    @TableField("PrintBarcodeUser")
    private String PrintBarcodeUser;

    @TableField("ReciveUser")
    private String ReciveUser;

    @TableField("ReciveTime")
    private Date ReciveTime;

    @TableField("Infectious")
    private Boolean Infectious;

    @TableField("TrafficUser")
    private String TrafficUser;

    @TableField("TrafficTime")
    private Date TrafficTime;

    @TableField("Hisinterface_ID")
    private String hisinterfaceId;

    @TableField("sampleDes")
    private String sampleDes;

    private Date confirmtime;

    private String confirmuser;

    private String checkuser;

    @TableField("PresetCode")
    private String PresetCode;

    @TableField("ReceiptID")
    private Integer ReceiptID;

    @TableField("BarcodeUserCode")
    private String BarcodeUserCode;

    @TableField("confirmuserCode")
    private String confirmuserCode;

    @TableField("SampleUserCode")
    private String SampleUserCode;

    @TableField("trafficUserCode")
    private String trafficUserCode;

    private String barcodechecker;

    private String identity1;


}
