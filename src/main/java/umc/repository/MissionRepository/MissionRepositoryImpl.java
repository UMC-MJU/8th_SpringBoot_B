package umc.repository.MissionRepository;

import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import umc.dto.MissionListDTO;
import umc.entity.QMission;
import umc.entity.QRegion;
import umc.entity.QStore;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class MissionRepositoryImpl implements MissionRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<MissionListDTO> findAvailableMissionsByRegion(String regionName, int limit, int offset) {
        QMission mission = QMission.mission;
        QStore store = QStore.store;
        QRegion region = QRegion.region;

        List<Tuple> results = queryFactory
                .select(
                        mission.id,
                        mission.missionCode, // missionCode 유지, 또는 다른 필드 이름으로 수정
                        store.name,
                        store.address,
                        mission.pointReward, // pointReward 대신 points로 수정
                        mission.endDate
                )
                .from(mission)
                .join(store).on(mission.store.id.eq(store.id))
                .join(region).on(store.region.id.eq(region.id))
                .where(
                        region.name.eq(regionName),
                        mission.endDate.goe(LocalDate.now())
                )
                .orderBy(mission.endDate.asc())
                .limit(limit)
                .offset(offset)
                .fetch();

        LocalDate today = LocalDate.now();

        return results.stream()
                .map(tuple -> new MissionListDTO(
                        tuple.get(0, Long.class),          // mission.id
                        tuple.get(1, String.class),        // mission.missionCode
                        tuple.get(2, String.class),        // store.name
                        tuple.get(3, String.class),        // store.address
                        tuple.get(4, Integer.class),       // mission.points
                        (int) ChronoUnit.DAYS.between(today, tuple.get(5, LocalDate.class))
                ))
                .collect(Collectors.toList());
    }
}
