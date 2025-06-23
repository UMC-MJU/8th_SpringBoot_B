package umc.umc_spring.service.ReviewService;
import org.springframework.data.domain.Page;
import umc.umc_spring.domain.Review;
import umc.umc_spring.web.dto.ReviewRequestDTO;

public interface ReviewCommandService {

    Page<Review> getReviewList(Long StoreId, Integer page);

    Review joinReview(ReviewRequestDTO.JoinDTO request);
}
