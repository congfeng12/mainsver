package cn.cmaple.mainsver.mapper;

import cn.cmaple.mainsver.mapper.AdvancedSQL.BasicSql;
import cn.cmaple.mainsver.model.About;
import cn.cmaple.mainsver.model.Basic;
import cn.cmaple.mainsver.model.Cases;
import cn.cmaple.mainsver.model.Programs;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * @ClassName: BasicMapper
 * @Description: 主页基础信息mapper映射接口
 * @author: CMAPLE
 * @date 2021/7/23 下午1:32
 * @Version 1.0
 * @since JDK1.8 及 更高
 */
public interface BasicMapper extends BaseMapper<Basic> {

    /**
     * @Title: headlineNews
     * @Description 主页头条位置信息获取接口映射，获取内容为：图片链接、标题文字、详细内容链接地址
     * @return   List<Basic>
     * @author CMAPLE
     * @date 2021/7/26 下午1:50
     */
    @SelectProvider(type = BasicSql.class, method = "selectheadlineNews")
    List<Basic> selectheadlineNews();

    /**
     * @Title: getContributionInfo
     * @Description 关于页面团队贡献等信息获取接口映射，获取内容：管理团队、合作贡献、投资等内容信息
     * @return List<About>
     * @author CMAPLE
     * @date 2021/8/11 下午1:20
     */
    @SelectProvider(type = BasicSql.class, method = "selectContributionInfo")
    List<About> selectContributionInfo();

    /**
     * @Title: selectCases
     * @Description 服务页面案例信息获取接口映射，获取内容：名称、图片地址、域名地址、说明信息
     * @return List<Cases>
     * @author CMAPLE
     * @date 2021/8/11 下午3:22
     */
    @SelectProvider(type = BasicSql.class, method = "selectCases")
    List<Cases> selectCases();

    /**
     * @Title: selectPrograms
     * @Description 服务页面项目信息获取接口映射，获取内容：名称，版本，类型，域名地址，更新时间
     * @return List<Programs>
     * @author CMAPLE
     * @date 2021/8/11 下午3:38
     */
    @SelectProvider(type = BasicSql.class, method = "selectPrograms")
    List<Programs> selectPrograms();
}
