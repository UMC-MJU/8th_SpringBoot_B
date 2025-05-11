package umc.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ReviewListDTO {
    private String nickname;
    private String comment;
    private LocalDateTime createdAt;
    private Integer pointReward;
    private String storeName;

    public ReviewListDTO(String nickname, String comment, LocalDateTime createdAt,
                         Integer pointReward, String storeName) {
        this.nickname = nickname;
        this.comment = comment;
        this.createdAt = createdAt;
        this.pointReward = pointReward;
        this.storeName = storeName;
    }
}

