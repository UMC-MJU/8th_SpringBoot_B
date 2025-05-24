package umc.converter;

import umc.dto.StoreRequestDTO;
import umc.entity.Region;
import umc.entity.Store;

public class StoreConverter {
    public static Store toStore(StoreRequestDTO request, Region region) {
        return Store.builder()
                .name(request.getName())
                .address(request.getAddress())
                .category(request.getCategory())
                .region(region)
                .build();
    }
}