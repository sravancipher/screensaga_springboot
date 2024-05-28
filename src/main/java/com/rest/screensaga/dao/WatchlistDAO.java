package com.rest.screensaga.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.screensaga.entities.Watchlist;

public interface WatchlistDAO extends JpaRepository<Watchlist,Integer>{

}
