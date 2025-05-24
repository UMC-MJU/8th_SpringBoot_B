package umc.repository.ReviewRepository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.dto.ReviewListDTO;
import umc.entity.*;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<ReviewListDTO> findReviewsByStoreId(Long storeId) {
        QReview r = QReview.review;
        QMember m = QMember.member;
        QStore s = QStore.store;

        return queryFactory
                .select(Projections.constructor(
                        ReviewListDTO.class,
                        m.name.as("nickname"),
                        r.comment,
                        r.createdAt,
                        r.rating, // rating 필드 유지
                        s.name.as("storeName")
                ))
                .from(r)
                .join(m).on(r.member.eq(m))
                .join(s).on(r.store.eq(s))
                .where(s.id.eq(storeId))
                .orderBy(r.createdAt.desc())
                .fetch();
    }
}
