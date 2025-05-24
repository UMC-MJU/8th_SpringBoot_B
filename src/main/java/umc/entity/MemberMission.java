package umc.entity;

import lombok.*;
import umc.domain.common.BaseEntity;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
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

        @Column(length = 15)
        private String status;

        private boolean finish;
        private LocalDateTime completedAt;

        @Builder.Default
        @OneToMany(mappedBy = "memberMission", cascade = CascadeType.ALL)
        private List<Review> reviews = new ArrayList<>();
}
