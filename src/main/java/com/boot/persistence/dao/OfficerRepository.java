package com.boot.persistence.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.boot.persistence.entities.Officer;
import com.boot.persistence.entities.Rank;

public interface OfficerRepository extends JpaRepository<Officer, Integer>{
	List<Officer> findByRank(@Param("rank") Rank rank);
	List<Officer> findByLast(@Param("last") String last);
}
