package umc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.dto.MemberMissionDTO;
import umc.repository.MemberMissionRepository.MemberMissionRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberMissionService {
    private final MemberMissionRepository memberMissionRepository;

    public List<MemberMissionDTO> getMemberMissions(Long memberId, int page, int size) {
        return memberMissionRepository.findMissionsByMemberId(memberId, size, page * size);
    }
}
