package umc.umc_spring.repository.MemberRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.umc_spring.domain.Member;
import umc.umc_spring.domain.QMember;

@Repository
@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom {

    private final JPAQueryFactory jpaQueryFactory;
    private final QMember member = QMember.member;

    @Override
    public Member findMemberById(Long memberId) {
        return jpaQueryFactory
                .selectFrom(member)
                .where(member.id.eq(memberId))
                .fetchOne();
    }
}
