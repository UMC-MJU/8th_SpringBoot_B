package umc.umc_spring.domain;
import jakarta.persistence.*;
import lombok.*;
import umc.umc_spring.domain.common.BaseEntity;
import umc.umc_spring.domain.enums.Gender;
import umc.umc_spring.domain.enums.SocialType;
import umc.umc_spring.domain.enums.MemberStatus;
import umc.umc_spring.domain.mapping.MemberMission;
import umc.umc_spring.domain.mapping.MemberPrefer;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "member")
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 15)
    private String name; //사용자 이름

    @Column(nullable = false, length = 20)
    private String email; //사용자 이메일

    @Column(nullable = false, length = 40)
    private String address; //사용자 주소

    @Column(nullable = false, length = 15)
    private String phoneNumber; //휴대전화 번호

    private LocalDate inactiveDate; //활동시간

    private Integer point; //사용자 점수

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(15) DEFAULT 'ACTIVE'")
    private MemberStatus status; //사용자 상태

    @Enumerated(EnumType.STRING)
    private SocialType socialType; //소셜로그인 타입

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10)")
    private Gender gender; //성별

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberPrefer> memberPrefers = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<MemberMission> memberMissionList = new ArrayList<>();

}
