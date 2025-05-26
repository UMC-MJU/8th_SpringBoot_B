package umc.umc_spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import umc.umc_spring.apiPayload.ApiResponse;
import umc.umc_spring.converter.ReviewConverter;
import umc.umc_spring.domain.Review;
import umc.umc_spring.service.ReviewService.ReviewCommandService;
import umc.umc_spring.web.dto.ReviewRequestDTO;
import umc.umc_spring.web.dto.ReviewResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewRestController {
    public final ReviewCommandService reviewCommandService;

    @PostMapping("/")
    public ApiResponse<ReviewResponseDTO.JoinResultDTO> join(@RequestBody @Valid ReviewRequestDTO.JoinDTO request){
        Review review = reviewCommandService.joinReview(request);
        return ApiResponse.onSuccess(ReviewConverter.toJoinResultDTO(review));
    }
}
