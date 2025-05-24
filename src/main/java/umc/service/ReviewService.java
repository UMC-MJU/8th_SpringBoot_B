package umc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.converter.ReviewConverter;
import umc.dto.ReviewRequestDTO;
import umc.entity.Member;
import umc.entity.Review;
import umc.entity.Store;
import umc.repository.MemberRepository.MemberRepository;
import umc.repository.ReviewRepository.ReviewRepository;
import umc.repository.StoreRepository;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final MemberRepository memberRepository;
    private final StoreRepository storeRepository;

    @Transactional
    public Review addReview(ReviewRequestDTO request, Long storeId) {
        Member member = memberRepository.findFirstByOrderByIdAsc()
                .orElseThrow(() -> new IllegalStateException("No member found in DB"));

        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new IllegalArgumentException("Store not found with ID: " + storeId));

        Review newReview = ReviewConverter.toReview(request, store, member);
        return reviewRepository.save(newReview);
    }
}
