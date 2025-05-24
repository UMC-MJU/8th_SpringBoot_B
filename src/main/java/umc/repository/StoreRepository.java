package umc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.entity.Store;

public interface StoreRepository extends JpaRepository<Store, Long> {
}
