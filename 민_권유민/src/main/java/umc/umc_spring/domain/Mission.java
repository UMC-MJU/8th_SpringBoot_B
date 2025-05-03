package umc.umc_spring.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.umc_spring.domain.common.BaseEntity;
import umc.umc_spring.domain.mapping.MemberMission;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "mission")
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Mission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String title; //미션명

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content; //미션 내용

    private Integer reward; //미션 보상

    private LocalDate deadline; //미션 마감일

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    @OneToMany(mappedBy = "mission", cascade = CascadeType.ALL)
    private List<MemberMission> memberMissionList = new ArrayList<>();
}