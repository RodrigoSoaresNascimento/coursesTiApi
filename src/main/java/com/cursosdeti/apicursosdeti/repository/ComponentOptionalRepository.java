package com.cursosdeti.apicursosdeti.repository;

import com.cursosdeti.apicursosdeti.entity.ComponentOptionalEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComponentOptionalRepository extends JpaRepository<ComponentOptionalEntity, Integer> {
}
