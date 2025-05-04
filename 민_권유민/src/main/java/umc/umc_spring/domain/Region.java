package umc.umc_spring.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.umc_spring.domain.common.BaseEntity;
import umc.umc_spring.domain.mapping.MemberMission;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "region")
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Region extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 15)
    private String name; //지역명

//  보통 지역은 수정/삭제를 잘 하지 않기에 양방향 연결 불필요.
//    @OneToMany(mappedBy = "region", cascade = CascadeType.ALL)
//    private List<Store> storeList = new ArrayList<>();
    
}