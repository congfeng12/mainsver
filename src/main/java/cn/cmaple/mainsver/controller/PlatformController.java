package cn.cmaple.mainsver.controller;

import cn.cmaple.mainsver.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @ClassName: PlatformController
 * @Description: 平台服务类，用于处理平台相关服务
 * @author: CMAPLE
 * @date 2021/12/30 14：07
 * @Version 1.0
 * @since JDK1.8 及 更高
 */
@RestController
@RequestMapping("/platform")
public class PlatformController {

    @Autowired
    private ArticleService articleService;

    /**
     * @param page String类型的用户名
     * @param num  String类型的用户密码
     * @return Map<String, Object>
     * @throws Exception
     * @Title: selectArticles
     * @Description 获取帖子列表（懒加载模式）ID、帖子ID、帖子类型、帖子发布者、帖子标题、帖子作者、帖子创建时间
     * @author CMAPLE
     * @date 2021/12/30 14：16
     */
    @RequestMapping(value = "/articles", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public Map<String, Object> selectArticles(
            @RequestParam(value = "page", required = true) int page
            , @RequestParam(value = "num", required = true) int num
    ) throws Exception {
        return articleService.selectArticles(page, num);
    }
}
