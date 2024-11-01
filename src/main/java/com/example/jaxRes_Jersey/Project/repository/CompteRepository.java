package com.example.jaxRes_Jersey.Project.repository;

import com.example.jaxRes_Jersey.Project.entity.Compte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompteRepository extends JpaRepository<Compte , Long> {
}
