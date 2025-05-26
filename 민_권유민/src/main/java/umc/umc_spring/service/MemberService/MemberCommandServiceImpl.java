package umc.umc_spring.service.MemberService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.umc_spring.apiPayload.code.status.ErrorStatus;
import umc.umc_spring.apiPayload.exception.handler.FoodCategoryHandler;
import umc.umc_spring.converter.MemberConverter;
import umc.umc_spring.converter.MemberPreferConverter;
import umc.umc_spring.domain.FoodCategory;
import umc.umc_spring.domain.Member;
import umc.umc_spring.domain.mapping.MemberPrefer;
import umc.umc_spring.repository.FoodCategoryRepository.FoodCategoryRepository;
import umc.umc_spring.repository.MemberRepository.MemberRepository;
import umc.umc_spring.web.dto.MemberRequestDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService{
    private final MemberRepository memberRepository;
    private final FoodCategoryRepository foodCategoryRepository;

    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDto request){
        Member member = MemberConverter.toMember(request);
        List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
                .map(category -> {
                        return foodCategoryRepository.findById(category).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());
        List<MemberPrefer> memberPreferList = MemberPreferConverter.toMemberPreferList(foodCategoryList);
        memberPreferList.forEach(memberPrefer -> {memberPrefer.setMember(member);});
        return memberRepository.save(member);
    }
}
