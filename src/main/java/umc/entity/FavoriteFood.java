package umc.entity;

import lombok.Getter;
import lombok.Setter;
import umc.domain.common.BaseEntity;
import jakarta.persistence.*;

@Entity
@Getter
@Setter
public class FavoriteFood extends BaseEntity {

    @EmbeddedId
    private FavoriteFoodId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("memberId")
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("foodId")
    @JoinColumn(name = "food_id")
    private Food food;
}