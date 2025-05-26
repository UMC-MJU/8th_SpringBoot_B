package umc.umc_spring.service.MissionService;

import umc.umc_spring.domain.Mission;
import umc.umc_spring.web.dto.MissionRequestDTO;

public interface MissionCommandService {

    Mission joinMission(MissionRequestDTO.joinDTO request);
}
