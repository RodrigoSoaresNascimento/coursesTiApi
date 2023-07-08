package com.cursosdeti.apicursosdeti.controller;

import com.cursosdeti.apicursosdeti.entity.ComponentComputingEntity;
import com.cursosdeti.apicursosdeti.service.ComponentComputingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/computingCourses")
public class ComponentComputingController {

    @Autowired
    private ComponentComputingService computingService;

    @GetMapping("/find-by-id/{idCourse}")
    public ComponentComputingEntity findById(@PathVariable("idCourse") Integer idCourse){
        return computingService.getById(idCourse);
    }

    @GetMapping("/findAll")
    public Page<ComponentComputingEntity> searchCourses (Pageable pageable) {
        return computingService.findAll(pageable);
    }

    @PutMapping("/update-course")
    public ComponentComputingEntity updateCourse (@RequestParam Integer idCourse,
                                        @RequestBody ComponentComputingEntity computingEntity){
        return computingService.update(computingEntity, idCourse);
    }

    @DeleteMapping("/delete/{idCurso}")
    public void delete (@PathVariable("idCurso") Integer idCourse){
        computingService.delete(idCourse);
    }

    @PostMapping("/add/{idCourse}")
    public ComponentComputingEntity addCourse (@RequestBody ComponentComputingEntity componentComputing,
                                               @RequestParam Integer idCourseTi) {
        return computingService.create(componentComputing, idCourseTi);
    }


}