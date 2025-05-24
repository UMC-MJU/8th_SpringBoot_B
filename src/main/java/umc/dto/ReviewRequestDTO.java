package umc.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ReviewRequestDTO {
    @NotBlank(message = "리뷰 내용은 필수입니다.")
    private String content;

    @Min(value = 1, message = "평점은 최소 1점입니다.")
    @Max(value = 5, message = "평점은 최대 5점입니다.")
    private int rating;
}
