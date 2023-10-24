package com.CMEPPS.listatareas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.CMEPPS.listatareas.model.Todo;

public interface TodoRepository extends JpaRepository < Todo, Long > {
    List < Todo > findByUserName(String user);
}