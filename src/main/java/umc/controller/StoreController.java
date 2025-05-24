package umc.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.dto.StoreRequestDTO;
import umc.entity.Store;
import umc.service.StoreService;


@RestController
@RequestMapping("/stores")
@RequiredArgsConstructor
@Validated
public class StoreController {
    private final StoreService storeService;

    @PostMapping("/{region-id}")
    public ResponseEntity<Store> addStore(@PathVariable("region-id") Long regionId, @RequestBody @Valid StoreRequestDTO request) {
        Store savedStore = storeService.addStore(request, regionId);
        return new ResponseEntity<>(savedStore, HttpStatus.CREATED);
    }
}
