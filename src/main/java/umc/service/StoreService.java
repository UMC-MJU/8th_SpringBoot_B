package umc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.converter.StoreConverter;
import umc.dto.StoreRequestDTO;
import umc.entity.Region;
import umc.entity.Store;
import umc.repository.RegionRepository;
import umc.repository.StoreRepository;

@Service
@RequiredArgsConstructor
public class StoreService {
    private final StoreRepository storeRepository;
    private final RegionRepository regionRepository;

    @Transactional
    public Store addStore(StoreRequestDTO request, Long regionId) {
        Region region = regionRepository.findById(regionId)
                .orElseThrow(() -> new IllegalArgumentException("Region not found with ID: " + regionId));
        Store newStore = StoreConverter.toStore(request, region);
        return storeRepository.save(newStore);
    }
}
