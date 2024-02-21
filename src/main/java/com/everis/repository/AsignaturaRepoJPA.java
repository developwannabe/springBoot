package com.everis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.everis.repository.entity.Asignatura;

@Repository
public interface AsignaturaRepoJPA extends JpaRepository<Asignatura, Integer>, AsignaturaRepo{

}
