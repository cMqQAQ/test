package com.jfsoft.interfaces.business.entity;

import lombok.Data;

import java.io.Serializable;

public class QRCode implements Serializable {
    /**
     * 姓名
     */
    private String n;

    /**
     * 存济卡号
     */
    private String c;

    /**
     * 身份证号
     */
    private String p;

    /**
     * 就诊卡号
     */
    private String m;

    /**
     * 医保类型
     */
    private Short t;

    /**
     * 订单号
     */
    private String d;

    public String getN() {
        return n;
    }

    public String getC() {
        return c;
    }

    public String getP() {
        return p;
    }

    public String getM() {
        return m;
    }

    public Short getT() {
        return t;
    }

    public String getD() {
        return d;
    }

    public void setN(String n){
        this.n = n;
    }
    public void setC(String c){
        this.c = c;
    }
    public void setP(String p){
        this.p = p;
    }
    public void setM(String m){
        this.m = m;
    }
    public void setT(short t){
        this.t = t;
    }
    public void setD(String d){
        this.d = d;
    }

    @Override
    public String toString() {
        return "{" +
                "n='" + n + '\'' +
                ", c='" + c + '\'' +
                ", p='" + p + '\'' +
                ", m='" + m + '\'' +
                ", t=" + t +
                ", d='" + d + '\'' +
                '}';
    }
}
