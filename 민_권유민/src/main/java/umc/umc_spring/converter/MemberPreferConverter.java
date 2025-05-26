package umc.umc_spring.converter;

import umc.umc_spring.domain.FoodCategory;
import umc.umc_spring.domain.Member;
import umc.umc_spring.domain.mapping.MemberPrefer;
import umc.umc_spring.web.dto.MemberRequestDTO;
import umc.umc_spring.web.dto.MemberResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

public class MemberPreferConverter {
    public static List<MemberPrefer> toMemberPreferList(List<FoodCategory> foodCategoryList){
        return foodCategoryList.stream()
                .map(foodCategory ->
                        MemberPrefer.builder()
                                .category(foodCategory)
                                .build()
                ).collect(Collectors.toList());
    }
}
