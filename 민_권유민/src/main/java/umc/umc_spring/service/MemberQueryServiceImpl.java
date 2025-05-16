package umc.umc_spring.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.umc_spring.domain.Member;
import umc.umc_spring.domain.Mission;
import umc.umc_spring.repository.MemberRepository.MemberRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberQueryServiceImpl implements MemberQueryService{
    private final MemberRepository memberRepository;

    @Override
    public Member getMemberById(Long memberId) {
        Member member = memberRepository.findMemberById(memberId);
        if (member == null) {
            throw new EntityNotFoundException("해당 ID의 회원을 찾을 수 없습니다: " + memberId);
        }
        return member;
    }

}
