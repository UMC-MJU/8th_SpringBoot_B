package umc.entity;

import umc.domain.common.BaseEntity;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Region extends BaseEntity {

        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(length = 50)
        private String name;

        @OneToMany(mappedBy = "region", cascade = CascadeType.ALL)
        private List<MissionRecord> missionRecords = new ArrayList<>();

        @OneToMany(mappedBy = "region", cascade = CascadeType.ALL)
        private List<Store> stores = new ArrayList<>();
}
