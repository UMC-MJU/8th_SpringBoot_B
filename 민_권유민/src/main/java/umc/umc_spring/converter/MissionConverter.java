package umc.umc_spring.converter;

import umc.umc_spring.domain.Mission;
import umc.umc_spring.web.dto.MissionRequestDTO;
import umc.umc_spring.web.dto.MissionResponseDTO;

import java.time.LocalDateTime;

public class MissionConverter {
    public static Mission toMission(MissionRequestDTO.joinDTO request) {
        return Mission.builder()
                .title(request.getTitle())
                .reward(request.getReward())
                .build();
    }

    public static MissionResponseDTO.JoinResultDTO toJoinResultDTO(Mission mission) {
        return MissionResponseDTO.JoinResultDTO.builder()
                .missionId(mission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
