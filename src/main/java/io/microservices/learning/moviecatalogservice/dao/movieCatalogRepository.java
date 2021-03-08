package io.microservices.learning.moviecatalogservice.dao;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import io.microservices.learning.moviecatalogservice.model.CatalogItem;

@Repository
public interface movieCatalogRepository extends PagingAndSortingRepository<CatalogItem, Integer>{

}
