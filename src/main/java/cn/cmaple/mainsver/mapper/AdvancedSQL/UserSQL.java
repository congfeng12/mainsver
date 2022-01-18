package cn.cmaple.mainsver.mapper.AdvancedSQL;

import cn.cmaple.mainsver.tools.SqlTool;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;

/**
 * 类名：用户管理模块sql拼接类 - UserSQL
 * 功能描述：帖子类复杂sql拼接
 * 创建人：CMAPLE
 * 创建日期：2022-1-18
 *
 * @Version 1.0
 * @since JDK1.8 及 更高
 */
public class UserSQL {
    /**
     * 函数名：语句拼接函数-根据条件查询用户列表- selectByCriteria（）
     * 功能描述：按照条件并根据id获取用户信息（分页查询）（具体用户结构可能还需要修改后续补充）
     * 输入参数：<按照参数定义顺序>
     *
     * @param list   List类型的条件列表
     * @param params Map类型的字段及数值集合
     * @param page   int类型的页数
     * @param num    int类型的数量
     *               返回值：String
     *               异    常：NULL
     *               创建人：CMAPLE
     *               日期：2022-01-18
     */
    public String selectByCriteria(@Param("list") List<String> list, @Param("params") Map<String, Object> params, @Param("page") int page, @Param("num") int num) {
        String result = new SQL() {
            {
                SELECT("id ,usertype ,useraffairs ,userbalance ,idcard ,name ,useraddress ,telephonenumber " +
                        ",useremail ,createtime ,usersign ,petname ,errortry ,commonip ,lastplace ,permissions");
                FROM("CS_User ");
            }
        }.toString();
        //判断添加请求条件
        if (0 != list.size()) {
            result = sqlPutAnd(result, list, params);
        }
        //添加排序
        result = SqlTool.getSqlTool().sqlPutOrderBy(result, "id");
        //添加分页
        result = SqlTool.getSqlTool().sqlPutLimit(result, page, num);
        return result;
    }

    /**
     * 函数名：语句拼接函数-根据条件查询条件下的用户总数量- selectCountByCriteria（）
     * 功能描述：根据相应条件拼接查询符合条件的用户数量
     * 输入参数：<按照参数定义顺序>
     *
     * @param list   List类型的条件列表
     * @param params Map类型的字段及数值集合
     *               返回值：String
     *               异    常：NULL
     *               创建人：CMAPLE
     *               日期：2022-01-18
     */
    public String selectCountByCriteria(@Param("list") List<String> list, @Param("params") Map<String, Object> params) {
        String result = new SQL() {
            {
                SELECT("COUNT(*) ");
                FROM("CS_User ");
            }
        }.toString();
        //判断添加请求条件
        if (0 != list.size()) {
            result = sqlPutAnd(result, list, params);
        }
        return result;
    }

    /**
     * 函数名：私有函数-添加其他条件- sqlPutAnd（）
     * 功能描述： 添加其他条件
     * 输入参数：<按照参数定义顺序>
     *
     * @param result String类型的sql语句
     * @param list   List类型的条件列表
     * @param params Map类型的字段及数值集合
     *               返回值：String
     *               异    常：NULL
     *               创建人：CMAPLE
     *               日期：2022-01-18
     */
    private String sqlPutAnd(String result, List<String> list, Map<String, Object> params) {
        for (int i = 0; i < list.size(); i++) {
            if (params.containsKey(list.get(i))) {
                //添加AND
                if (i > 0) {
                    result += " AND ";
                } else {
                    result += " WHERE ";
                }
                if ("usertype".equals(list.get(i))) {
                    result += " usertype = '" + params.get(list.get(i)) + "'";
                }
                if ("useraffairs".equals(list.get(i))) {
                    result += " useraffairs = '" + params.get(list.get(i)) + "'";
                }
                if ("timeaxisdate".equals(list.get(i))) {
                    result += " DATE_FORMAT( createtime, '%Y-%m-%d') >= '" + ((List) params.get(list.get(i))).get(0) + "' and DATE_FORMAT( createtime , '%Y-%m-%d') <= '" + ((List) params.get(list.get(i))).get(1) + "'";
                }
                if ("content".equals(list.get(i))) {
                    result += " ( idcard LIKE '%" + params.get(list.get(i)) + "%' " +
                            "or name LIKE '%" + params.get(list.get(i)) + "%' " +
                            "or useraddress LIKE '%" + params.get(list.get(i)) + "%' " +
                            "or telephonenumber LIKE '%" + params.get(list.get(i)) + "%' " +
                            "or useremail LIKE '%" + params.get(list.get(i)) + "%' " +
                            "or petname LIKE '%" + params.get(list.get(i)) + "%' " +
                            "or commonip LIKE '%" + params.get(list.get(i)) + "%' " +
                            "or lastplace LIKE '%" + params.get(list.get(i)) + "%' ) ";
                }
            }
        }
        return result;
    }

}
