package umc.dto;

import lombok.Getter;

@Getter
public class MemberHomeDTO {
    private Long memberId;
    private String nickname;
    private Long totalPoints;
    private Long completedMissions;
    private Integer rewardPoints;

    public MemberHomeDTO(Long memberId, String nickname, Long totalPoints, Long completedMissions, Integer rewardPoints) {
        this.memberId = memberId;
        this.nickname = nickname;
        this.totalPoints = totalPoints;
        this.completedMissions = completedMissions;
        this.rewardPoints = rewardPoints;
    }
}


