package umc.umc_spring.service.ReviewService;
import umc.umc_spring.domain.Review;
import umc.umc_spring.web.dto.ReviewRequestDTO;

public interface ReviewCommandService {

    Review joinReview(ReviewRequestDTO.JoinDTO request);
}
