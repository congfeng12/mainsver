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
 * @ClassName: Article
 * @Description: 帖子页面
 * @author: CMAPLE
 * @date 2021/12/22 下16:07
 * @Version 1.0
 * @since JDK1.8 及 更高
 */
@Data //给实体提供读写属性, 此外还提供了 equals()、hashCode()、toString() 方法
@TableName("BS_Article")  //对应数据库表名称
@Accessors(chain = true)  //chain 若为true，则setter方法返回当前对象()
@NoArgsConstructor  //提供无参构造器
@AllArgsConstructor //提供全参构造器
public class Article {
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
     * 帖子编号
     * 长度：16
     * 是否为null：N
     **/
    private String aid;

    /**
     * 帖子类型
     * 长度：16
     * 是否为null：N
     **/
    private String atype;

    /**
     * 操作人员
     * 长度：16
     * 是否为null：N
     **/
    private String operator;

    /**
     * 帖子标题
     * 长度：16
     * 是否为null：N
     **/
    private String title;

    /**
     * 帖子原作者
     * 长度：16
     * 是否为null：N
     **/
    private String author;

    /**
     * 帖子原链接
     * 长度：16
     * 是否为null：N
     **/
    private String url;

    /**
     * 帖子创建时间
     * 长度：16
     * 是否为null：N
     **/
    private Date createtime;

    /**
     * 帖子内容
     * 长度：16
     * 是否为null：N
     **/
    private String content;

}
