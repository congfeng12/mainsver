package cn.cmaple.mainsver.tools;

import com.auth0.jwt.JWT;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * @ClassName: HttpServletRequestTool
 * @Description: 将http中的相关数据进行快速管理
 * @author: CMAPLE
 * @date 2021/7/23 下午1:32
 * @Version 1.0
 * @since JDK1.8 及 更高
 */
public class HttpServletRequestTool {

    //私有化构造函数
    private HttpServletRequestTool() {

    }

    //内部类进行实例维护
    private static class HttpServletRequestToolInternal {
        private static HttpServletRequestTool httpServletRequestTool = new HttpServletRequestTool();
    }

    //重写readResolve()方法，防止序列化及反序列化破坏单利模式
    private Object readResolve() {
        return HttpServletRequestTool.HttpServletRequestToolInternal.httpServletRequestTool;
    }

    //返回实例的方法
    public static HttpServletRequestTool getHttpServletRequestToolExample() {
        return HttpServletRequestTool.HttpServletRequestToolInternal.httpServletRequestTool;
    }

    /**
     * 函数名：请求处理函数-根据请求取出相应请求的ip地址 - getIpAddress（）
     * 功能描述：根据请求取出相应请求的ip地址
     * 输入参数：<按照参数定义顺序>
     *
     * @param request HttpServletRequest类型的http请求
     *                返回值：String
     *                异    常：无
     *                创建人：CMAPLE
     *                创建日期：2020-03-03
     *                修改人：
     *                级别：NULL
     *                修改日期：
     */
    public String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if (null != request.getParameter("uip")){
            ip = request.getParameter("uip");
        }
        return ip;
    }

    /**
     * 函数名：请求处理函数-根据请求头取出请求用户名 - getRequestUser（）
     * 功能描述：根据请求取出相应请求的ip用户
     * 输入参数：<按照参数定义顺序>
     *
     * @param request HttpServletRequest类型的http请求
     *                返回值：String
     *                异    常：无
     *                创建人：CMAPLE
     *                创建日期：2020-03-03
     *                修改人：
     *                级别：NULL
     *                修改日期：
     */
    public String getIpAddgetRequestUser(HttpServletRequest request) {
        String user = "";
        String token = request.getHeader("token");
        if (null != token) {
            user = JWT.decode(token).getAudience().get(0);
        } else {
            user = request.getParameter("telephonenumber");
        }
        return user;
    }

    /**
     * 函数名：请求处理函数-根据请求头取出用户取出的服务 - getRequestURI（）
     * 功能描述：根据请求头取出用户取出的服务
     * 输入参数：<按照参数定义顺序>
     *
     * @param request HttpServletRequest类型的http请求
     *                返回值：String
     *                异    常：无
     *                创建人：CMAPLE
     *                创建日期：2020-03-03
     *                修改人：
     *                级别：NULL
     *                修改日期：
     */
    public String getRequestURI(HttpServletRequest request) {
        return request.getRequestURI();
    }

    /**
     * 函数名：请求处理函数-根据请求头取出用户请求的参数 - getQueryString（）
     * 功能描述：根据请求头取出用户请求的参数
     * 输入参数：<按照参数定义顺序>
     *
     * @param request HttpServletRequest类型的http请求
     *                返回值：String
     *                异    常：无
     *                创建人：CMAPLE
     *                创建日期：2020-03-03
     *                修改人：
     *                级别：NULL
     *                修改日期：
     */
    public String getQueryString(HttpServletRequest request) {
        String returninfo = null;
        String query = request.getQueryString();
        if (null == query) {
            Map<String, String> parmMap = new HashMap<String, String>();
            //方式一：getParameterMap()，获得请求参数map
            Map<String, String[]> map = request.getParameterMap();
            //参数名称
            Set<String> key = map.keySet();
            //参数迭代器
            Iterator<String> iterator = key.iterator();
            while (iterator.hasNext()) {
                String k = iterator.next();
                parmMap.put(k, map.get(k)[0]);
            }
            returninfo = parmMap.toString();
        } else {
            returninfo = query;
        }

        return returninfo;
    }

    /**
     * 函数名：请求处理函数-根据请求头取出用户请求的类型 - getMethod（）
     * 功能描述：根据请求头取出用户请求的类型
     * 输入参数：<按照参数定义顺序>
     *
     * @param request HttpServletRequest类型的http请求
     *                返回值：String
     *                异    常：无
     *                创建人：CMAPLE
     *                创建日期：2020-03-03
     *                修改人：
     *                级别：NULL
     *                修改日期：
     */
    public String getMethod(HttpServletRequest request) {
        return request.getMethod();
    }
}
