package com.techwave.demo.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.techwave.demo.pojo.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

}
