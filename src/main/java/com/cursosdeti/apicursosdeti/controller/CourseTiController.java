package com.cursosdeti.apicursosdeti.controller;

import com.cursosdeti.apicursosdeti.dto.courseTi.CourseTiDTO;
import com.cursosdeti.apicursosdeti.dto.courseTi.CourseTiDisableDTO;
import com.cursosdeti.apicursosdeti.dto.courseTi.CourseTiPageDTO;
import com.cursosdeti.apicursosdeti.enums.CourseOptions;
import com.cursosdeti.apicursosdeti.enums.Modality;
import com.cursosdeti.apicursosdeti.enums.Period;
import com.cursosdeti.apicursosdeti.service.CourseTiService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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


    @GetMapping("/findPages")
    public CourseTiPageDTO coursesTiDTOPages (    @RequestParam(defaultValue = "0")
                                                  @PositiveOrZero Integer pageNumber,
                                                  @RequestParam(defaultValue = "10")
                                                  @Positive
                                                  @Max(20)
                                                  Integer size
    ){
        return courseTiService.PageList(pageNumber,size);
    }

    @PutMapping("/update-course")
    public ResponseEntity<CourseTiDTO> updateCourse (
                                                         @Valid @RequestBody CourseTiDTO cursoUpdate,
                                                         @RequestParam Integer idCourse,
                                                         @RequestParam Period period,
                                                         @RequestParam Modality modality){
        return ResponseEntity.ok().body(courseTiService.update(cursoUpdate, idCourse, period, modality));
    }

    @DeleteMapping("/delete/{idCurso}")
    public ResponseEntity<Void> delete (@PathVariable("idCurso") Integer idCourse){
        courseTiService.delete(idCourse);
        return ResponseEntity.noContent().<Void>build();
    }

    @PostMapping("/add" )
    public ResponseEntity<CourseTiDisableDTO> addCourse (@Valid @RequestBody CourseTiDTO courseTi, @RequestParam Period period, @RequestParam Modality modality) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(courseTiService.create(courseTi,period, modality));
    }

    @PutMapping("/disable-course")
    public ResponseEntity<CourseTiDisableDTO> disableCourse (@RequestParam Integer idCourse, @RequestParam CourseOptions options){
        return ResponseEntity.ok().body(courseTiService.disableCourseTi(idCourse, options));
    }

}
