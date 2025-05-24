package umc.repository.MemberMissionRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.dto.MemberMissionDTO;
import umc.entity.MemberMission;

import java.util.List;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long> {
    boolean existsByMemberIdAndMissionId(Long memberId, Long missionId);

    List<MemberMissionDTO> findMissionsByMemberId(Long memberId, int size, int i);
}
