package umc.repository.MemberMissionRepository;

import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.dto.MemberMissionDTO;
import umc.entity.QMember;
import umc.entity.QMemberMission;
import umc.entity.QMission;
import umc.entity.QStore;

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
        QMember mb = QMember.member;

        return queryFactory
                .select(Projections.constructor(
                        MemberMissionDTO.class,
                        mm.id.as("missionId"),
                        m.pointReward,
                        s.name.as("storeName"),
                        mm.status,
                        mm.finish,
                        mm.completedAt
                ))
                .from(mm)
                .innerJoin(m).on(mm.mission.id.eq(m.id))
                .innerJoin(s).on(m.store.id.eq(s.id))
                .innerJoin(mb).on(mm.member.id.eq(mb.id))
                .where(mb.id.eq(memberId)
                        .and(mm.status.in("progress", "completed")))
                .orderBy(mm.completedAt.desc(), mm.id.desc())
                .limit(limit)
                .offset(offset)
                .fetch();
    }
}

