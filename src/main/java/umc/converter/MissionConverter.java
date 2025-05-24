package umc.converter;

import umc.dto.MissionRequestDTO;
import umc.entity.Mission;
import umc.entity.Store;

public class MissionConverter {
    public static Mission toMission(MissionRequestDTO request, Store store) {
        return Mission.builder()
                .title(request.getTitle())
                .description(request.getDescription())
                .pointReward(request.getPoints())
                .store(store)
                .build();
    }
}
