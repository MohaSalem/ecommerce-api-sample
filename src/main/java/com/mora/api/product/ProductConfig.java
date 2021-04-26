package com.mora.api.product;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ProductConfig {

    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository){
        return args -> {
            Product one = new Product("Dry food",9,9.9,"economic","https://shop-cdn-m.mediazs.com/bilder/happy/cat/adult/lamb/dry/food/0/800/70365_pla_happycat_adult_weidelamm_0.jpg");
            Product two = new Product("Chicken chunks", 13, 13.13, "tasty", "https://media.ox.ee/pictures/scaled/b1/7d/1/1586688_800x600_b.jpg");
            Product three = new Product("Fish chunks",  17,17.17, "healthy", "https://cdn.shopify.com/s/files/1/0253/3490/6933/products/Fish-Chunks-ListingPage.jpg?v=1594699626");
            Product four = new Product("Beef chunks",22, 22.22, "awesome", "https://www.hillspet.co.uk/content/dam/pim/hills/en_gb/sd/pouch/sp-feline-science-plan-adult-tender-chunks-gravy-with-beef-pouch-productShot_zoom.jpg");
            Product five = new Product("Mixed food",33, 33.33, "multi-food", "https://bjs.scene7.com/is/image/bjs/243741?$bjs-Zoom$");

            productRepository.saveAll(List.of(one, two, three, four, five));
        };
    }
}
