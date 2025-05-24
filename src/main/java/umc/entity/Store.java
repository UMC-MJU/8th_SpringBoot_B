package umc.entity;

import umc.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Store extends BaseEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "region_id")
        private Region region;

        @Column(length = 50)
        private String name;

        @Column(length = 100)
        private String address;

        @Column(length = 50)
        private String category; // 카테고리 필드 추가

        @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
        private List<Mission> missions = new ArrayList<>();
}
