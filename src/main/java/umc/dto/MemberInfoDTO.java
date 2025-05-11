package umc.dto;

import lombok.Getter;

@Getter
public class MemberInfoDTO {
    private Long memberId;
    private String nickname;
    private String email;
    private String phoneNumberCheck;

    public MemberInfoDTO(Long memberId, String nickname, String email, String phoneNumberCheck) {
        this.memberId = memberId;
        this.nickname = nickname;
        this.email = email;
        this.phoneNumberCheck = phoneNumberCheck;
    }
}

