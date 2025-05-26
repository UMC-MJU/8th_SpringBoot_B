package umc.umc_spring.web.dto;

import lombok.Getter;

public class MissionRequestDTO {

    @Getter
    public static class joinDTO {
        Long storeid;
        String title;
        Integer reward;
    }
}
