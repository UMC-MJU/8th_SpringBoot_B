package umc.umc_spring.repository.ReviewRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.umc_spring.domain.Review;

public interface ReviewRepository extends JpaRepository<Review, Long>, ReviewRepositoryCustom {
}
