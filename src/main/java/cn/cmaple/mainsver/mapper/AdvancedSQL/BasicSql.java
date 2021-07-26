package cn.cmaple.mainsver.mapper.AdvancedSQL;

import cn.cmaple.mainsver.tools.SqlTool;
import org.apache.ibatis.jdbc.SQL;

/**
 * @ClassName: BasicSql
 * @Description: 基础服务类复杂sql拼接类
 * @author: CMAPLE
 * @date 2021/7/26 下午1:45
 * @Version 1.0
 * @since JDK1.8 及 更高
 */
public class BasicSql {

    /**
     * @Title: getheadlineNews
     * @Description //TODO
     * @return     返回类型 
     * @throws 
     * @author CMAPLE
     * @date 2021/7/26 下午1:56
     */
    public String getheadlineNews() {
        String result = new SQL() {
            {
                SELECT("id ,headlineId ,title ,imgURL ,informationURL");
                FROM("BS_Headline ");
            }
        }.toString();
        //添加排序
        result = SqlTool.getSqlTool().sqlPutDescOrderBy(result, "id");
        return result;
    }
}
