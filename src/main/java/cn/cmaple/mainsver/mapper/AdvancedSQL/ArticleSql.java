package cn.cmaple.mainsver.mapper.AdvancedSQL;

import cn.cmaple.mainsver.tools.SqlTool;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

/**
 * 类名：帖子类复杂sql拼接类 - ArticleSql
 * 功能描述：NULL
 * 创建人：CMAPLE
 * 创建日期：2019-12-17
 *
 * @Version 1.0
 * @since JDK1.8 及 更高
 */
public class ArticleSql {
    /**
     * 函数名：语句拼接函数-按照条件并根据id获取相应帖子- selectArticlesOrderByDescID（）
     * 功能描述： 按照条件并根据id获取最新的帖子信息（分页查询）ID、帖子ID、帖子类型、帖子发布者、帖子标题、帖子作者、帖子创建时间
     * 输入参数：<按照参数定义顺序>
     *
     * @param params Map类型的字段及数值集合
     * @param page   int类型的条件列表
     * @param num    int类型的字段及数值集合
     *               返回值：String
     *               异    常：NULL
     *               创建人：CMAPLE
     *               日期：2022-01-06
     */
    public String selectArticlesOrderByDescID(@Param("params") Map<String, Object> params, @Param("page") int page, @Param("num") int num) {
        String result = new SQL() {
            {
                SELECT("id ,aid ,atype ,operator ,title ,author ,createtime");
                FROM("BS_Article ");
            }
        }.toString();
        //判断添加请求条件
        if (0 != params.size()) {
            result = sqlPutAnd(result, params);
        }
        //添加排序
        result = SqlTool.getSqlTool().sqlPutDescOrderBy(result, "id");
        //添加分页
        result = SqlTool.getSqlTool().sqlPutLimit(result, page, num);
        return result;
    }

    /**
     * 函数名：语句拼接函数-根据条件获取相应帖子- selectArticles（）
     * 功能描述： 按照条件获取最新的帖子信息（分页查询）ID、帖子ID、帖子类型、帖子发布者、帖子标题、帖子作者、帖子创建时间
     * 输入参数：<按照参数定义顺序>
     *
     * @param params Map类型的字段及数值集合
     * @param page   int类型的条件列表
     * @param num    int类型的字段及数值集合
     *               返回值：String
     *               异    常：NULL
     *               创建人：CMAPLE
     *               日期：2022-01-06
     */
    public String selectArticles(@Param("params") Map<String, Object> params, @Param("page") int page, @Param("num") int num) {
        String result = new SQL() {
            {
                SELECT("id ,aid ,atype ,operator ,title ,author ,createtime");
                FROM("BS_Article ");
            }
        }.toString();
        //判断添加请求条件
        if (0 != params.size()) {
            result = sqlPutAnd(result, params);
        }
        //添加分页
        result = SqlTool.getSqlTool().sqlPutLimit(result, page, num);
        return result;
    }

    /**
     * 函数名：私有函数-里程碑查询添加其他条件- sqlPutAnd（）
     * 功能描述： 里程碑查询添加其他条件
     * 输入参数：<按照参数定义顺序>
     *
     * @param result String类型的sql语句
     * @param params Map类型的字段及数值集合
     *               返回值：String
     *               异    常：NULL
     *               创建人：CMAPLE
     *               日期：2022-01-06
     */
    private String sqlPutAnd(String result, Map<String, Object> params) {
        // 计数器
        int paramsNum = 0;
        // 循环处理
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            if (0 != paramsNum) {
                result += " AND " + entry.getKey() + " = " + entry.getValue();
            } else {
                result += " WHERE " + entry.getKey() + " = " + entry.getValue();
                paramsNum += 1;
            }
        }
        return result;
    }
}