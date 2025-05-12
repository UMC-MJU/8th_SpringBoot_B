package umc.umc_spring.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.umc_spring.domain.common.BaseEntity;
import umc.umc_spring.domain.mapping.MemberMission;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "review")
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Review extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content; //리뷰 내용

    private Float score; //평점

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "store_id")
    private Store store;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

}