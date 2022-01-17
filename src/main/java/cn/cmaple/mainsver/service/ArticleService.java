package cn.cmaple.mainsver.service;

import cn.cmaple.mainsver.mapper.ArticleMapper;
import cn.cmaple.mainsver.model.Article;
import cn.cmaple.mainsver.tools.ParamsTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
     * 函数名：查询函数-根据条件获取相应帖子- selectArticles（）
     * 功能描述： 根据条件获取帖子列表（分页查询）ID、帖子ID、帖子类型、帖子发布者、帖子标题、帖子作者、帖子创建时间
     * 输入参数：<按照参数定义顺序>
     *
     * @param page int类型的条件列表
     * @param num  int类型的字段及数值集合
     *             返回值：Map<String, Object>
     *             异    常：NULL
     *             创建人：CMAPLE
     *             日期：2021-12-30
     */
    public Map<String, Object> selectArticles(int page, int num) {
        // 初始化返回结构体
        Map<String, Object> map = new HashMap<>();
        // 初始化返回内容
        List<Article> programs = new ArrayList<>();
        // sql条件
        Map<String, Object> params = new HashMap<>();
        // 分页查询判断
        if (1 == page) {
            // 第一页处理
            // 添加：类型-置顶
            params.put("atype", "1");
            // 查询帖子信息(查询内容允许为空)
            List<Article> tops = articleMapper.selectArticles(params, 0, 2);
            // 修改：类型-热点
            params.put("atype", "2");
            // 查询案例信息(查询内容允许为空)
            List<Article> hots = articleMapper.selectArticles(params, 0, 1);
            // 修改：类型-精华
            params.put("atype", "3");
            // 查询案例信息(查询内容允许为空)
            List<Article> ess = articleMapper.selectArticles(params, 0, 1);
            // 修改：类型-公告
            params.put("atype", "4");
            // 查询案例信息(查询内容允许为空)
            List<Article> notice = articleMapper.selectArticles(params, 0, 1);
            // 修改：类型-新闻
            params.put("atype", "5");
            // 查询案例信息(查询内容允许为空)
            List<Article> news = articleMapper.selectArticlesOrderByDescID(params, 0, 2);
            // 修改：类型-交流
            params.put("atype", "6");
            // 查询案例信息(查询内容允许为空)
            List<Article> comms = articleMapper.selectArticlesOrderByDescID(params, 0, 2);
            // 合并信息
            programs.addAll(tops);
            programs.addAll(hots);
            programs.addAll(ess);
            programs.addAll(notice);
            programs.addAll(news);
            programs.addAll(comms);
        } else {
            // 第二页处理
            // 增加：类型-交流
            params.put("atype", "6");
            // 查询案例信息(查询内容允许为空)
            programs = articleMapper.selectArticlesOrderByDescID(params, ParamsTools.getPageTools().getPageByNum(page, num), num);
        }
        // 组装返回信息内容
        map.put("RTCODE", "success");
        map.put("RTMSG", "获取帖子列表成功！");
        map.put("RTDATA", programs);
        return map;
    }
}
