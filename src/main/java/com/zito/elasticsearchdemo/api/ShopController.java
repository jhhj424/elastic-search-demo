package com.zito.elasticsearchdemo.api;

import com.zito.elasticsearchdemo.api.dto.SearchCondition;
import com.zito.elasticsearchdemo.api.dto.ShopResponse;
import com.zito.elasticsearchdemo.api.dto.ShopSaveAllRequest;
import com.zito.elasticsearchdemo.application.ShopService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/shops")
    public ResponseEntity<List<ShopResponse>> search(SearchCondition searchCondition, Pageable pageable) {
        return ResponseEntity.ok(shopService.searchByCondition(searchCondition, pageable));
    }
}
