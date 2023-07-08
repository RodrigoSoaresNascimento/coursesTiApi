package com.cursosdeti.apicursosdeti.repository;

import com.cursosdeti.apicursosdeti.entity.ComponentHumanAndSocialEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComponentHumanAndSocialRepository extends JpaRepository<ComponentHumanAndSocialEntity, Integer> {
}
