package umc.repository.MemberRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.entity.Member;

public interface MemberRepository extends JpaRepository<Member, Long>, MemberRepositoryCustom {

}

