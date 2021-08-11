package cn.cmaple.mainsver.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @ClassName: About
 * @Description: 网站关于页面管理团队、贡献、赞助相关信息实体类
 * @author: CMAPLE
 * @date 2021/8/11 下午12:41
 * @Version 1.0
 * @since JDK1.8 及 更高
 */
@Data //给实体提供读写属性, 此外还提供了 equals()、hashCode()、toString() 方法
@TableName("BS_About")  //对应数据库表名称
@Accessors(chain = true)  //chain 若为true，则setter方法返回当前对象()
@NoArgsConstructor  //提供无参构造器
@AllArgsConstructor //提供全参构造器
public class About {
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
     * 数据类型：1- 管理团队、2- 贡献、3- 赞助
     * 长度：8
     * 是否为null：N
     **/
    private Integer type;

    /**
     * 人员名称
     * 长度：16
     * 是否为null：N
     **/
    private String name;

    /**
     * 人员类别
     * 长度：16
     * 是否为null：N
     **/
    private String position;

    /**
     * 人员介绍
     * 长度：32
     * 是否为null：N
     **/
    private String introduce;
}
