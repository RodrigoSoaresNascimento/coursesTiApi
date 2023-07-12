package com.cursosdeti.apicursosdeti.controller;

import com.cursosdeti.apicursosdeti.entity.ComponentPhysicsEntity;
import com.cursosdeti.apicursosdeti.service.ComponentPhysicsService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/physicsCourses")
@AllArgsConstructor
public class ComponentPhysicsController {


    private final ComponentPhysicsService service;

    @GetMapping("/find-by-id/{idCourse}")
    public ComponentPhysicsEntity findById(@PathVariable("idCourse") Integer idCourse){
        return service.getById(idCourse);
    }

    @GetMapping("/findAll")
    public Page<ComponentPhysicsEntity> searchCourses (Pageable pageable) {
        return service.findAll(pageable);
    }

    @PutMapping("/update-course")
    public ComponentPhysicsEntity updateCourse (@RequestParam Integer idCourse,
                                        @RequestBody ComponentPhysicsEntity physicsEntity){
        return service.update(physicsEntity, idCourse);
    }

    @DeleteMapping("/delete/{idCurso}")
    public void delete (@PathVariable("idCurso") Integer idCourse){
        service.delete(idCourse);
    }

    @PostMapping("/add/{idCourse}")
    public ComponentPhysicsEntity addCourse (@RequestBody ComponentPhysicsEntity physicsEntity,
                                             @PathVariable("idCourse") Integer idCourseTi) {
        return service.create(physicsEntity, idCourseTi);
    }

}
