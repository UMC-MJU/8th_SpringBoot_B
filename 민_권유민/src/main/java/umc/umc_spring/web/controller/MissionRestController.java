package umc.umc_spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.umc_spring.apiPayload.ApiResponse;
import umc.umc_spring.converter.MissionConverter;
import umc.umc_spring.domain.Mission;
import umc.umc_spring.service.MissionService.MissionCommandService;
import umc.umc_spring.web.dto.MissionRequestDTO;
import umc.umc_spring.web.dto.MissionResponseDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionRestController {
    public final MissionCommandService missionCommandService;

    @PostMapping("/")
    public ApiResponse<MissionResponseDTO.JoinResultDTO> join(@RequestBody @Valid MissionRequestDTO.joinDTO request){
        Mission mission = missionCommandService.joinMission(request);
        return ApiResponse.onSuccess(MissionConverter.toJoinResultDTO(mission));
    }
}
