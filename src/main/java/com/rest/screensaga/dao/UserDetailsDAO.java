package com.rest.screensaga.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.screensaga.entities.User;

public interface UserDetailsDAO extends JpaRepository<User,String>{

}