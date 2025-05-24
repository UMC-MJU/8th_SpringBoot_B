package umc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.entity.Food;

public interface FoodRepository extends JpaRepository<Food, Long> {
}

