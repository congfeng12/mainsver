package cn.cmaple.mainsver.mapper;

import cn.cmaple.mainsver.mapper.AdvancedSQL.ArticleSql;
import cn.cmaple.mainsver.model.Article;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * @ClassName: ArticleMapper
 * @Description: 帖子基础函数mapper映射接口
 * @author: CMAPLE
 * @date 2021/12/22 13:52
 * @Version 1.0
 * @since JDK1.8 及 更高
 */
public interface ArticleMapper extends BaseMapper<Article> {

    /**
     * @Title: selectArticles
     * @Description 获取帖子列表（懒加载模式）ID、帖子ID、帖子类型、帖子发布者、帖子标题、帖子作者、帖子创建时间
     * @return List<Cases>
     * @author CMAPLE
     * @date 2021/12/22 13:59
     */
    @SelectProvider(type = ArticleSql.class, method = "selectArticles")
    List<Article> selectArticles();
}
