package com.zito.elasticsearchdemo.domain.search;

import com.zito.elasticsearchdemo.api.dto.SearchCondition;
import com.zito.elasticsearchdemo.domain.ShopDocument;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;


@Repository
@RequiredArgsConstructor
public class ShopSearchQueryRepository {

    private final ElasticsearchOperations operations;

    public List<ShopDocument> findByCondition(SearchCondition searchCondition, Pageable pcareerable) {
        CriteriaQuery query = createConditionCriteriaQuery(searchCondition).setPageable(pcareerable);

        SearchHits<ShopDocument> search = operations.search(query, ShopDocument.class);
        return search.stream()
                .map(SearchHit::getContent)
                .collect(Collectors.toList());
    }

    private CriteriaQuery createConditionCriteriaQuery(SearchCondition searchCondition) {
        CriteriaQuery query = new CriteriaQuery(new Criteria());

        if (searchCondition == null)
            return query;

        if (searchCondition.getId() != null)
            query.addCriteria(Criteria.where("id").is(searchCondition.getId()));

        if (searchCondition.getCareer() > 0)
            query.addCriteria(Criteria.where("career").is(searchCondition.getCareer()));

        if (StringUtils.hasText(searchCondition.getName()))
            query.addCriteria(Criteria.where("name").is(searchCondition.getName()));

        if (StringUtils.hasText(searchCondition.getBranchname()))
            query.addCriteria(Criteria.where("branchname").is(searchCondition.getBranchname()));

        if (searchCondition.getHoliday() != null)
            query.addCriteria(Criteria.where("holiday").is(searchCondition.getHoliday()));

        return query;
    }
}
