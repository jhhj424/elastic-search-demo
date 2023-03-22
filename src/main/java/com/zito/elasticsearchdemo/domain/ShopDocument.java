package com.zito.elasticsearchdemo.domain;

import jakarta.persistence.Id;
import lombok.*;
import org.springframework.data.elasticsearch.annotations.*;

import java.time.LocalDateTime;

import static org.springframework.data.elasticsearch.annotations.DateFormat.date_hour_minute_second_millis;
import static org.springframework.data.elasticsearch.annotations.DateFormat.epoch_millis;


@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Document(indexName = "shop")
@Mapping(mappingPath = "elastic/shop-mappings.json")
@Setting(settingPath = "elastic/shop-settings.json")
public class ShopDocument {

    @Id
    private Long id;

    private String name;

    private String branchname;

    private int career;

    private Holiday holiday;

    private String description;

    @Field(type = FieldType.Date, format = {date_hour_minute_second_millis, epoch_millis})
    private LocalDateTime createdAt;

    public static ShopDocument from(Shop shop) {
        return ShopDocument.builder()
                .id(shop.getId())
                .name(shop.getName())
                .branchname(shop.getBranchname())
                .career(shop.getCareer())
                .holiday(shop.getHoliday())
                .description(shop.getDescription())
                .createdAt(shop.getCreatedAt())
                .build();
    }

}
