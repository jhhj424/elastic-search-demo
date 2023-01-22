package com.zito.elasticsearchdemo.api.dto;

import com.zito.elasticsearchdemo.domain.ShopDocument;
import com.zito.elasticsearchdemo.domain.Holiday;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
public class ShopResponse {
    private Long id;

    private String name;

    private String branchname;

    private int career;

    private Holiday holiday;

    private String description;

    private LocalDateTime createdAt;

    public static ShopResponse from(ShopDocument shopDocument) {
        return ShopResponse.builder()
                .id(shopDocument.getId())
                .name(shopDocument.getName())
                .branchname(shopDocument.getBranchname())
                .career(shopDocument.getCareer())
                .holiday(shopDocument.getHoliday())
                .description(shopDocument.getDescription())
                .createdAt(shopDocument.getCreatedAt())
                .build();
    }
}
