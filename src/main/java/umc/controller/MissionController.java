package umc.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.annotation.MissionNotChallenged;
import umc.annotation.StoreExists;
import umc.dto.MissionRequestDTO;
import umc.entity.MemberMission;
import umc.entity.Mission;
import umc.service.MissionService;


@RestController
@RequestMapping("/stores")
@RequiredArgsConstructor
@Validated
public class MissionController {
    private final MissionService missionService;

    @PostMapping("/{store-id}/missions")
    public ResponseEntity<Mission> addMission(@PathVariable("store-id") @StoreExists Long storeId, @RequestBody @Valid MissionRequestDTO request) {
        Mission savedMission = missionService.addMission(request, storeId);
        return new ResponseEntity<>(savedMission, HttpStatus.CREATED);
    }

    @PostMapping("/{store-id}/missions/{mission-id}/challenge")
    public ResponseEntity<MemberMission> challengeMission(
            @PathVariable("store-id") @StoreExists Long storeId,
            @PathVariable("mission-id") @MissionNotChallenged Long missionId) {
        MemberMission savedChallenge = missionService.challengeMission(missionId);
        return new ResponseEntity<>(savedChallenge, HttpStatus.CREATED);
    }
}
