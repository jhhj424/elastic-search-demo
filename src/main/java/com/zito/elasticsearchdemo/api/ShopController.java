package com.zito.elasticsearchdemo.api;

import com.zito.elasticsearchdemo.api.dto.ShopSaveAllRequest;
import com.zito.elasticsearchdemo.application.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ShopController {

    private final ShopService shopService;


    @PostMapping("/shops")
    public ResponseEntity<Void> saveAll(@RequestBody ShopSaveAllRequest shopSaveAllRequest) {
        shopService.saveAllShop(shopSaveAllRequest);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/shopDocuments")
    public ResponseEntity<Void> saveShopDocuments() {
        shopService.saveAllShopDocuments();
        return ResponseEntity.ok().build();
    }

}
