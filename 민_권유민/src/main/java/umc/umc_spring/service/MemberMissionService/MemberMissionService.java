package umc.umc_spring.service.MemberMissionService;

import umc.umc_spring.domain.mapping.MemberMission;
import umc.umc_spring.web.dto.MemberMissionRequestDTO;

public interface MemberMissionService {
    MemberMission joinMemberMission(MemberMissionRequestDTO.joinDTO request);
}
