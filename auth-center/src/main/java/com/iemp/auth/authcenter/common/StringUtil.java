package com.iemp.auth.authcenter.common;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import java.text.*;
import java.util.Calendar;

/** String的工具类
 * @author :Mr.kk
 * @date: 2018/9/3-10:46
 */
@Slf4j
public class StringUtil extends StringUtils {


    public static void main(String[] args) {
        log.info(createUUID());
    }

    private static final FieldPosition HELPER_POSITION = new FieldPosition(0);
    private final static Format dateFormat = new SimpleDateFormat("YYYYMMddHHmmss");
    private final static NumberFormat numberFormat = new DecimalFormat("000000");
    private static int seq = 0;
    private static final int MAX = 999999;

    /**
     *  根据当前的时间生成编码Id
     * @return String
     */
    public static synchronized String  createUUID(){
        Calendar calendar = Calendar.getInstance();
        StringBuffer sb = new StringBuffer();
        sb.append("iemp");
        dateFormat.format(calendar.getTime(), sb,HELPER_POSITION);
        numberFormat.format(seq, sb, HELPER_POSITION);
        if (seq == MAX) {
            seq = 0;
        }else {
            seq++;
        }
        return sb.toString();
    }



    /**
     * 将Object类型转为String类型
     * @return String
     */
    public static String objectToString(Object object) {
        String str = "";
        if (!isEmpty(object)) {
            str = String.valueOf(object);
        }

        return str;
    }

    /**
     *  判断Objct是否为空
     * @param object
     * @return boolean
     */
    public static boolean isEmpty(Object object) {
        return object == null || object.equals("") || object.equals("null");
    }


    /** 判断Objct是否为空
     * @param object
     * @return boolean
     */
    public static boolean isNotEmpty(Object object) {
        return !isEmpty(object);
    }

    /**
     * 判断string类型是否为空
     * @param str
     * @return boolean
     */
    public static boolean isEmpty(String str) {
        return isEmpty((Object)str);
    }


    /**
     * 判断string类型是否为空
     * @param str
     * @return boolean
     */
    public static boolean isNotEmpty(String str) {
        return !isEmpty((Object)str);
    }


    /** 将Double转为String
     * @param d
     * @param pattern
     * @return String
     */
    public static String doubleToString(double d, String pattern) {
        DecimalFormat df = new DecimalFormat(pattern);
        return df.format(d);
    }
}
