package umc.umc_spring.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.umc_spring.domain.common.BaseEntity;

@Entity(name = "food_category")
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class FoodCategory extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 15)
    private String name; //음식 카테고리 이름

}