package umc.umc_spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import umc.umc_spring.repository.MemberMissionRepository.MemberMissionRepository;
import umc.umc_spring.repository.MissionRepository.MissionRepository;
import umc.umc_spring.validation.annotation.ExistMissionChallenge;

@Component
@RequiredArgsConstructor
public class MissionChallengeValidator implements ConstraintValidator<ExistMissionChallenge, Long> {
    private final MemberMissionRepository memberMissionRepository;  // 미션 도전 기록을 조회할 Repository

    @Override
    public boolean isValid(Long missionId, ConstraintValidatorContext context) {
        Long memberId = 1L;

        // 1. 해당 미션에 도전 중인 멤버가 있는지 체크
        boolean exists = memberMissionRepository.existsByMemberIdAndMissionId(memberId, missionId);

        // 2. 도전 중이면 false 반환하여 검증 실패
        if (exists) {
            context.disableDefaultConstraintViolation();  // 기본 오류 메시지 비활성화
            context.buildConstraintViolationWithTemplate("이미 해당 미션을 도전한 멤버입니다.").addConstraintViolation();  // 오류 메시지 추가
        }

        return !exists;  // 이미 도전한 미션이면 false 반환
    }

}
