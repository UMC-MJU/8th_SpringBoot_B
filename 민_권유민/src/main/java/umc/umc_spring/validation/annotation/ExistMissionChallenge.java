package umc.umc_spring.validation.annotation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import umc.umc_spring.validation.validator.MissionChallengeValidator;

import java.lang.annotation.*;

@Documented //사용자 정의 어노테이션을 만들 때 붙임
@Constraint(validatedBy = MissionChallengeValidator.class)  // 검증 로직을 구현한 Validator 클래스 지정
@Target({ ElementType.FIELD, ElementType.PARAMETER, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)  // 런타임 동안 유지되어야 합니다.
public @interface ExistMissionChallenge {

    String message() default "이미 도전 중인 미션입니다.";  // 기본 오류 메시지
    Class<?>[] groups() default {};  // 그룹
    Class<? extends Payload>[] payload() default {};  // 추가적인 메타데이터
}
