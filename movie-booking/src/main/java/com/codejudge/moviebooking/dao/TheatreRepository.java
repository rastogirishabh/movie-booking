package com.codejudge.moviebooking.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codejudge.moviebooking.entity.TheatreEntity;

public interface TheatreRepository extends JpaRepository<TheatreEntity, String> {

}
