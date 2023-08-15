package com.cursosdeti.apicursosdeti.dto.courseTi;

import com.cursosdeti.apicursosdeti.enums.CourseOptions;
import com.cursosdeti.apicursosdeti.enums.Modality;

public class CourseTiDisableDTO {


    private String courseName;

    private String institution;

    private Modality modality;

    private String period;

    private String city;

    private CourseOptions options;

    private Integer _idCourse;

    public CourseTiDisableDTO(String courseName, String institution, Modality modality, String period, String city, CourseOptions options, Integer _idCourse) {
        this.courseName = courseName;
        this.institution = institution;
        this.modality = modality;
        this.period = period;
        this.city = city;
        this.options = options;
        this._idCourse = _idCourse;
    }

    public CourseOptions getOptions() {
        return options;
    }

    public void setOptions(CourseOptions options) {
        this.options = options;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getInstitution() {
        return institution;
    }

    public Modality getModality() {
        return modality;
    }

    public String getPeriod() {
        return period;
    }

    public String getCity() {
        return city;
    }

    public Integer get_idCourse() {
        return _idCourse;
    }
}
