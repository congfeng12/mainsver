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
 * @ClassName: OperationLog
 * @Description: 日志基础信息实体类
 * @author: CMAPLE
 * @date 2021/7/26 上午9:23
 * @Version 1.0
 * @since JDK1.8 及 更高
 */
@Data //给实体提供读写属性, 此外还提供了 equals()、hashCode()、toString() 方法
@TableName("CS_OperationLog")  //对应数据库表名称
@Accessors(chain = true)  //chain 若为true，则setter方法返回当前对象()
@NoArgsConstructor  //提供无参构造器
@AllArgsConstructor //提供全参构造器
public class OperationLog {

    /**
     * 日志id
     * 长度：24
     * 是否为null：N
     * 自动递增
     * 主键
     **/
    //@ExcelProperty(value = "日志ID号")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 日志流水号
     * 长度：24
     * 是否为null：N
     **/
//    @ColumnWidth(30)
//    @ExcelProperty(value = "日志流水号")
    private String serialnumber;
    /**
     * 日志操作时间
     * 长度：0
     * 是否为null：N
     **/
//    @ColumnWidth(35)
//    @ExcelProperty(value = "操作时间")
    private Date createtime;
    /**
     * 操作人员
     * 长度：24
     * 是否为null：N
     **/
//    @ColumnWidth(30)
//    @ExcelProperty(value = "操作人员（电话号）")
    private String operator;
    /**
     * 日志类型
     * 长度：12
     * 是否为null：N
     **/
//    @ColumnWidth(30)
//    @ExcelProperty(value = "日志类型")
    private String logstype;
    /**
     * 日志详细信息
     * 长度：254
     * 是否为null：N
     **/
//    @ColumnWidth(200)
//    @ExcelProperty(value = "日志详细信息")
    private String content;

}
