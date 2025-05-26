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

    //양방향 매핑을 위해
    public void setMember(Member member){
        if(this.member!=null){
            member.getMemberPrefers().remove(this);
        }
        this.member=member;
        member.getMemberPrefers().add(this);
    }

    public void setCategory(FoodCategory foodCategory){
        this.category=foodCategory;
    }
}