package umc.entity;

import umc.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Review extends BaseEntity {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "member_id")
        private Member member;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "store_id")
        private Store store;

        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "member_mission_id")
        private MemberMission memberMission; // MemberMission과의 관계 추가

        @Column(columnDefinition = "TEXT")
        private String comment;

        private int rating;

        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
}
