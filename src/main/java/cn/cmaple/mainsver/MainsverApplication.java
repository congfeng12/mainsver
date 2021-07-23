package cn.cmaple.mainsver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@MapperScan(basePackages = "cn.cmaple.mainsver.mapper")
public class MainsverApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainsverApplication.class, args);
    }

}
