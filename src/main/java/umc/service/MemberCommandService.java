package umc.service;

import umc.dto.MemberRequestDTO;
import umc.entity.Member;

public interface MemberCommandService {

    Member joinMember(MemberRequestDTO.JoinDto request);
}