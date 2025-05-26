package umc.umc_spring.converter;

import umc.umc_spring.domain.Member;
import umc.umc_spring.domain.enums.Gender;
import umc.umc_spring.web.dto.MemberRequestDTO;
import umc.umc_spring.web.dto.MemberResponseDTO;

import java.util.ArrayList;

public class MemberConverter {
    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Member member){
        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(member.getCreatedAt())
                .build();
    }

    public static Member toMember(MemberRequestDTO.JoinDto request){
        Gender gender = null;
        switch(request.getGender()){
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.MALE;
                break;
            case 3:
                gender = Gender.MALE;
                break;
        }

        return Member.builder()
                .address(request.getAddress())
                .phoneNumber(request.getPhoneNumber())
                .email(request.getEmail())
                .gender(gender)
                .name(request.getName())
                .memberPrefers(new ArrayList<>())
                .build();
    }


}
