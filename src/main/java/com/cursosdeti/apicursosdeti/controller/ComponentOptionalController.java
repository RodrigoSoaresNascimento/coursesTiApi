package com.cursosdeti.apicursosdeti.controller;

import com.cursosdeti.apicursosdeti.entity.ComponentOptionalEntity;
import com.cursosdeti.apicursosdeti.service.ComponentOptionalService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/optionalCourses")
@AllArgsConstructor
public class ComponentOptionalController {


    private final ComponentOptionalService service;

    @GetMapping("/find-by-id/{idCourse}")
    public ComponentOptionalEntity findById(@PathVariable("idCourse") Integer idCourse){
        return service.getById(idCourse);
    }

    @GetMapping("/findAll")
    public Page<ComponentOptionalEntity> searchCourses (Pageable pageable) {
        return service.findAll(pageable);
    }

    @PutMapping("/update-course")
    public ComponentOptionalEntity updateCourse (@RequestParam Integer idCourse,
                                        @RequestBody ComponentOptionalEntity optionalEntity){
        return service.update(optionalEntity, idCourse);
    }

    @DeleteMapping("/delete/{idCurso}")
    public void delete (@PathVariable("idCurso") Integer idCourse){
        service.delete(idCourse);
    }

    @PostMapping("/add/")
    public ComponentOptionalEntity addCourse (@RequestBody ComponentOptionalEntity optionalEntity,
                                              @RequestParam Integer idCourseTi) {
        return service.create(optionalEntity, idCourseTi);
    }


}
