package cn.cmaple.mainsver.mapper.AdvancedSQL;

import cn.cmaple.mainsver.tools.SqlTool;
import org.apache.ibatis.jdbc.SQL;

/**
 * 类名：基础服务类复杂sql拼接类 - BasicSql
 * 功能描述：基础服务类复杂sql拼接类
 * 创建人：CMAPLE
 * 创建日期：2021-07-26
 *
 * @Version 1.0
 * @since JDK1.8 及 更高
 */
public class BasicSql {

    /**
     * 函数名：语句拼接函数-获取关于页面，管理团队、合作贡献、投资信息的sql语句- selectContributionInfo（）
     * 功能描述： 获取关于页面，管理团队、合作贡献、投资信息的sql语句
     * 输入参数：<按照参数定义顺序>
     * <p>
     * 返回值：String
     * 异    常：NULL
     * 创建人：CMAPLE
     * 日期：2021-08-11
     */
    public String selectContributionInfo() {
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
     * 函数名：语句拼接函数-获取服务页面案例信息的sql语句- selectCases（）
     * 功能描述： 获取服务页面案例信息的sql语句
     * 输入参数：<按照参数定义顺序>
     * <p>
     * 返回值：String
     * 异    常：NULL
     * 创建人：CMAPLE
     * 日期：2021-07-26
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
     * 函数名：语句拼接函数-获取服务页面项目信息的sql语句- selectPrograms（）
     * 功能描述： 获取服务页面项目信息的sql语句
     * 输入参数：<按照参数定义顺序>
     * <p>
     * 返回值：String
     * 异    常：NULL
     * 创建人：CMAPLE
     * 日期：2021-07-26
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