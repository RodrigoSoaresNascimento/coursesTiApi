package com.cursosdeti.apicursosdeti.repository;

import com.cursosdeti.apicursosdeti.entity.ComponentComputingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComponentComputingRepository extends JpaRepository<ComponentComputingEntity, Integer> {



}
