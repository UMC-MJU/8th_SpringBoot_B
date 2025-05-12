package umc.umc_spring.repository.StoreRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.umc_spring.domain.Store;

public interface StoreRepository extends JpaRepository<Store, Long>, StoreRepositoryCustom {
}