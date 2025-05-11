package umc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.dto.MissionListDTO;
import umc.repository.MissionRepository.MissionRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MissionService {
    private final MissionRepository missionRepository;

    public List<MissionListDTO> getAvailableMissions(String regionName, int page, int size) {
        return missionRepository.findAvailableMissionsByRegion(regionName, size, page * size);
    }
}

