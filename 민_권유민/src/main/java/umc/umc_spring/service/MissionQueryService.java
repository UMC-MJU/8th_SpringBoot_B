package umc.umc_spring.service;

import umc.umc_spring.domain.Mission;

import java.util.List;

public interface MissionQueryService {
    List<Mission> getInProgressMissions(Long memberId, Long cursor);
    List<Mission> getCompletedMissions(Long memberId, Long cursor);
}