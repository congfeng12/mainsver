package cn.cmaple.mainsver.config;


import cn.cmaple.mainsver.model.OperationLog;
import cn.cmaple.mainsver.service.OperationLogService;
import cn.cmaple.mainsver.tools.FormatTime;
import cn.cmaple.mainsver.tools.HttpServletRequestTool;
import cn.cmaple.mainsver.tools.RandomData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: ExceptionConfig
 * @Description: 全局异常拦截器
 * @author: CMAPLE
 * @date 2021/7/26 上午9:30
 * @Version 1.0
 * @since JDK1.8 及 更高
 */
@ControllerAdvice
public class ExceptionConfig {
    /**
     * 引入OperationLogService
     */
    @Autowired
    private OperationLogService operationLogService;

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Map<String, Object> globaException(HttpServletRequest request, Exception exception) {
        // 账户参数判断处理
        String user = HttpServletRequestTool.getHttpServletRequestToolExample().getIpAddgetRequestUser(request);
        String in_user = (user == null) ? "游客账号" : user;
        // 记录异常日志
        operationLogService.insert(new OperationLog(0
                , "HC" + FormatTime.getFormatTime().formatYMDToString(new Date()) + "-" + RandomData.getRandomData().getRandomNHData(6)
                , new Date(), HttpServletRequestTool.getHttpServletRequestToolExample().getIpAddgetRequestUser(request)
                , "exception"
                , "用户：[" + in_user + "] " +
                "通过 ip[" + HttpServletRequestTool.getHttpServletRequestToolExample().getIpAddress(request) + "] " +
                "访问 [" + HttpServletRequestTool.getHttpServletRequestToolExample().getRequestURI(request) + "]服务出现异常，" +
                "请求类型[" + HttpServletRequestTool.getHttpServletRequestToolExample().getMethod(request) + "]，" +
                "请求参数[" + HttpServletRequestTool.getHttpServletRequestToolExample().getQueryString(request) + "]，" +
                "错误信息[" + exception.getMessage().replaceAll("\\r|\\n","\u3000") + "]"));
        // 返回异常信息
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("RTCODE", "error");
        map.put("RTMSG", "请求异常，请联系管理员！");
        map.put("RTDATA", exception.getMessage());
        return map;
    }
}
