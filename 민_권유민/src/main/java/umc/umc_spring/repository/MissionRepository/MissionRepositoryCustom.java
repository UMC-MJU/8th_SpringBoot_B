package umc.umc_spring.repository.MissionRepository;

import umc.umc_spring.domain.Mission;
import umc.umc_spring.domain.Store;

import java.util.List;

public interface MissionRepositoryCustom {
    List<Mission> findInProgressMissions(Long memberId, Long cursor);
    List<Mission> findCompletedMissions(Long memberId, Long cursor);
}
