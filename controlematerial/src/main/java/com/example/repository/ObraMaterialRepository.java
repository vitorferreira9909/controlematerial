package com.example.repository;

import com.example.model.ObraMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ObraMaterialRepository extends JpaRepository<ObraMaterial, Long> {
}