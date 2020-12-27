package com.venky.repository;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.venky.entity.State;

@Repository
public interface StateRepository extends JpaRepository<State, Serializable> {

   List<State> findStates(Integer cId);
}
