package com.github.yizzuide.milkomeda.util;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * HttpServletUtil
 *
 * @author yizzuide
 * @since 0.2.0
 * @version 1.12.0
 * Create at 2019/04/11 20:10
 */
public class HttpServletUtil {
    /**
     * 获取请求参数 转换成 json字符串
     *
     * @param request HttpServletRequest
     * @return json字符串
     */
    public static String getRequestData(HttpServletRequest request) {
        Enumeration<String> names = request.getParameterNames();
        Map<String, String> inputs = new HashMap<>();
        while (names.hasMoreElements()) {
            String name = names.nextElement();
            String value = request.getParameter(name);
            if (value.length() > 100) {
                String vString = value.substring(0, 50) + value.substring(value.length() - 50);
                inputs.put(name, vString);
            } else {
                inputs.put(name, value);
            }
        }
        return JSONUtil.serialize(inputs);
    }
}
