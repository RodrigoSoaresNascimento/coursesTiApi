package com.cursosdeti.apicursosdeti.repository;

import com.cursosdeti.apicursosdeti.entity.CourseTiEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseTiRepository extends JpaRepository<CourseTiEntity, Integer> {

}
