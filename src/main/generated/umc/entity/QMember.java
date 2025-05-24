package umc.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMember is a Querydsl query type for Member
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMember extends EntityPathBase<Member> {

    private static final long serialVersionUID = -1557142718L;

    public static final QMember member = new QMember("member1");

    public final umc.domain.common.QBaseEntity _super = new umc.domain.common.QBaseEntity(this);

    public final StringPath address = createString("address");

    public final DatePath<java.time.LocalDate> birth = createDate("birth", java.time.LocalDate.class);

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final StringPath email = createString("email");

    public final ListPath<FavoriteFood, QFavoriteFood> favoriteFoods = this.<FavoriteFood, QFavoriteFood>createList("favoriteFoods", FavoriteFood.class, QFavoriteFood.class, PathInits.DIRECT2);

    public final StringPath food = createString("food");

    public final StringPath gender = createString("gender");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DateTimePath<java.time.LocalDateTime> inactiveDate = createDateTime("inactiveDate", java.time.LocalDateTime.class);

    public final ListPath<MemberMission, QMemberMission> memberMissions = this.<MemberMission, QMemberMission>createList("memberMissions", MemberMission.class, QMemberMission.class, PathInits.DIRECT2);

    public final ListPath<MissionRecord, QMissionRecord> missionRecords = this.<MissionRecord, QMissionRecord>createList("missionRecords", MissionRecord.class, QMissionRecord.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    public final ListPath<SocialLogin, QSocialLogin> socialLogins = this.<SocialLogin, QSocialLogin>createList("socialLogins", SocialLogin.class, QSocialLogin.class, PathInits.DIRECT2);

    public final StringPath specAddress = createString("specAddress");

    public final StringPath status = createString("status");

    public final NumberPath<Long> totalPoints = createNumber("totalPoints", Long.class);

    public final DateTimePath<java.time.LocalDateTime> updatedAt = createDateTime("updatedAt", java.time.LocalDateTime.class);

    public QMember(String variable) {
        super(Member.class, forVariable(variable));
    }

    public QMember(Path<? extends Member> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMember(PathMetadata metadata) {
        super(Member.class, metadata);
    }

}

