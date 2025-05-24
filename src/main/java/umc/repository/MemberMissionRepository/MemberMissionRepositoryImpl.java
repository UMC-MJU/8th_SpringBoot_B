package umc.repository.MemberMissionRepository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.dto.MemberMissionDTO; // DTO 클래스 가정
import umc.entity.*;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberMissionRepositoryImpl implements MemberMissionRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<MemberMissionDTO> findMissionsByMemberId(Long memberId, int limit, int offset) {
        QMemberMission mm = QMemberMission.memberMission;
        QMission m = QMission.mission;
        QStore s = QStore.store;

        return queryFactory
                .select(Projections.constructor(
                        MemberMissionDTO.class,
                        mm.id,
                        m.title,
                        s.name.as("storeName"),
                        mm.status,
                        mm.finish,
                        mm.completedAt
                ))
                .from(mm)
                .join(m).on(mm.mission.eq(m))
                .join(s).on(m.store.eq(s))
                .where(mm.member.id.eq(memberId))
                .orderBy(mm.completedAt.desc(), mm.id.desc())
                .limit(limit)
                .offset(offset)
                .fetch();
    }
}
