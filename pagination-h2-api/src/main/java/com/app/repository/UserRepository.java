package com.app.repository;

import com.app.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;


//The JpaRepository already extends PagingAndSortingRepository, so adding it explicitly isn't necessary but can be added for clarity.
public interface UserRepository extends JpaRepository<UserEntity,Integer>, PagingAndSortingRepository<UserEntity,Integer> {
}
