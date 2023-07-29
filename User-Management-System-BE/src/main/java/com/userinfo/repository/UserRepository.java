package com.userinfo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.userinfo.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
