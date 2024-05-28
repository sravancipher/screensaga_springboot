package com.rest.spring.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import com.rest.spring.entities.Watchlist;
public interface WatchlistDAO extends JpaRepository<Watchlist,Integer>{
}
