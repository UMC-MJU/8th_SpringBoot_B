package umc.entity;

import umc.domain.common.BaseEntity;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Mission extends BaseEntity {
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "store_id")
        private Store store;

        private Long pointReward;

        @Column(length = 10, unique = true)
        private String missionCode;

        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;

        private LocalDate endDate;

        @OneToMany(mappedBy = "mission", cascade = CascadeType.ALL)
        private List<MemberMission> memberMissions = new ArrayList<>();
}
