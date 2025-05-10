package umc.entity;

import umc.domain.common.BaseEntity;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Store extends BaseEntity {

        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "region_id")
        private Region region;

        @Column(length = 50)
        private String name;

        @Column(length = 100)
        private String address;

        @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
        private List<Mission> missions = new ArrayList<>();
}
