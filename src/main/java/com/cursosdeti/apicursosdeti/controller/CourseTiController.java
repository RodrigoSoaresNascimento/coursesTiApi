package com.cursosdeti.apicursosdeti.controller;

import com.cursosdeti.apicursosdeti.dto.courseTi.CourseTiDTO;
import com.cursosdeti.apicursosdeti.entity.CourseTiEntity;
import com.cursosdeti.apicursosdeti.service.CourseTiService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cursos")
@AllArgsConstructor
public class CourseTiController {


    private final CourseTiService courseTiService;

    @GetMapping("/find-by-id/{idCourse}")
    public CourseTiDTO findById(@PathVariable("idCourse") Integer idCurso) {
        return courseTiService.getByid(idCurso);
    }

    @GetMapping("/findAll")
    public List<CourseTiDTO> searchCourses (){
        return courseTiService.findAll();
    }

    @PutMapping("/update-course")
    public CourseTiDTO updateCourse (@RequestParam Integer idCourse,
                                        @RequestBody CourseTiDTO cursoUpdate){
        return courseTiService.update(cursoUpdate, idCourse);
    }

    @DeleteMapping("/delete/{idCurso}")
    public void delete (@PathVariable("idCurso") Integer idCourse){
        courseTiService.delete(idCourse);
    }

    @PostMapping("/add")
    public ResponseEntity<CourseTiDTO> addCourse (@RequestBody CourseTiDTO courseTi) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(courseTiService.create(courseTi));
    }

}
