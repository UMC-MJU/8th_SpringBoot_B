package umc.repository.MemberRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.dto.MemberHomeDTO;
import umc.dto.MemberInfoDTO;
import umc.entity.Member;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findFirstByOrderByIdAsc();
    MemberInfoDTO findMemberInfoById(Long memberId);
    MemberHomeDTO findHomeInfoByMemberId(Long memberId);
}
