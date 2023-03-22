package com.zito.elasticsearchdemo.config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.stereotype.Component;

import java.time.Duration;

@EnableElasticsearchRepositories
@Configuration
@RequiredArgsConstructor
public class ElasticSearchConfig extends ElasticsearchConfiguration {

    private final ElasticSearchProperties elasticSearchProperties;

    @Override
    public ClientConfiguration clientConfiguration() {
        return ClientConfiguration.builder()
                .connectedTo(elasticSearchProperties.url)
                .withConnectTimeout(Duration.ofSeconds(5))
                .withSocketTimeout(Duration.ofSeconds(3))
                .build();
    }

    @Getter
    @Setter
    @Component
    @ConfigurationProperties(prefix = "elasticsearch")
    public static class ElasticSearchProperties {
        private String url;
    }

}
