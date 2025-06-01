package umc.umc_spring.service.ReviewService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import umc.umc_spring.converter.ReviewConverter;
import umc.umc_spring.domain.Member;
import umc.umc_spring.domain.Review;
import umc.umc_spring.domain.Store;
import umc.umc_spring.repository.MemberRepository.MemberRepository;
import umc.umc_spring.repository.ReviewRepository.ReviewRepository;
import umc.umc_spring.repository.StoreRepository.StoreRepository;
import umc.umc_spring.web.dto.ReviewRequestDTO;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService{
    public final ReviewRepository reviewRepository;
    public final StoreRepository storeRepository;
    public final MemberRepository memberRepository;

    @Override
    public Review joinReview(ReviewRequestDTO.JoinDTO request) {
        Review review = ReviewConverter.toReivew(request);
        Member member = memberRepository.findById(request.getMemberid()).get();
        Store store = storeRepository.findById(request.getStoreid()).get();
        review.setMember(member);
        review.setStore(store);

        return reviewRepository.save(review);
    }

    @Override
    public Page<Review> getReviewList(Long StoreId, Integer page) {
        Store store = storeRepository.findById(StoreId).get();

        Page<Review> StorePage = reviewRepository.findAllByStore(store, PageRequest.of(page, 10));
        return StorePage;
    }

}
