package com.rest.spring.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import com.rest.spring.entities.User;
public interface UserDetailsDAO extends JpaRepository<User,String>{
}
