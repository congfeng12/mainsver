package cn.cmaple.mainsver.mapper;

import cn.cmaple.mainsver.mapper.AdvancedSQL.BasicSql;
import cn.cmaple.mainsver.model.Basic;
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
    @SelectProvider(type = BasicSql.class, method = "getheadlineNews")
    List<Basic> getheadlineNews();

}
