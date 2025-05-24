package umc.entity;

import lombok.*;
import umc.domain.common.BaseEntity;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "foods")
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
        public class Food extends BaseEntity {

                @Id
                @GeneratedValue(strategy = GenerationType.IDENTITY)
                private Long id;

                private String name;
        }

