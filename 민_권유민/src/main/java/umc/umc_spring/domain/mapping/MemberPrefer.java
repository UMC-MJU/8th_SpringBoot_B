package umc.umc_spring.domain.mapping;

import jakarta.persistence.*;
import lombok.*;
import umc.umc_spring.domain.FoodCategory;
import umc.umc_spring.domain.Member;
import umc.umc_spring.domain.common.BaseEntity;

@Entity(name = "member_prefer")
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberPrefer extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private FoodCategory category;
}