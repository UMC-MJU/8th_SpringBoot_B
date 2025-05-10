package umc.repository.MemberMissionRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.entity.MemberMission;

public interface MemberMissionRepository extends JpaRepository<MemberMission, Long>, MemberMissionRepositoryCustom {
}

