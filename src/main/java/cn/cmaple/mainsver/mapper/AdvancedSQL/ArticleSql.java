package cn.cmaple.mainsver.mapper.AdvancedSQL;

import cn.cmaple.mainsver.tools.SqlTool;
import org.apache.ibatis.jdbc.SQL;

/**
 * @ClassName: ArticleSql
 * @Description: 帖子类复杂sql拼接类
 * @author: CMAPLE
 * @date 2021/12/30 13：57
 * @Version 1.0
 * @since JDK1.8 及 更高
 */
public class ArticleSql {

    /**
     * @Title: selectArticles
     * @Description 获取帖子列表（懒加载模式）ID、帖子ID、帖子类型、帖子发布者、帖子标题、帖子作者、帖子创建时间
     * @return String
     * @throws
     * @author CMAPLE
     * @date 2021/12/22 13:59
     */
    public String selectArticles() {
        String result = new SQL() {
            {
                SELECT("id ,aid ,atype ,operator ,title ,author ,createtime");
                FROM("BS_Article ");
            }
        }.toString();
        //添加排序
        result = SqlTool.getSqlTool().sqlPutOrderBy(result, "id");
        return result;
    }
}
