package umc.umc_spring.service.ReviewService;

import umc.umc_spring.domain.Store;

import java.util.List;
import java.util.Optional;

public interface ReviewQueryService {
    Optional<Store> insertReview(Long id);
    List<Store> findStoresByNameAndScore(String name, Float score);
}
