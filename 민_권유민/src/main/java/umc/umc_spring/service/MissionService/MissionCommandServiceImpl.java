package umc.umc_spring.service.MissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.umc_spring.converter.MissionConverter;
import umc.umc_spring.domain.Mission;
import umc.umc_spring.domain.Store;
import umc.umc_spring.repository.MissionRepository.MissionRepository;
import umc.umc_spring.repository.StoreRepository.StoreRepository;
import umc.umc_spring.web.dto.MissionRequestDTO;

@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService{
    public final StoreRepository storeRepository;
    public final MissionRepository missionRepository;

    @Override
    public Mission joinMission(MissionRequestDTO.joinDTO request) {
        Mission mission = MissionConverter.toMission(request);
        Store store = storeRepository.findById(request.getStoreid()).get();
        mission.setStore(store);
        return missionRepository.save(mission);
    }
}
