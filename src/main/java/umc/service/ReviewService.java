package umc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.dto.ReviewListDTO;
import umc.repository.ReviewRepository.ReviewRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;

    public List<ReviewListDTO> getReviewsByStore(Long storeId) {
        return reviewRepository.findReviewsByStoreId(storeId);
    }
}

