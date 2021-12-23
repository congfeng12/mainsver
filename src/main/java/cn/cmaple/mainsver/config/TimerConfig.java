package cn.cmaple.mainsver.config;

import cn.cmaple.mainsver.service.JsoupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @ClassName: TimerConfig
 * @Description: 心跳服务类
 * @author: CMAPLE
 * @date 2021/12/22 上午14:05
 * @Version 1.0
 * @since JDK1.8 及 更高
 */
@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
public class TimerConfig {
    // 引入证书工具类
    @Autowired
    private JsoupService jsoupService;

    //3.添加定时任务(每天5点钟执行)
    //@Scheduled(cron = "0 0 5 * * ?")
    // 每隔2个小时执行一次
    @Scheduled(fixedRate = (1000 * 60 * 60 * 2))
    private void configureTasks() {
        // 抓取新闻信息
        jsoupService.JsoupNews();
    }
}
