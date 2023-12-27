package com.cursosdeti.apicursosdeti.dto.components.create;

import com.cursosdeti.apicursosdeti.dto.courseTi.CourseTiDTO;

public class ComponentComputingCreateDTO {

    private String courseName;
    private Integer classHours;
    private String syllabus;

    private CourseTiDTO courseTiDTO;

    public ComponentComputingCreateDTO(String courseName, Integer classHours, String syllabus, CourseTiDTO courseTiDTO) {
        this.courseName = courseName;
        this.classHours = classHours;
        this.syllabus = syllabus;
        this.courseTiDTO = courseTiDTO;
    }

    public ComponentComputingCreateDTO() {
    }

    public CourseTiDTO getCourseTiDTO() {
        return courseTiDTO;
    }

    public void setCourseTiDTO(CourseTiDTO courseTiDTO) {
        this.courseTiDTO = courseTiDTO;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getClassHours() {
        return classHours;
    }

    public void setClassHours(Integer classHours) {
        this.classHours = classHours;
    }

    public String getSyllabus() {
        return syllabus;
    }

    public void setSyllabus(String syllabus) {
        this.syllabus = syllabus;
    }

    @Override
    public String toString() {
        return "ComponentComputingCreateDTO{" +
                "courseName='" + courseName + '\'' +
                ", classHours=" + classHours +
                ", syllabus='" + syllabus + '\'' +
                '}';
    }
}
