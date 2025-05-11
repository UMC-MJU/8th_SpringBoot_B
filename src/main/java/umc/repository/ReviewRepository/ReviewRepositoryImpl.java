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
        QMemberMission mm = QMemberMission.memberMission;
        QMember m = QMember.member;
        QMission mi = QMission.mission;
        QStore s = QStore.store;

        return queryFactory
                .select(Projections.constructor(
                        ReviewListDTO.class,
                        m.name.as("nickname"),
                        r.comment,
                        r.createdAt,
                        mi.pointReward,
                        s.name.as("storeName")
                ))
                .from(r)
                .join(mm).on(r.memberMission.eq(mm))
                .join(m).on(mm.member.eq(m))
                .join(mi).on(mm.mission.eq(mi))
                .join(s).on(mi.store.eq(s))
                .where(s.id.eq(storeId))
                .orderBy(r.createdAt.desc())
                .fetch();
    }
}

