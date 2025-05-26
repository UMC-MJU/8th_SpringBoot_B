package umc.umc_spring.repository.MemberMissionRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.umc_spring.domain.mapping.MemberMission;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {
    boolean existsByMemberIdAndMissionId(Long memberId, Long missionId);
}
