package com.cursosdeti.apicursosdeti.controller;

import com.cursosdeti.apicursosdeti.dto.courseTi.CourseTiDTO;
import com.cursosdeti.apicursosdeti.dto.courseTi.CourseTiDisableDTO;
import com.cursosdeti.apicursosdeti.enums.CourseOptions;
import com.cursosdeti.apicursosdeti.service.CourseTiService;
import jakarta.validation.Valid;
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
    public ResponseEntity<CourseTiDTO> findById(@PathVariable("idCourse") Integer idCurso) {
        return ResponseEntity.ok().body(courseTiService.getByid(idCurso));
    }

    @GetMapping("/findAll")
    public List<CourseTiDTO> searchCourses (){
        return courseTiService.findAll();
    }

    @PutMapping("/update-course")
    public ResponseEntity<CourseTiDTO> updateCourse (
                                                         @RequestParam Integer idCourse,
                                                         @Valid @RequestBody CourseTiDTO cursoUpdate){
        return ResponseEntity.ok().body(courseTiService.update(cursoUpdate, idCourse));
    }

    @DeleteMapping("/delete/{idCurso}")
    public ResponseEntity<Void> delete (@PathVariable("idCurso") Integer idCourse){
        courseTiService.delete(idCourse);
        return ResponseEntity.noContent().<Void>build();
    }

    @PostMapping("/add")
    public ResponseEntity<CourseTiDTO> addCourse (@Valid @RequestBody CourseTiDTO courseTi) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(courseTiService.create(courseTi));
    }

    @PutMapping("/disable-course")
    public ResponseEntity<CourseTiDisableDTO> disableCourse (@RequestParam Integer idCourse, @RequestParam CourseOptions options){
        return ResponseEntity.ok().body(courseTiService.disableCourseTi(idCourse, options));
    }

}
