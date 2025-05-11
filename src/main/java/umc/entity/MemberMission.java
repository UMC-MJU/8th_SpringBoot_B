package umc.entity;

import umc.domain.common.BaseEntity;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class MemberMission extends BaseEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "member_id")
        private Member member;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "mission_id")
        private Mission mission;

        @Column(length = 50)
        private String status;

        @Column(nullable = false)
        private Boolean finish;

        @Column
        private LocalDateTime completedAt;

        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;

        @OneToMany(mappedBy = "memberMission", cascade = CascadeType.ALL)
        private List<Review> reviews = new ArrayList<>();
}
