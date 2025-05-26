package umc.umc_spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.umc_spring.apiPayload.ApiResponse;
import umc.umc_spring.converter.MemberMissionConverter;
import umc.umc_spring.domain.mapping.MemberMission;
import umc.umc_spring.service.MemberMissionService.MemberMissionService;
import umc.umc_spring.web.dto.MemberMissionRequestDTO;
import umc.umc_spring.web.dto.MemberMissionResponseDTO;
import umc.umc_spring.web.dto.MemberResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/membermissions")
public class MemberMissionRestController {
    public final MemberMissionService memberMissionService;

    @PostMapping("/")
    public ApiResponse<MemberMissionResponseDTO.joinResultDTO> join(@RequestBody @Valid MemberMissionRequestDTO.joinDTO request){
        MemberMission memberMission = memberMissionService.joinMemberMission(request);
        return ApiResponse.onSuccess(MemberMissionConverter.toJoinResultDTO(memberMission));
    }
}
