package umc.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QFavoriteFoodId is a Querydsl query type for FavoriteFoodId
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QFavoriteFoodId extends BeanPath<FavoriteFoodId> {

    private static final long serialVersionUID = 2046080893L;

    public static final QFavoriteFoodId favoriteFoodId = new QFavoriteFoodId("favoriteFoodId");

    public final NumberPath<Long> foodId = createNumber("foodId", Long.class);

    public final NumberPath<Long> memberId = createNumber("memberId", Long.class);

    public QFavoriteFoodId(String variable) {
        super(FavoriteFoodId.class, forVariable(variable));
    }

    public QFavoriteFoodId(Path<? extends FavoriteFoodId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QFavoriteFoodId(PathMetadata metadata) {
        super(FavoriteFoodId.class, metadata);
    }

}

