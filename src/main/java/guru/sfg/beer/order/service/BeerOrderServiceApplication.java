package guru.sfg.beer.order.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class BeerOrderServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BeerOrderServiceApplication.class, args);
    }

    @Profile("localmysql")
    @Bean
    public String devBean() {
        return "localmysql";
    }

    @Profile("prod")
    @Bean
    public String prodBean() {
        return "prod";
    }
}
