package umc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.dto.MemberHomeDTO;
import umc.dto.MemberInfoDTO;
import umc.repository.MemberRepository.MemberRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberHomeDTO getHomeInfo(Long memberId) {
        return memberRepository.findHomeInfoByMemberId(memberId);
    }

    public MemberInfoDTO getMemberInfo(Long memberId) {
        return memberRepository.findMemberInfoById(memberId);
    }
}