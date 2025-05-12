package umc.umc_spring.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.umc_spring.domain.common.BaseEntity;
import umc.umc_spring.domain.mapping.MemberMission;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "store")
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Store extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 15)
    private String name; //가게명

    @Column(nullable = false, length = 40)
    private String address; //가게 주소

    private Float score; //총 평점

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "region_id")
    private Region region;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<Review> reviewList = new ArrayList<>();

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<Mission> missionList = new ArrayList<>();

    @Override
    public String toString() {
        return "Store{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", score=" + score +
                ", region=" + (region != null ? region.getName() : "N/A") + // region의 이름 출력
                '}';
    }
}