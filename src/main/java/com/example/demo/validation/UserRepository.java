package com.example.demo.validation;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserRepository extends CrudRepository<User2, Long>,PagingAndSortingRepository<User2, Long> {

}
