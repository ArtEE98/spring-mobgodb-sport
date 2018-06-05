package com.example.springmobgodbsport.config;

import com.example.springmobgodbsport.document.Order;
import com.example.springmobgodbsport.document.Requirements;
import com.example.springmobgodbsport.repository.OrderRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackageClasses = OrderRepository.class)
@Configuration
public class MongoDBConfig {

    @Bean
    CommandLineRunner commandLineRunner(OrderRepository orderRepository) {
        return new CommandLineRunner() {
            @Override
            public void run(String... args) throws Exception {

                //Just for illustrative purposes.
                Requirements r = new Requirements(false, false, true, 15);

                Order o1 = new Order(1, "Artem", "SmartSport",
                        12, "Ukraine", "done", r);
                Order o2 = new Order(2, "Evgen", "Luxoft",
                        4, "Ukraine", "pending", r);
                Order o3 = new Order(3, "Uru", "Luxoft",
                        4, "Ukraine", "pending", r);

                orderRepository.deleteAll();
                orderRepository.save(o1);
                orderRepository.save(o2);
                orderRepository.save(o3);
            }
        };
    }
}
