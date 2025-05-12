package umc.umc_spring.repository.StoreRepository;

import umc.umc_spring.domain.Store;

import java.util.List;

public interface StoreRepositoryCustom {
    List<Store> dynamicQueryWithBooleanBuilder(String name, Float score);
}