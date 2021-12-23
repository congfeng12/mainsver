package cn.cmaple.mainsver.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: Config
 * @Description: 配置文件信息类
 * @author: CMAPLE
 * @date 2021/12/22 下午14:03
 * @Version 1.0
 * @since JDK1.8 及 更高
 */
@Data //给实体提供读写属性, 此外还提供了 equals()、hashCode()、toString() 方法
@Accessors(chain = true)  //chain 若为true，则setter方法返回当前对象()
@NoArgsConstructor  //提供无参构造器
@AllArgsConstructor //提供全参构造器
@Component
public class Config {
    /**
     * 抓取新闻域名
     * 是否必填：是
     **/
    @Value("${jsoup.NEWS.URLS}")
    private String NEWS_URLS;

    /**
     * @Title: getNEWSURLS
     * @Description 服务页面项目信息获取函数，获取内容：名称，版本，类型，域名地址，更新时间
     * @return Map<String, Object>
     * @throws null
     * @author CMAPLE
     * @date 2021/12/22 下午14:05
     */
    public List<String> getNewsURL() {
        return Arrays.asList(NEWS_URLS.split(","));
    }
}
