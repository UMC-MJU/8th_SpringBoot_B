package umc.repository.MissionRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.entity.Mission;

public interface MissionRepository extends JpaRepository<Mission, Long> {
    boolean existsById(Long id);
}
