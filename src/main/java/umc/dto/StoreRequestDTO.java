package umc.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class StoreRequestDTO {
    @NotBlank(message = "가게 이름은 필수입니다.")
    private String name;
    @NotBlank(message = "가게 주소는 필수입니다.")
    private String address;
    @NotBlank(message = "가게 카테고리는 필수입니다.")
    private String category;
}
