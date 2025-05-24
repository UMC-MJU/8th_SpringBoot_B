package umc.converter;

import umc.dto.ReviewRequestDTO;
import umc.entity.Member;
import umc.entity.Review;
import umc.entity.Store;

public class ReviewConverter {
    public static Review toReview(ReviewRequestDTO request, Store store, Member member) {
        return Review.builder()
                .comment(request.getContent())
                .rating(request.getRating())
                .store(store)
                .member(member)
                .build();
    }
}
