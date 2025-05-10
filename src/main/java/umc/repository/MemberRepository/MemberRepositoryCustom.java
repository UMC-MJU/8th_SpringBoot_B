package umc.repository.MemberRepository;

import umc.dto.MemberHomeDTO;
import umc.dto.MemberInfoDTO;

public interface MemberRepositoryCustom {
    MemberHomeDTO findHomeInfoByMemberId(Long memberId);
    MemberInfoDTO findMemberInfoById(Long memberId);
}

