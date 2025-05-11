package umc.dto;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class MemberMissionDTO {
    private Long missionId;
    private Integer pointReward;
    private String storeName;
    private String status;
    private Boolean finish;
    private LocalDateTime completedAt;

    public MemberMissionDTO(Long missionId, Integer pointReward, String storeName,
                            String status, Boolean finish, LocalDateTime completedAt) {
        this.missionId = missionId;
        this.pointReward = pointReward;
        this.storeName = storeName;
        this.status = status;
        this.finish = finish;
        this.completedAt = completedAt;
    }
}
