package umc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.converter.MemberMissionConverter;
import umc.converter.MissionConverter;
import umc.dto.MissionRequestDTO;
import umc.entity.Member;
import umc.entity.MemberMission;
import umc.entity.Mission;
import umc.entity.Store;
import umc.repository.MemberMissionRepository.MemberMissionRepository;
import umc.repository.MemberRepository.MemberRepository;
import umc.repository.MissionRepository.MissionRepository;
import umc.repository.StoreRepository;

@Service
@RequiredArgsConstructor
public class MissionService {
    private final MissionRepository missionRepository;
    private final StoreRepository storeRepository;
    private final MemberMissionRepository memberMissionRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public Mission addMission(MissionRequestDTO request, Long storeId) {
        Store store = storeRepository.findById(storeId)
                .orElseThrow(() -> new IllegalArgumentException("Store not found with ID: " + storeId));
        Mission newMission = MissionConverter.toMission(request, store);
        return missionRepository.save(newMission);
    }

    @Transactional
    public MemberMission challengeMission(Long missionId) {
        Member member = memberRepository.findFirstByOrderByIdAsc()
                .orElseThrow(() -> new IllegalStateException("No member found in DB"));

        Mission mission = missionRepository.findById(missionId)
                .orElseThrow(() -> new IllegalArgumentException("Mission not found with ID: " + missionId));

        MemberMission newChallenge = MemberMissionConverter.toMemberMission(member, mission);
        return memberMissionRepository.save(newChallenge);
    }
}
