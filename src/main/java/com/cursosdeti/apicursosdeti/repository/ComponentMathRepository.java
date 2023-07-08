package com.cursosdeti.apicursosdeti.repository;

import com.cursosdeti.apicursosdeti.entity.ComponentMathEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComponentMathRepository extends JpaRepository<ComponentMathEntity, Integer> {
}
