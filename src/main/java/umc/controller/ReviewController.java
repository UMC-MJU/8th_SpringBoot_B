package umc.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.annotation.StoreExists;
import umc.dto.ReviewRequestDTO;
import umc.entity.Review;
import umc.service.ReviewService;


@RestController
@RequestMapping("/stores")
@RequiredArgsConstructor
@Validated
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping("/{store-id}/reviews")
    public ResponseEntity<Review> addReview(@PathVariable("store-id") @StoreExists Long storeId, @RequestBody @Valid ReviewRequestDTO request) {
        Review savedReview = reviewService.addReview(request, storeId);
        return new ResponseEntity<>(savedReview, HttpStatus.CREATED);
    }
}
