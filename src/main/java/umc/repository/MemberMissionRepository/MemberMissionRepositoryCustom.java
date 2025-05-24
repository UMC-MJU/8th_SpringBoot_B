package umc.repository.MemberMissionRepository;

import umc.dto.MemberMissionDTO;

import java.util.List;

public interface MemberMissionRepositoryCustom {
    List<MemberMissionDTO> findMissionsByMemberId(Long memberId, int limit, int offset);
}
