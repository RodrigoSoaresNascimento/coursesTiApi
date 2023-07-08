package com.cursosdeti.apicursosdeti.controller;

import com.cursosdeti.apicursosdeti.entity.ComponentHumanAndSocialEntity;
import com.cursosdeti.apicursosdeti.service.ComponentHumanAndSocialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/humanAndSocialCourses")
public class ComponentHumanAndSocialController {

    @Autowired
    private ComponentHumanAndSocialService service;

    @GetMapping("/find-by-id/{idCourse}")
    public ComponentHumanAndSocialEntity findById(@PathVariable("idCourse") Integer idCourse){
        return service.getById(idCourse);
    }

    @GetMapping("/findAll")
    public Page<ComponentHumanAndSocialEntity> searchCourses (Pageable pageable) {
        return service.findAll(pageable);
    }

    @PutMapping("/update-course/")
    public ComponentHumanAndSocialEntity updateCourse (@RequestParam Integer idCourse,
                                        @RequestBody ComponentHumanAndSocialEntity humanAndSocialEntity){
        return service.update(humanAndSocialEntity, idCourse);
    }

    @DeleteMapping("/delete/{idCurso}")
    public void delete (@PathVariable("idCurso") Integer idCourse){
        service.delete(idCourse);
    }

    @PostMapping("/add/{idCourse}")
    public ComponentHumanAndSocialEntity addCourse (@RequestBody ComponentHumanAndSocialEntity humanAndSocialEntity,
                                                    @PathVariable("idCourse") Integer idCourseTi) {
        return service.create(humanAndSocialEntity, idCourseTi);
    }


}
