package umc.entity;

import umc.domain.common.BaseEntity;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "foods")
public class Food extends BaseEntity {

        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(length = 15)
        private String foodName;

        @OneToMany(mappedBy = "food", cascade = CascadeType.ALL)
        private List<FavoriteFood> favoriteFoods = new ArrayList<>();
}

