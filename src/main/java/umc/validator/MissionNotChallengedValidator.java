package umc.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import umc.annotation.MissionNotChallenged;
import umc.repository.MemberMissionRepository.MemberMissionRepository;


public class MissionNotChallengedValidator implements ConstraintValidator<MissionNotChallenged, Long> {
    private final MemberMissionRepository memberMissionRepository;

    public MissionNotChallengedValidator(MemberMissionRepository memberMissionRepository) {
        this.memberMissionRepository = memberMissionRepository;
    }

    @Override
    public boolean isValid(Long missionId, ConstraintValidatorContext context) {
        Long memberId = 1L;
        return missionId != null && !memberMissionRepository.existsByMemberIdAndMissionId(memberId, missionId);
    }
}
