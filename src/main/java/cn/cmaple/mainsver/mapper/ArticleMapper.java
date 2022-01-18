package cn.cmaple.mainsver.mapper;

import cn.cmaple.mainsver.mapper.AdvancedSQL.ArticleSql;
import cn.cmaple.mainsver.model.Article;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;
import java.util.Map;

/**
 * 类名：帖子映射 - ArticleMapper
 * 功能描述：帖子基础函数mapper映射接口
 * 创建人：CMAPLE
 * 创建日期：2021-12-22
 *
 * @Version 1.0
 * @since JDK1.8 及 更高
 */
public interface ArticleMapper extends BaseMapper<Article> {

    /**
     * 函数名：查询函数-根据条件获取相应帖子- selectArticles（）
     * 功能描述： 根据条件获取帖子列表（分页查询）ID、帖子ID、帖子类型、帖子发布者、帖子标题、帖子作者、帖子创建时间
     * 输入参数：<按照参数定义顺序>
     *
     * @param params Map类型的字段及数值集合
     * @param page   int类型的条件列表
     * @param num    int类型的字段及数值集合
     *               返回值：List<Cases>
     *               异    常：NULL
     *               创建人：CMAPLE
     *               日期：2021-12-22
     */
    @SelectProvider(type = ArticleSql.class, method = "selectArticles")
    List<Article> selectArticles(@Param("params") Map<String, Object> params, @Param("page") int page, @Param("num") int num);

    /**
     * 函数名：查询函数-按照条件并根据id获取相应帖子- selectArticlesOrderByDescID（）
     * 功能描述： 按照条件并根据id获取最新的帖子信息（分页查询）ID、帖子ID、帖子类型、帖子发布者、帖子标题、帖子作者、帖子创建时间
     * 输入参数：<按照参数定义顺序>
     *
     * @param params Map类型的字段及数值集合
     * @param page   int类型的条件列表
     * @param num    int类型的字段及数值集合
     *               返回值：List<Cases>
     *               异    常：NULL
     *               创建人：CMAPLE
     *               日期：2021-12-22
     */
    @SelectProvider(type = ArticleSql.class, method = "selectArticlesOrderByDescID")
    List<Article> selectArticlesOrderByDescID(@Param("params") Map<String, Object> params, @Param("page") int page, @Param("num") int num);
}
