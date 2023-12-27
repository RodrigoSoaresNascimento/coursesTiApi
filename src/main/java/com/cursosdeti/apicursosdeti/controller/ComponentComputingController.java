package com.cursosdeti.apicursosdeti.controller;

import com.cursosdeti.apicursosdeti.dto.PageDTO;
import com.cursosdeti.apicursosdeti.dto.components.create.ComponentComputingDTO;
import com.cursosdeti.apicursosdeti.service.ComponentComputingService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/computingCourses")
@AllArgsConstructor
public class ComponentComputingController {


    private final ComponentComputingService computingService;

    @GetMapping("/find-by-id/{idCourse}")
    public ResponseEntity<ComponentComputingDTO> findById(@PathVariable("idCourse") Integer idCourse){
        return ResponseEntity.ok().body(computingService.getById(idCourse));
    }

    @GetMapping("/findAll")
    public List<ComponentComputingDTO> searchCourses () {
        return computingService.findAll();
    }

    @PutMapping("/update-course")
    public ResponseEntity<ComponentComputingDTO> updateCourse (@RequestParam Integer idCourse,
                                        @RequestBody ComponentComputingDTO computingDTO){
        return ResponseEntity.ok().body(computingService.update(computingDTO, idCourse));
    }

    @DeleteMapping("/delete/{idCurso}")
    public  ResponseEntity<Void> delete (@PathVariable("idCurso") Integer idCourse){
        computingService.delete(idCourse);
        return ResponseEntity.noContent().<Void>build();
    }

    @PostMapping("/add/{idCourse}")
    public ResponseEntity<ComponentComputingDTO> addCourse (@RequestBody ComponentComputingDTO componentComputing,
                                               @RequestParam Integer idCourseTi) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(computingService.create(componentComputing, idCourseTi));
    }

    @GetMapping("/paginacao-computing")
    public PageDTO<ComponentComputingDTO> coursesComputing (Integer pagina, Integer qtRegistro){
        return computingService.listarComponentesComputingPaginado(pagina,qtRegistro);
    }

}
