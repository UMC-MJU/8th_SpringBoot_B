package umc.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import umc.annotation.StoreExists;
import umc.repository.StoreRepository;


public class StoreExistsValidator implements ConstraintValidator<StoreExists, Long> {
    private final StoreRepository storeRepository;

    public StoreExistsValidator(StoreRepository storeRepository) {
        this.storeRepository = storeRepository;
    }

    @Override
    public boolean isValid(Long storeId, ConstraintValidatorContext context) {
        return storeId != null && storeRepository.existsById(storeId);
    }
}
