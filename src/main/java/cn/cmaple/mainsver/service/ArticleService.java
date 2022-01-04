package cn.cmaple.mainsver.service;

import cn.cmaple.mainsver.mapper.ArticleMapper;
import cn.cmaple.mainsver.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: ArticleService
 * @Description: 帖子服务类，用于处理相关帖子服务
 * @author: CMAPLE
 * @date 2021/12/30 13：48
 * @Version 1.0
 * @since JDK1.8 及 更高
 */
@Service
public class ArticleService {
    /**
     * 引入ArticleMapper
     */
    @Autowired
    private ArticleMapper articleMapper;

    /**
     * @Title: selectArticles
     * @Description 获取帖子列表（懒加载模式）ID、帖子ID、帖子类型、帖子发布者、帖子标题、帖子作者、帖子创建时间
     * @return Map<String, Object>
     * @throws Exception
     * @author CMAPLE
     * @date 2021/12/30 13：58
     */
    public Map<String, Object> selectArticles() throws Exception {
        //初始化返回结构体
        Map<String, Object> map = new HashMap<String, Object>();
        //查询案例信息(查询内容允许为空)
        List<Article> programs = articleMapper.selectArticles();
        //组装返回信息内容
        map.put("RTCODE", "success");
        map.put("RTMSG", "获取帖子列表成功！");
        map.put("RTDATA", programs);
        return map;
    }
}
