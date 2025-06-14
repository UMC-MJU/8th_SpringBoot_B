package umc.umc_spring.domain.mapping;

import jakarta.persistence.*;
import lombok.*;
import umc.umc_spring.domain.Member;
import umc.umc_spring.domain.Mission;
import umc.umc_spring.domain.common.BaseEntity;
import umc.umc_spring.domain.enums.MissionStatus;

@Entity(name = "member_mission")
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberMission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(15) DEFAULT 'ACTIVE'")
    private MissionStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission_id")
    private Mission mission;

    public void setMember(Member member) {
        this.member = member;

    }

    public void setMission(Mission mission) {
        this.mission = mission;
    }
}