package umc.repository.MemberRepository;


import com.querydsl.core.types.dsl.CaseBuilder;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.dto.MemberHomeDTO;
import umc.dto.MemberInfoDTO;
import umc.entity.QMember;
import umc.entity.QMemberMission;
import umc.entity.QSocialLogin;
import umc.entity.Member;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public MemberHomeDTO findHomeInfoByMemberId(Long memberId) {
        QMember member = QMember.member;
        QMemberMission memberMission = QMemberMission.memberMission;

        // 1. 회원 기본 정보
        Member memberEntity = queryFactory
                .selectFrom(member)
                .where(member.id.eq(memberId))
                .fetchOne();

        if (memberEntity == null) return null;

        // 2. 완료 미션 수
        Long completedMissions = queryFactory
                .select(memberMission.count())
                .from(memberMission)
                .where(memberMission.member.id.eq(memberId)
                        .and(memberMission.status.eq("completed")))
                .fetchOne();

        completedMissions = completedMissions != null ? completedMissions : 0L;
        Integer rewardPoints = (int)((completedMissions / 10) * 1000);

        return new MemberHomeDTO(
                memberEntity.getId(),
                memberEntity.getName(),
                memberEntity.getTotalPoints(),
                completedMissions,
                rewardPoints
        );
    }

    @Override
    public MemberInfoDTO findMemberInfoById(Long memberId) {
        QMember member = QMember.member;
        QSocialLogin socialLogin = QSocialLogin.socialLogin;

        return queryFactory
                .select(Projections.constructor(
                        MemberInfoDTO.class,
                        member.id.as("memberId"),
                        member.name.as("nickname"),
                        member.email,
                        new CaseBuilder()
                                .when(socialLogin.socialType.isNull())
                                .then("미인증")
                                .otherwise("인증됨")
                                .as("phoneNumberCheck"),
                        member.totalPoints.as("myPoints")
                ))
                .from(member)
                .leftJoin(socialLogin).on(socialLogin.member.id.eq(member.id))
                .where(member.id.eq(memberId))
                .fetchOne();
    }
}
