package cn.cmaple.mainsver.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @ClassName: DataSourceConfig
 * @Description: 全局拦截器配置
 * @author: CMAPLE
 * @date 2021/7/26 上午9:30
 * @Version 1.0
 * @since JDK1.8 及 更高
 */
@SpringBootConfiguration
public class DataSourceConfig {
    //指定当前对象作为bean
    @Bean(name = "dataSource")
    //指定dataSource来DI
    @Qualifier(value = "dataSource")
    //primary将当前数据库连接池作为默认数据库连接池
    @Primary
    //在application.properties文件中增加前缀c3p0
    @ConfigurationProperties(prefix = "c3p0")
    public DataSource dataSource(){
        return DataSourceBuilder.create().type(com.mchange.v2.c3p0.ComboPooledDataSource.class).build();
    }
}
