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
public class Member extends BaseEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @Column(length = 10, nullable = false)
        private String name;

        @Column(length = 50, unique = true)
        private String email;

        @Column(length = 10)
        private String gender;

        private LocalDate birth;

        @Column(length = 50)
        private String address;

        @Column(length = 100)
        private String specAddress; // 상세 주소 필드 추가

        @Column(length = 15)
        private String food;

        private Long totalPoints;

        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;

        @Column(length = 15)
        private String status;

        private LocalDateTime inactiveDate;

        // 연관관계
        @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
        private List<SocialLogin> socialLogins = new ArrayList<>();

        @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
        private List<MemberMission> memberMissions = new ArrayList<>();

        @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
        private List<MissionRecord> missionRecords = new ArrayList<>();

        @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
        private List<FavoriteFood> favoriteFoods = new ArrayList<>();
}
