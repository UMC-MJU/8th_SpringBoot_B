package umc.umc_spring.service.MemberService;

import umc.umc_spring.domain.Member;

public interface MemberQueryService {
   Member getMemberById(Long memberId);
}
