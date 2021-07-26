package cn.cmaple.mainsver.controller;

import cn.cmaple.mainsver.service.BasicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @ClassName: BasicController
 * @Description: 基础服务类，用于处理官网相关无需登陆的相关服务
 * @author: CMAPLE
 * @date 2021/7/23 下午1:32
 * @Version 1.0
 * @since JDK1.8 及 更高
 */
@RestController
@RequestMapping("/basic")
public class BasicController {

    @Autowired
    private BasicService basicService;

    /**
     * @Title: HeadlineNews
     * @Description 主页头条位置信息获取函数，获取内容为：图片链接、标题文字、详细内容链接地址、返回结果标记、返回结果说明
     * @return Map<String, Object>
     * @throws null
     * @author CMAPLE
     * @date 2021/7/23 下午1:51
     */
    @RequestMapping(value = "/headline", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Map<String, Object> HeadlineNews() throws Exception {
        return  basicService.getheadlineNews();
    }
}
