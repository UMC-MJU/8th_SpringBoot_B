package umc.repository.MissionRepository;

import umc.dto.MissionListDTO;

import java.util.List;

public interface MissionRepositoryCustom {
    List<MissionListDTO> findAvailableMissionsByRegion(String regionName, int limit, int offset);
}

