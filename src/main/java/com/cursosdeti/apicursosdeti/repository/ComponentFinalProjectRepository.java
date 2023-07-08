package com.cursosdeti.apicursosdeti.repository;

import com.cursosdeti.apicursosdeti.entity.ComponentFinalProjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComponentFinalProjectRepository extends JpaRepository<ComponentFinalProjectEntity, Integer> {
}
