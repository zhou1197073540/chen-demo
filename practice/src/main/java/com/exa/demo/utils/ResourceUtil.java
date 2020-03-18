package com.exa.demo.utils;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * 读取配置文件
 */
public class ResourceUtil {
    private static ResourceUtil RESOURCE_UTIL = null;
    private static ResourceBundle BUNDLE=ResourceBundle.getBundle("words", Locale.CHINA);

    private ResourceUtil() {
    }
    /**
     * 工厂实现配置文件读取
     *
     * @param properties 参数
     * @return ResourceUtil 工具类
     */
    public static ResourceUtil getInstance(String properties) {
        if (properties != null) {
            BUNDLE = java.util.ResourceBundle.getBundle(properties);
        }
        return getInstance();
    }

    public static ResourceUtil getInstance() {
        if (RESOURCE_UTIL == null) {
            RESOURCE_UTIL = new ResourceUtil();
        }
        return RESOURCE_UTIL;
    }

    /**
     * 主要功能:获取配置文件参数
     * 注意事项:无
     *
     * @param name 参数名称
     * @return 参数名称对应值
     */
    public String getConfigByName(String name) {
        String value = "";
        try {
            value = new String(BUNDLE.getString(name).getBytes("iso8859-1"), "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }

    public static void main(String[] args) {

    }
}
