package com.cursosdeti.apicursosdeti.controller;

import com.cursosdeti.apicursosdeti.entity.ComponentFinalProjectEntity;
import com.cursosdeti.apicursosdeti.service.ComponentFinalProjectService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/finalProjectCourses")
@AllArgsConstructor
public class ComponentFinalProjectController {


    private final ComponentFinalProjectService service;

    @GetMapping("/find-by-id/{idCourse}")
    public ComponentFinalProjectEntity findById(@PathVariable("idCourse") Integer idCourse){
        return service.getById(idCourse);
    }

    @GetMapping("/findAll")
    public Page<ComponentFinalProjectEntity> searchCourses (Pageable pageable) {
        return service.findAll(pageable);
    }

    @PutMapping("/update-course")
    public ComponentFinalProjectEntity updateCourse (@RequestParam Integer idCourse,
                                        @RequestBody ComponentFinalProjectEntity finalProjectEntity){
        return service.update(finalProjectEntity, idCourse);
    }

    @DeleteMapping("/delete/{idCourse}")
    public void delete (@PathVariable("idCourse") Integer idCourse){
        service.delete(idCourse);
    }

    @PostMapping("/add/{idCourse}")
    public ComponentFinalProjectEntity addCourse (@RequestBody ComponentFinalProjectEntity finalProjectEntity,
                                                  @PathVariable("idCourse") Integer idCourseTi) {
        return service.create(finalProjectEntity, idCourseTi);
    }


}
