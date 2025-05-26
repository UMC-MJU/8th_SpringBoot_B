package umc.umc_spring.service.MemberService;

import umc.umc_spring.domain.Member;
import umc.umc_spring.web.dto.MemberRequestDTO;

public interface MemberCommandService {

    Member joinMember(MemberRequestDTO.JoinDto request);
}
