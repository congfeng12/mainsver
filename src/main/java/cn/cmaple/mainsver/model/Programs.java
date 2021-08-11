package cn.cmaple.mainsver.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @ClassName: Programs
 * @Description: 服务页面项目信息实体类
 * @author: CMAPLE
 * @date 2021/8/11 下午3:32
 * @Version 1.0
 * @since JDK1.8 及 更高
 */
@Data //给实体提供读写属性, 此外还提供了 equals()、hashCode()、toString() 方法
@TableName("BS_Programs")  //对应数据库表名称
@Accessors(chain = true)  //chain 若为true，则setter方法返回当前对象()
@NoArgsConstructor  //提供无参构造器
@AllArgsConstructor //提供全参构造器
public class Programs {
    /**
     * 基础信息顺序号
     * 长度：32
     * 是否为null：N
     * 自动递增
     * 主键
     **/
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 项目标题
     * 长度：16
     * 是否为null：N
     **/
    private String title;

    /**
     * 项目版本
     * 长度：16
     * 是否为null：N
     **/
    private String version;

    /**
     * 项目类型
     * 长度：16
     * 是否为null：N
     **/
    private String type;

    /**
     * 项目域名地址
     * 长度：125
     * 是否为null：N
     **/
    private String domain_name;

    /**
     * 项目开发更新时间
     * 长度：125
     * 是否为null：N
     **/
    private Date uptime;
}
