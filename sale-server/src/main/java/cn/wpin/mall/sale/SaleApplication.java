package cn.wpin.mall.sale;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 促销模块
 * @author wangpin
 */
@SpringBootApplication
@EnableDiscoveryClient
@MapperScan(basePackages = "cn.wpin.mall.sale")
public class SaleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SaleApplication.class,args);
    }
}
