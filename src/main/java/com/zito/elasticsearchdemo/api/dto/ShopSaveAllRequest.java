package com.zito.elasticsearchdemo.api.dto;

import lombok.Getter;

import java.util.List;

@Getter
public class ShopSaveAllRequest {

    private List<ShopSaveRequest> shopSaveRequestList;
}
