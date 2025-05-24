package umc.converter;

import umc.entity.Member;
import umc.entity.MemberMission;
import umc.entity.Mission;

public class MemberMissionConverter {
    public static MemberMission toMemberMission(Member member, Mission mission) {
        return MemberMission.builder()
                .member(member)
                .mission(mission)
                .status("CHALLENGING")
                .build();
    }
}
