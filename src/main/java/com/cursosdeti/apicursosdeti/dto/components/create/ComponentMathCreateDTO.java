package com.cursosdeti.apicursosdeti.dto.components.create;

public class ComponentMathCreateDTO {

    private String courseName;
    private Integer classHours;
    private String syllabus;

    public ComponentMathCreateDTO(String courseName, Integer classHours, String syllabus) {
        this.courseName = courseName;
        this.classHours = classHours;
        this.syllabus = syllabus;
    }

    public ComponentMathCreateDTO() {
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
}
