package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Triangle;

public interface TriangleRepository extends JpaRepository<Triangle, Long> {

}
