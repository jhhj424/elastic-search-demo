package com.zito.elasticsearchdemo.application;

import com.zito.elasticsearchdemo.api.dto.ShopSaveAllRequest;
import com.zito.elasticsearchdemo.domain.Shop;
import com.zito.elasticsearchdemo.domain.ShopDocument;
import com.zito.elasticsearchdemo.domain.ShopRepository;
import com.zito.elasticsearchdemo.domain.search.ShopSearchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ShopService {

    private final ShopRepository shopRepository;
    private final ShopSearchRepository shopSearchRepository;

    @Transactional
    public void saveAllShop(ShopSaveAllRequest shopSaveAllRequest) {
        List<Shop> shopList = shopSaveAllRequest.getShopSaveRequestList().stream().map(Shop::from).collect(Collectors.toList());
        shopRepository.saveAll(shopList);
    }

    @Transactional
    public void saveAllShopDocuments() {
        List<ShopDocument> shopDocumentList = shopRepository.findAll().stream().map(ShopDocument::from).collect(Collectors.toList());
        shopSearchRepository.saveAll(shopDocumentList);
    }
}
