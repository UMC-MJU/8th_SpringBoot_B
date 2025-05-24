package umc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.entity.Region;

public interface RegionRepository extends JpaRepository<Region, Long> {
}
