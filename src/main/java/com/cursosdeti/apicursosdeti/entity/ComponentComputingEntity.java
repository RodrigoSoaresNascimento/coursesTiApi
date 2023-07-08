package com.cursosdeti.apicursosdeti.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Objects;
@Entity(name = "courses_computing")
public class ComponentComputingEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_COURSE")
    @SequenceGenerator(name = "SEQ_COURSE", sequenceName = "courses_sequence", allocationSize = 1)
    @Column(name = "course_id", insertable = false, updatable = false)
    private Integer idCurso;

    @Column(name = "course_name")
    private String courseName;

    @Column(name = "class_hours")
    private Integer classHours;

    @Column(name = "syllabus")
    private String syllabus;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fk_course_id", referencedColumnName = "course_id")
    private CourseTiEntity course;

    public Integer getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Integer idCurso) {
        this.idCurso = idCurso;
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

    public CourseTiEntity getCourse() {
        return course;
    }

    public void setCourse(CourseTiEntity course) {
        this.course = course;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ComponentComputingEntity that)) return false;
        return getIdCurso().equals(that.getIdCurso());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdCurso());
    }
    
}
