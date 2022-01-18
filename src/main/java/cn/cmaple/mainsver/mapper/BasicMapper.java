package cn.cmaple.mainsver.mapper;

import cn.cmaple.mainsver.mapper.AdvancedSQL.BasicSql;
import cn.cmaple.mainsver.model.About;
import cn.cmaple.mainsver.model.Cases;
import cn.cmaple.mainsver.model.Programs;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * 类名：帖子映射 - BasicMapper
 * 功能描述：主页基础信息mapper映射接口
 * 创建人：CMAPLE
 * 创建日期：2021-7-23
 *
 * @Version 1.0
 * @since JDK1.8 及 更高
 */
public interface BasicMapper extends BaseMapper {

    /**
     * 函数名：查询函数-获取关于页面团队贡献等信息- selectContributionInfo（）
     * 功能描述： 关于页面团队贡献等信息获取接口映射，获取内容：管理团队、合作贡献、投资等内容信息
     * 输入参数：<按照参数定义顺序>
     * <p>
     * 返回值：List<About>
     * 异    常：NULL
     * 创建人：CMAPLE
     * 日期：2021-08-11
     */
    @SelectProvider(type = BasicSql.class, method = "selectContributionInfo")
    List<About> selectContributionInfo();

    /**
     * 函数名：查询函数-获取服务页面案例信息- selectCases（）
     * 功能描述： 服务页面案例信息获取接口映射，获取内容：名称、图片地址、域名地址、说明信息
     * 输入参数：<按照参数定义顺序>
     * <p>
     * 返回值：List<Cases>
     * 异    常：NULL
     * 创建人：CMAPLE
     * 日期：2021-08-11
     */
    @SelectProvider(type = BasicSql.class, method = "selectCases")
    List<Cases> selectCases();

    /**
     * 函数名：查询函数-获取服务页面项目信息- selectPrograms（）
     * 功能描述： 服务页面项目信息获取接口映射，获取内容：名称，版本，类型，域名地址，更新时间
     * 输入参数：<按照参数定义顺序>
     * <p>
     * 返回值：List<Programs>
     * 异    常：NULL
     * 创建人：CMAPLE
     * 日期：2021-08-11
     */
    @SelectProvider(type = BasicSql.class, method = "selectPrograms")
    List<Programs> selectPrograms();
}