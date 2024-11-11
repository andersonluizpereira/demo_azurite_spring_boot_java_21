package com.azurite.demo.configuration;

import com.azure.data.tables.TableClientBuilder;
import com.azure.storage.blob.BlobServiceClientBuilder;
import com.azure.storage.queue.QueueServiceClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AzureStorageConfig {

    @Value("${azure.storage.connection-string}")
    private String connectionString;

    @Bean
    public TableClientBuilder tableClientBuilder() {
        return new TableClientBuilder().connectionString(connectionString);
    }

    @Bean
    public BlobServiceClientBuilder blobServiceClientBuilder() {
        return new BlobServiceClientBuilder().connectionString(connectionString);
    }

    @Bean
    public QueueServiceClientBuilder queueServiceClientBuilder() {
        return new QueueServiceClientBuilder().connectionString(connectionString);
    }
}
