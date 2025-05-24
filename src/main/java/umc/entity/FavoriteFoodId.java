package umc.entity;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
@Setter
public class FavoriteFoodId implements Serializable{

    private Long memberId;
    private Long foodId;

    // equals, hashCode 필수
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FavoriteFoodId)) return false;
        FavoriteFoodId that = (FavoriteFoodId) o;
        return Objects.equals(memberId, that.memberId) &&
                Objects.equals(foodId, that.foodId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberId, foodId);
    }
}
