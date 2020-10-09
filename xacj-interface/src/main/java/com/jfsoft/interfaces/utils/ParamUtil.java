package com.jfsoft.interfaces.utils;


import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.Writer;

/**
 * @author chenxc
 * @email 997909544@qq.com
 * @date 2020/4/2  14:10
 */
public class ParamUtil {

    /**
     * xml格式化
     *
     * @param unformattedXml
     * @return
     */
    public static String formatXml(String unformattedXml) {
        try {
            if (StrUtil.isEmpty(unformattedXml)) {
                return StrUtil.EMPTY;
            }
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            InputSource is = new InputSource(new StringReader(unformattedXml));
            final Document document = db.parse(is);
            OutputFormat format = new OutputFormat(document);
            format.setLineWidth(65);
            format.setIndenting(true);
            format.setIndent(2);
            Writer out = new StringWriter();
            XMLSerializer serializer = new XMLSerializer(out, format);
            serializer.serialize(document);
            return out.toString();
        } catch (Exception e) {
            return unformattedXml;
        }
    }

    /**
     * json格式化
     *
     * @param jsonString
     * @return
     */
    public static String formatJson(String jsonString) {
        if (StrUtil.isEmpty(jsonString)) {
            return StrUtil.EMPTY;
        }
        String s = jsonString.substring(0, 1);
        if ("{".equals(s)) {
            JSONObject object = JSONObject.parseObject(jsonString);
            return JSON.toJSONString(object, SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);
        } else if ("[".equals(s)) {
            JSONArray object = JSONArray.parseArray(jsonString);
            return JSON.toJSONString(object, SerializerFeature.PrettyFormat, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteDateUseDateFormat);
        } else {
            return jsonString;
        }
    }
}
