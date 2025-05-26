package umc.umc_spring.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.umc_spring.domain.Mission;
import umc.umc_spring.repository.MissionRepository.MissionRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionQueryServiceImpl implements MissionQueryService {

    private final MissionRepository missionRepository;

    @Override
    public List<Mission> getInProgressMissions(Long memberId, Long cursor) {
        return missionRepository.findInProgressMissions(memberId, cursor);
    }

    @Override
    public List<Mission> getCompletedMissions(Long memberId, Long cursor) {
        return missionRepository.findCompletedMissions(memberId, cursor);
    }
}