package umc.entity;

import umc.domain.common.BaseEntity;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class SocialLogin extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(length = 255)
    private String socialType;

    @Column(length = 255, unique = true)
    private String socialId;

    @Column(length = 255)
    private String profileImage;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
