package cn.cmaple.mainsver.config;

import cn.cmaple.mainsver.handle.PermissionsInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @ClassName: InterceptorConfig
 * @Description: 全局一场拦截器
 * @author: CMAPLE
 * @date 2021/7/26 上午9:30
 * @Version 1.0
 * @since JDK1.8 及 更高
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authenticationInterceptor())
                .addPathPatterns("/**");
    }

    @Bean
    public PermissionsInterceptor authenticationInterceptor() {
        return new PermissionsInterceptor();
    }
}
