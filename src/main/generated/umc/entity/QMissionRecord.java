package umc.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMissionRecord is a Querydsl query type for MissionRecord
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMissionRecord extends EntityPathBase<MissionRecord> {

    private static final long serialVersionUID = -405628075L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMissionRecord missionRecord = new QMissionRecord("missionRecord");

    public final umc.domain.common.QBaseEntity _super = new umc.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DateTimePath<java.time.LocalDateTime> lastUpdated = createDateTime("lastUpdated", java.time.LocalDateTime.class);

    public final QMember member;

    public final NumberPath<Long> missionCount = createNumber("missionCount", Long.class);

    public final QRegion region;

    public final NumberPath<Long> totalPoints = createNumber("totalPoints", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QMissionRecord(String variable) {
        this(MissionRecord.class, forVariable(variable), INITS);
    }

    public QMissionRecord(Path<? extends MissionRecord> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMissionRecord(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMissionRecord(PathMetadata metadata, PathInits inits) {
        this(MissionRecord.class, metadata, inits);
    }

    public QMissionRecord(Class<? extends MissionRecord> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new QMember(forProperty("member")) : null;
        this.region = inits.isInitialized("region") ? new QRegion(forProperty("region")) : null;
    }

}

