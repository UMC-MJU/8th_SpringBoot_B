package umc.repository.ReviewRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.entity.Review;

public interface ReviewRepository extends JpaRepository<Review, Long>, ReviewRepositoryCustom {
}

