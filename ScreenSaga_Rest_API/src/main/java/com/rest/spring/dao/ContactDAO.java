package com.rest.spring.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.spring.entities.Contact;

public interface ContactDAO extends JpaRepository<Contact,Integer>{

}
