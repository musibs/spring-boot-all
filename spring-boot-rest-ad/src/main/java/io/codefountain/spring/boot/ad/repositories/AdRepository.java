package io.codefountain.spring.boot.ad.repositories;

import io.codefountain.spring.boot.ad.model.Ad;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdRepository extends PagingAndSortingRepository<Ad, Long> {
    
}
