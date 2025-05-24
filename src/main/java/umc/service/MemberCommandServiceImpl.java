package umc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.converter.MemberConverter;
import umc.dto.MemberRequestDTO;
import umc.entity.FavoriteFood;
import umc.entity.FavoriteFoodId;
import umc.entity.Food;
import umc.entity.Member;
import umc.repository.FoodRepository;
import umc.repository.MemberRepository.MemberRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService {

    private final MemberRepository memberRepository;
    private final FoodRepository foodRepository;

    @Override
    @Transactional
    public Member joinMember(MemberRequestDTO.JoinDto request) {

        Member newMember = MemberConverter.toMember(request);
        Member savedMember = memberRepository.save(newMember);

        if (request.getPreferCategory() != null && !request.getPreferCategory().isEmpty()) {
            List<Food> foodList = request.getPreferCategory().stream()
                    .map(categoryId -> foodRepository.findById(categoryId)
                            .orElseThrow(() -> new IllegalArgumentException("Food not found with ID: " + categoryId)))
                    .collect(Collectors.toList());

            List<FavoriteFood> favoriteFoodList = foodList.stream()
                    .map(food -> {
                        FavoriteFoodId id = new FavoriteFoodId();
                        id.setMemberId(savedMember.getId());
                        id.setFoodId(food.getId());

                        FavoriteFood favoriteFood = new FavoriteFood();
                        favoriteFood.setId(id);
                        favoriteFood.setMember(savedMember);
                        favoriteFood.setFood(food);
                        return favoriteFood;
                    })
                    .collect(Collectors.toList());

            savedMember.getFavoriteFoods().addAll(favoriteFoodList);
        }

        return savedMember;
    }
}
