package umc.dto;

import lombok.Getter;

@Getter
public class MissionListDTO {
    private Long missionId;
    private String missionDetail;
    private String storeName;
    private String storeAddress;
    private Integer rewardPoints;
    private Integer daysRemaining;

    public MissionListDTO(Long missionId, String missionDetail, String storeName, String storeAddress, Integer rewardPoints, Integer daysRemaining) {
        this.missionId = missionId;
        this.missionDetail = missionDetail;
        this.storeName = storeName;
        this.storeAddress = storeAddress;
        this.rewardPoints = rewardPoints;
        this.daysRemaining = daysRemaining;
    }
}