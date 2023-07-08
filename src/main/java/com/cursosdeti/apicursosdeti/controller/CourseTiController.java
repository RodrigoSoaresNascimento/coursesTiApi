package com.cursosdeti.apicursosdeti.controller;

import com.cursosdeti.apicursosdeti.entity.CourseTiEntity;
import com.cursosdeti.apicursosdeti.service.CourseTiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cursos")
public class CourseTiController {

    @Autowired
    private CourseTiService courseTiService;

    @GetMapping("/find-by-id/{idCourse}")
    public CourseTiEntity findById(@PathVariable("idCourse") Integer idCurso) {
        return courseTiService.getByid(idCurso);
    }

    @GetMapping("/findAll")
    public Page<CourseTiEntity> searchCourses (Pageable pageable){
        return courseTiService.findAll(pageable);
    }

    @PutMapping("/update-course")
    public CourseTiEntity updateCourse (@RequestParam Integer idCourse,
                                        @RequestBody CourseTiEntity cursoUpdate){
        return courseTiService.update(cursoUpdate, idCourse);
    }

    @DeleteMapping("/delete/{idCurso}")
    public void delete (@PathVariable("idCurso") Integer idCourse){
        courseTiService.delete(idCourse);
    }

    @PostMapping("/add")
    public CourseTiEntity addCourse (@RequestBody CourseTiEntity courseTi) {
        return courseTiService.create(courseTi);
    }

}
