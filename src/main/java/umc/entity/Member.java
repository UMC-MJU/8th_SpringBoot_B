package umc.entity;

import umc.domain.common.BaseEntity;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
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

        public Long getId() {
                return id;
        }

        public String getName() { // 추가
                return name;
        }

        public String getEmail() { // 추가
                return email;
        }

        public Long getTotalPoints() {
                return totalPoints;
        }
}
