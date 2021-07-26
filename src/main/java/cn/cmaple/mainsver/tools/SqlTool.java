package cn.cmaple.mainsver.tools;

/**
 * @ClassName: SqlTool
 * @Description: 进行复杂sql的维护工作；
 * @author: CMAPLE
 * @date 2021/7/23 下午1:32
 * @Version 1.0
 * @since JDK1.8 及 更高
 */
public class SqlTool {
    //私有化构造函数
    private SqlTool() {
    }

    //内部类实现实例的创建(用于延迟加载)
    private static class SqlToolInternal {
        private static SqlTool sqlTool = new SqlTool();
    }

    //重写readResolve()方法，防止序列化及反序列化破坏单利模式
    private Object readResolve() {
        return SqlTool.SqlToolInternal.sqlTool;
    }

    //返回实例的方法
    public static SqlTool getSqlTool() {
        return SqlTool.SqlToolInternal.sqlTool;
    }


    /**
     * 函数名：私有函数-按照相应字段进行从小到大排序- sqlPutOrderBy（）
     * 功能描述： 按照相应字段进行从小到大排序
     * 输入参数：<按照参数定义顺序>
     *
     * @param result   条件列表
     * @param ordderby 字段及数值集合
     *                 返回值：string
     *                 异    常：无
     *                 创建人：CMAPLE
     *                 日期：2019-01-17
     *                 修改人：
     *                 级别：普通用户
     *                 日期：
     */
    public String sqlPutOrderBy(String result, String ordderby) {
        result += " order by " + ordderby;
        return result;
    }

    /**
     * 函数名：私有函数-按照相应字段进行从大到小排序- sqlPutDescOrderBy（）
     * 功能描述： 按照相应字段进行从大到小排序
     * 输入参数：<按照参数定义顺序>
     *
     * @param result   条件列表
     * @param ordderby 字段及数值集合
     *                 返回值：string
     *                 异    常：无
     *                 创建人：CMAPLE
     *                 日期：2019-01-17
     *                 修改人：
     *                 级别：普通用户
     *                 日期：
     */
    public String sqlPutDescOrderBy(String result, String ordderby) {
        result += " order by " + ordderby + " desc ";
        return result;
    }

    /**
     * 函数名：私有函数-分页函数- sqlPutLimit（）
     * 功能描述： 分页函数
     * 输入参数：<按照参数定义顺序>
     *
     * @param result 条件列表
     * @param page   字段及数值集合
     * @param num    字段及数值集合
     *               返回值：string
     *               异    常：无
     *               创建人：CMAPLE
     *               日期：2019-01-17
     *               修改人：
     *               级别：普通用户
     *               日期：
     */
    public String sqlPutLimit(String result, int page, int num) {
        result += " limit " + page + "," + num;
        return result;
    }
}
