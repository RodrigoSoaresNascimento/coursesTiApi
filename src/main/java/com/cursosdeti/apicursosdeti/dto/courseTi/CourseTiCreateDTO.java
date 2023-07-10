package com.cursosdeti.apicursosdeti.dto.courseTi;

import com.cursosdeti.apicursosdeti.enums.Modality;

public class CourseTiCreateDTO {

    private String courseName;
    private String institution;
    private Modality modality;
    private String period;
    private String city;

    public CourseTiCreateDTO() {
    }

    public CourseTiCreateDTO(String courseName, String institution, Modality modality, String period, String city) {
        this.courseName = courseName;
        this.institution = institution;
        this.modality = modality;
        this.period = period;
        this.city = city;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public Modality getModality() {
        return modality;
    }

    public void setModality(Modality modality) {
        this.modality = modality;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "CourseTiCreateDTO{" +
                "courseName='" + courseName + '\'' +
                ", institution='" + institution + '\'' +
                ", modality=" + modality +
                ", period='" + period + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
