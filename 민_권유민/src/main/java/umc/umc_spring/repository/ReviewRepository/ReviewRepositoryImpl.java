package umc.umc_spring.repository.ReviewRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import umc.umc_spring.domain.QReview;
import umc.umc_spring.domain.Review;
import umc.umc_spring.domain.Store;

import java.time.LocalDateTime;

@Repository
@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepositoryCustom {

}