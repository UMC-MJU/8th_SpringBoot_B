package umc.entity;

import umc.domain.common.BaseEntity;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Review extends BaseEntity {
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "member_mission_id")
        private MemberMission memberMission;

        @Column(columnDefinition = "TEXT")
        private String comment;

        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
}