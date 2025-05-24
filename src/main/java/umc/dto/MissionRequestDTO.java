package umc.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class MissionRequestDTO {
    @NotBlank(message = "미션 제목은 필수입니다.")
    private String title;
    @NotBlank(message = "미션 설명은 필수입니다.")
    private String description;
    @Positive(message = "포인트는 양수여야 합니다.")
    private int points;
}