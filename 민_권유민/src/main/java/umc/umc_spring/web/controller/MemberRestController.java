package umc.umc_spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.umc_spring.apiPayload.ApiResponse;
import umc.umc_spring.converter.MemberConverter;
import umc.umc_spring.domain.Member;
import umc.umc_spring.service.MemberService.MemberCommandService;
import umc.umc_spring.web.dto.MemberRequestDTO;
import umc.umc_spring.web.dto.MemberResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/members")
public class MemberRestController {
    private final MemberCommandService memberCommandService;

    @PostMapping("/")
    public ApiResponse<MemberResponseDTO.JoinResultDTO> join(@RequestBody @Valid MemberRequestDTO.JoinDto request){
        Member member = memberCommandService.joinMember(request);
        return ApiResponse.onSuccess(MemberConverter.toJoinResultDTO(member));
    }
}
