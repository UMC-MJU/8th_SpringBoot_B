package umc.umc_spring.repository.MemberRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.umc_spring.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Long>, MemberRepositoryCustom {

}