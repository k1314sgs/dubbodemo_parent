package com.dubbo.dubbo_provider;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubboConfiguration   //开启dubbo
@MapperScan("com.dubbo.dubbo_provider.mapper")
public class DubbpProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(DubbpProviderApplication.class, args);
    }
}
