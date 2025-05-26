package umc.umc_spring.web.dto;

import lombok.Getter;

public class ReviewRequestDTO {

    @Getter
    public static class JoinDTO{
        Long storeid;
        String content;
        Float score;
        Long memberid;
    }
}
