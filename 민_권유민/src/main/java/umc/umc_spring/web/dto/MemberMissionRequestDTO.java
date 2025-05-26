package umc.umc_spring.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.umc_spring.validation.annotation.ExistMissionChallenge;

public class MemberMissionRequestDTO {

    @Getter
    public static class joinDTO {
        @NotNull
        Long memberid;
        @NotNull
        @ExistMissionChallenge
        Long missionid;
    }
}
