package umc.umc_spring.converter;

import umc.umc_spring.domain.enums.MissionStatus;
import umc.umc_spring.domain.mapping.MemberMission;
import umc.umc_spring.web.dto.MemberMissionRequestDTO;
import umc.umc_spring.web.dto.MemberMissionResponseDTO;

import java.time.LocalDateTime;

public class MemberMissionConverter {
    public static MemberMission toMemberMission(MemberMissionRequestDTO.joinDTO request) {
        return MemberMission.builder()
                .status(MissionStatus.IN_PROGRESS)
                .build();
    }

    public static MemberMissionResponseDTO.joinResultDTO toJoinResultDTO(MemberMission memberMission) {
        return MemberMissionResponseDTO.joinResultDTO.builder()
                .memberMissionId(memberMission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
