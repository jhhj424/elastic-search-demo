package com.zito.elasticsearchdemo.domain;

import com.zito.elasticsearchdemo.BaseEntity;
import com.zito.elasticsearchdemo.api.dto.ShopSaveRequest;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Shop extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String branchname;

    private int career;

    @Enumerated(EnumType.STRING)
    private Holiday holiday;

    private String description;

    public static Shop from(ShopSaveRequest shopSaveRequest) {
        return Shop.builder()
                .name(shopSaveRequest.getName())
                .branchname(shopSaveRequest.getBranchname())
                .career(shopSaveRequest.getCareer())
                .holiday(Holiday.MON)
                .description(shopSaveRequest.getDescription())
                .build();
    }
}
