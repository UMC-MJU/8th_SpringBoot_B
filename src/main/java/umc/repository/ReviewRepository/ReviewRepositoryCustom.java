package umc.repository.ReviewRepository;

import umc.dto.ReviewListDTO;

import java.util.List;

public interface ReviewRepositoryCustom {
    List<ReviewListDTO> findReviewsByStoreId(Long storeId);
}
