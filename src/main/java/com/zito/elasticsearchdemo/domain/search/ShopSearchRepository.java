package com.zito.elasticsearchdemo.domain.search;

import com.zito.elasticsearchdemo.domain.ShopDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShopSearchRepository extends ElasticsearchRepository<ShopDocument, Long> {
}
