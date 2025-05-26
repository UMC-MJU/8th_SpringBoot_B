package umc.umc_spring.apiPayload.exception.handler;

import umc.umc_spring.apiPayload.code.BaseErrorCode;
import umc.umc_spring.apiPayload.exception.GeneralException;

public class FoodCategoryHandler extends GeneralException {
    public FoodCategoryHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }

}
