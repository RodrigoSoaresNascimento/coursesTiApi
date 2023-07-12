package com.cursosdeti.apicursosdeti.controller;

import com.cursosdeti.apicursosdeti.entity.ComponentMathEntity;
import com.cursosdeti.apicursosdeti.service.ComponentMathService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mathCourses")
@AllArgsConstructor
public class ComponentMathController {


    private final ComponentMathService service;

    @GetMapping("/find-by-id/{idCourse}")
    public ComponentMathEntity findById(@PathVariable("idCourse") Integer idCourse){
        return service.getById(idCourse);
    }

    @GetMapping("/findAll")
    public Page<ComponentMathEntity> searchCourses (Pageable pageable) {
        return service.findAll(pageable);
    }

    @PutMapping("/update-course")
    public ComponentMathEntity updateCourse (@RequestParam Integer idCourse,
                                        @RequestBody ComponentMathEntity mathEntity){
        return service.update(mathEntity, idCourse);
    }

    @DeleteMapping("/delete/{idCurso}")
    public void delete (@PathVariable("idCurso") Integer idCourse){
        service.delete(idCourse);
    }

    @PostMapping("/add/")
    public ComponentMathEntity addCourse (@RequestBody ComponentMathEntity mathEntity,
                                          @RequestParam Integer idCourseTi) {
        return service.create(mathEntity, idCourseTi);
    }


}
