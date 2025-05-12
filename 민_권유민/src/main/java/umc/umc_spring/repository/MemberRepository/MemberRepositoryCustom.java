package umc.umc_spring.repository.MemberRepository;

import umc.umc_spring.domain.Member;

public interface MemberRepositoryCustom {
    Member findMemberById(Long memberId);
}