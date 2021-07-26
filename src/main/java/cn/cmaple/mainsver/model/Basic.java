package cn.cmaple.mainsver.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

/**
 * @ClassName: Basic
 * @Description: 主页基础信息实体类
 * @author: CMAPLE
 * @date 2021/7/26 上午9:23
 * @Version 1.0
 * @since JDK1.8 及 更高
 */
@Data //给实体提供读写属性, 此外还提供了 equals()、hashCode()、toString() 方法
@TableName("BS_Headline")  //对应数据库表名称
@Accessors(chain = true)  //chain 若为true，则setter方法返回当前对象()
@NoArgsConstructor  //提供无参构造器
@AllArgsConstructor //提供全参构造器
public class Basic {
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
     * 基础信息编号
     * 长度：24
     * 是否为null：N
     **/
    private String headlineId;

    /**
     * 基础信息标题
     * 长度：56
     * 是否为null：N
     **/
    private String title;

    /**
     * 基础信息图片链接
     * 长度：512
     * 是否为null：N
     **/
    private String imgURL;

    /**
     * 基础信息内容链接
     * 长度：512
     * 是否为null：N
     **/
    private String informationURL;

}
