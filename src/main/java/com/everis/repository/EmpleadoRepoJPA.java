package com.everis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.everis.repository.entity.Empleado;

@Repository
public interface EmpleadoRepoJPA extends JpaRepository<Empleado, Integer>{

}
