package umc.umc_spring.service.MemberMissionService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.umc_spring.converter.MemberMissionConverter;
import umc.umc_spring.domain.Member;
import umc.umc_spring.domain.Mission;
import umc.umc_spring.domain.mapping.MemberMission;
import umc.umc_spring.repository.MemberMissionRepository.MemberMissionRepository;
import umc.umc_spring.repository.MemberRepository.MemberRepository;
import umc.umc_spring.repository.MissionRepository.MissionRepository;
import umc.umc_spring.web.dto.MemberMissionRequestDTO;

@Service
@RequiredArgsConstructor
public class MemberMissionServiceImpl implements MemberMissionService{
    public final MemberMissionRepository memberMissionRepository;
    public final MemberRepository memberRepository;
    public final MissionRepository missionRepository;

    @Override
    public MemberMission joinMemberMission(MemberMissionRequestDTO.joinDTO request) {
        MemberMission memberMission = MemberMissionConverter.toMemberMission(request);
        Member member = memberRepository.findById(request.getMemberid()).get();
        Mission mission = missionRepository.findById(request.getMissionid()).get();
        memberMission.setMember(member);
        memberMission.setMission(mission);

        return memberMissionRepository.save(memberMission);
    }
}
