package com.wangpy.common.utils;

import java.util.Collection;
import java.util.Map;

/**
 * @Author: wangpy
 * @Description: 字符串工具类
 * @Date: Created in 2022/3/11 6:47 PM
 */
public class StringUtils {
    /**
     * 空字符串
     */
    private static final String NULLSTR = "";

    /** 下划线 */
    private static final char SEPARATOR = '_';

    /**
     * 判断一个Collection是否为空， 包含List，Set，Queue
     * @param collection
     * @return
     */
    public static boolean isEmpty(Collection<?> collection){
        return isNull(collection) || collection.isEmpty();
    }

    /**
     * 判断一个Collection是否不为空， 包含List，Set，Queue
     * @param collection
     * @return
     */
    public static boolean isNotEmpty(Collection<?> collection){
        return !isEmpty(collection);
    }
    /**
     * 判断字符串是否为空
     * @param str
     * @return
     */
    public static boolean isEmpty(String str){
        return isNull(str)  || NULLSTR.equals(str.trim());
    }

    /**
     * 判断字符串是否不为空
     * @param str
     * @return
     */
    public static boolean isNotEmpty(String str){
        return !isEmpty(str);
    }

    /**
     * 判断Map是否为空
     * @param map
     * @return
     */
    public static boolean isEmpty(Map<?,?> map){
        return isNull(map)  || map.isEmpty();
    }

    /**
     * 判断Map是否不为空
     * @param map
     * @return
     */
    public static boolean isNotEmpty(Map<?,?> map){
        return !isEmpty(map);
    }

    /**
     * 判断对象数组是否为空
     * @param o
     * @return
     */
    public static boolean isEmpty(Object[] o){
        return isNull(o)  || (o.length == 0);
    }

    /**
     * 判断对象数组是否不为空
     * @param o
     * @return
     */
    public static boolean isNotEmpty(Object[] o){
        return !isEmpty(o);
    }

    /**
     * 判断对象是否为空
     * @param o
     * @return
     */
    public static boolean isNull(Object o){
        return o == null;
    }

    /**
     * 判断对象是否不为空
     * @param o
     * @return
     */
    public static boolean isNotNull(Object o){
        return !isNull(o);
    }

    /**
     * 去空格
     */
    public static String trim(String str)
    {
        return (str == null ? "" : str.trim());
    }
    /**
     * 是否包含字符串
     *
     * @param str 验证字符串
     * @param strs 字符串组
     * @return 包含返回true
     */
    public static boolean inStringIgnoreCase(String str, String... strs)
    {
        if (str != null && strs != null)
        {
            for (String s : strs)
            {
                if (str.equalsIgnoreCase(trim(s)))
                {
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * 驼峰转下划线命名
     */
    public static String toUnderScoreCase(String str)
    {
        if (str == null)
        {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        // 前置字符是否大写
        boolean preCharIsUpperCase = true;
        // 当前字符是否大写
        boolean curreCharIsUpperCase = true;
        // 下一字符是否大写
        boolean nexteCharIsUpperCase = true;
        for (int i = 0; i < str.length(); i++)
        {
            char c = str.charAt(i);
            if (i > 0)
            {
                preCharIsUpperCase = Character.isUpperCase(str.charAt(i - 1));
            }
            else
            {
                preCharIsUpperCase = false;
            }

            curreCharIsUpperCase = Character.isUpperCase(c);

            if (i < (str.length() - 1))
            {
                nexteCharIsUpperCase = Character.isUpperCase(str.charAt(i + 1));
            }

            if (preCharIsUpperCase && curreCharIsUpperCase && !nexteCharIsUpperCase)
            {
                sb.append(SEPARATOR);
            }
            else if ((i != 0 && !preCharIsUpperCase) && curreCharIsUpperCase)
            {
                sb.append(SEPARATOR);
            }
            sb.append(Character.toLowerCase(c));
        }

        return sb.toString();
    }
}
