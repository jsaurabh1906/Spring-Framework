package com.bookstore.bookcrud;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class MongoConfig {

    @Bean
    public MongoClient mongoClient() {
        // Load the local .env file
        Dotenv dotenv = Dotenv.load();
        String atlasUri = dotenv.get("ATLAS_URI");

        return MongoClients.create(atlasUri);
    }

    @Bean
    public MongoTemplate mongoTemplate() {
        return new MongoTemplate(mongoClient(), "bookdb");
    }
}
