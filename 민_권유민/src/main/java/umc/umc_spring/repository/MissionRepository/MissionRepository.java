package umc.umc_spring.repository.MissionRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.umc_spring.domain.Mission;

public interface MissionRepository extends JpaRepository<Mission, Long>, MissionRepositoryCustom{
}
