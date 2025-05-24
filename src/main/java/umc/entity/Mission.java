package umc.entity;

import umc.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Mission extends BaseEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "store_id")
        private Store store;

        private String title;
        private String description;
        private int pointReward;

        @Column(length = 10, unique = true)
        private String missionCode;

        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;

        private LocalDate endDate;

        @Builder.Default
        @OneToMany(mappedBy = "mission", cascade = CascadeType.ALL)
        private List<MemberMission> memberMissions = new ArrayList<>();
}
