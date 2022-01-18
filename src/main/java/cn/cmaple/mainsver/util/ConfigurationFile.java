package cn.cmaple.mainsver.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data //给实体提供读写属性, 此外还提供了 equals()、hashCode()、toString() 方法
@Accessors(chain = true)  //chain 若为true，则setter方法返回当前对象()
@NoArgsConstructor  //提供无参构造器
@AllArgsConstructor //提供全参构造器
@Component
public class ConfigurationFile {
    /**
     * 服务版本号
     * 长度：0
     * 是否为null：N/S
     **/
    @Value("${main.version.id}")
    private String MAINVERSIONID;
    /**
     * Token密钥
     * 长度：0
     * 是否为null：N/S
     **/
    @Value("${config.token.key}")
    private String CONFIGTOKENKEY;
    /**
     * SMTP 服务器地址
     * 长度：0
     * 是否为null：N/S
     **/
    @Value("${config.email.smtp}")
    private String SMTP;
    /**
     * 日志开关
     * 长度：0
     * 是否为null：N/S
     **/
    @Value("${config.email.log}")
    private String LOGPRINT;
    /**
     * 发件人昵称
     * 长度：0
     * 是否为null：N/S
     **/
    @Value("${config.email.personal}")
    private String PERSONAL;
    /**
     * 发件人邮箱地址
     * 长度：0
     * 是否为null：N/S
     **/
    @Value("${config.email.address}")
    private String ADDRESS;
    /**
     * 发件人邮箱密码
     * 长度：0
     * 是否为null：N/S
     **/
    @Value("${config.email.password}")
    private String PASSWORD;
    /**
     * 邮箱回调地址
     * 长度：0
     * 是否为null：N/S
     **/
    @Value("${config.email.returnurl}")
    private String RETURNURL;
}
