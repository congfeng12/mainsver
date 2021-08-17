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
     * @Title: getContributionInfo
     * @Description 获取关于页面，管理团队、合作贡献、投资信息的sql语句
     * @return String
     * @throws 
     * @author CMAPLE
     * @date 2021/8/11 下午1:18
     */
    public String selectContributionInfo(){
        String result = new SQL() {
            {
                SELECT("id ,type ,name ,position ,introduce");
                FROM("BS_About ");
            }
        }.toString();
        //添加排序
        result = SqlTool.getSqlTool().sqlPutOrderBy(result, "id");
        return result;
    }

    /**
     * @Title: getheadlineNews
     * @Description 获取服务页面案例信息的sql语句
     * @return String
     * @throws
     * @author CMAPLE
     * @date 2021/7/26 下午1:56
     */
    public String selectCases() {
        String result = new SQL() {
            {
                SELECT("id ,title ,imgurl ,domainname ,info");
                FROM("BS_Cases ");
            }
        }.toString();
        //添加排序
        result = SqlTool.getSqlTool().sqlPutOrderBy(result, "id");
        return result;
    }

    /**
     * @Title: getheadlineNews
     * @Description 获取服务页面项目信息的sql语句
     * @return String
     * @throws
     * @author CMAPLE
     * @date 2021/7/26 下午1:56
     */
    public String selectPrograms() {
        String result = new SQL() {
            {
                SELECT("id ,title ,version ,type ,domainname ,uptime");
                FROM("BS_Programs ");
            }
        }.toString();
        //添加排序
        result = SqlTool.getSqlTool().sqlPutOrderBy(result, "id");
        return result;
    }


}
