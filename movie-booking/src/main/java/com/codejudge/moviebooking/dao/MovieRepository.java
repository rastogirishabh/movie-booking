package com.codejudge.moviebooking.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codejudge.moviebooking.entity.MovieEntity;

public interface MovieRepository extends JpaRepository<MovieEntity, String>{

}
