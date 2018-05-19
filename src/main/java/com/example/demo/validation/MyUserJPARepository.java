package com.example.demo.validation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
@RepositoryRestResource(collectionResourceRel = "city", path = "city")
public interface MyUserJPARepository extends JpaRepository<City, String>,PagingAndSortingRepository<City, String> {

}
