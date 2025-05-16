package umc.umc_spring.repository.MissionRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.umc_spring.domain.Mission;
import umc.umc_spring.domain.QMember;
import umc.umc_spring.domain.QMission;
import umc.umc_spring.domain.QStore;
import umc.umc_spring.domain.enums.MissionStatus;
import umc.umc_spring.domain.mapping.QMemberMission;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MissionRepositoryImpl implements MissionRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;

    private final QMission mission = QMission.mission;
    private final QStore store = QStore.store;
    private final QMember member = QMember.member;
    private final QMemberMission memberMission = QMemberMission.memberMission;

    //진행중 미션 조회
    @Override
    public List<Mission> findInProgressMissions(Long memberId, Long cursor) {
        return jpaQueryFactory
                .selectFrom(mission)
                .join(mission.store, store).fetchJoin()
                .join(memberMission).on(memberMission.mission.eq(mission))
                .join(member).on(memberMission.member.eq(member))
                .where(
                        member.id.eq(memberId),
                        memberMission.status.eq(MissionStatus.IN_PROGRESS),
                        mission.id.lt(cursor)
                )
                .orderBy(mission.id.desc())
                .limit(10)
                .fetch();
    }

    @Override
    public List<Mission> findCompletedMissions(Long memberId, Long cursor) {
        return jpaQueryFactory
                .selectFrom(mission)
                .join(mission.store, store).fetchJoin()
                .join(memberMission).on(memberMission.mission.eq(mission))
                .join(member).on(memberMission.member.eq(member))
                .where(
                        member.id.eq(memberId),
                        memberMission.status.eq(MissionStatus.COMPLETED),
                        mission.id.lt(cursor)
                )
                .orderBy(mission.id.desc())
                .limit(10)
                .fetch();
    }
}