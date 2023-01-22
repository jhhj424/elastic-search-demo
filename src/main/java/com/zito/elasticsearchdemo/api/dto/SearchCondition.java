package com.zito.elasticsearchdemo.api.dto;

import com.zito.elasticsearchdemo.domain.Holiday;
import lombok.Data;

@Data
public class SearchCondition {

    private Long id;

    private String name;

    private String branchname;

    private int career;

    private Holiday holiday;

}
