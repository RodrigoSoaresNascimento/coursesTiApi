package com.cursosdeti.apicursosdeti.entity;

import com.cursosdeti.apicursosdeti.enums.CourseOptions;
import com.cursosdeti.apicursosdeti.enums.Modality;
import com.cursosdeti.apicursosdeti.enums.Period;
import com.cursosdeti.apicursosdeti.enums.converter.ModalityConverter;
import com.cursosdeti.apicursosdeti.enums.converter.PeriodConverter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

@Entity(name = "courses_ti")
public class CourseTiEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_COURSE")
    @SequenceGenerator(name = "SEQ_COURSE", sequenceName = "curso_sequence", allocationSize = 1)
    @Column(name = "course_id", insertable = false, updatable = false)
    private Integer idCourse;


    @Column(name = "course_name")
    private String courseName;

    @Column(name = "institution")
    private String institution;

    @Column(name = "modality")
    @Convert(converter = ModalityConverter.class)
    private Modality modality;

    @Column(name = "period")
    @Convert(converter = PeriodConverter.class)
    private Period period;

    @Column(name = "city")
    private String city;

    @Column(name = "soft_deleted")
    private CourseOptions disabled;

    public CourseOptions getDisabled() {
        return disabled;
    }

    public void setDisabled(CourseOptions disabled) {
        this.disabled = disabled;
    }

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "course",
            cascade = CascadeType.ALL)
    private Set<ComponentHumanAndSocialEntity> humanAndSocialComponents;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "course",
            cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ComponentComputingEntity> computingComponents;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "course",
            cascade = CascadeType.ALL)
    private Set<ComponentFinalProjectEntity> finalProjectComponents;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "course",
            cascade = CascadeType.ALL)
    private Set<ComponentOptionalEntity> optionalComponents;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "course",
            cascade = CascadeType.ALL)
    private Set<ComponentMathEntity> mathComponents;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "course",
            cascade = CascadeType.ALL)
    private Set<ComponentPhysicsEntity> physicsComponents;

    public Set<ComponentHumanAndSocialEntity> getHumanAndSocialComponents() {
        return humanAndSocialComponents;
    }

    public void setHumanAndSocialComponents(Set<ComponentHumanAndSocialEntity> humanAndSocialComponents) {
        this.humanAndSocialComponents = humanAndSocialComponents;
    }

    public Set<ComponentComputingEntity> getComputingComponents() {
        return computingComponents;
    }

    public void setComputingComponents(Set<ComponentComputingEntity> computingComponents) {
        this.computingComponents = computingComponents;
    }

    public Set<ComponentFinalProjectEntity> getFinalProjectComponents() {
        return finalProjectComponents;
    }

    public void setFinalProjectComponents(Set<ComponentFinalProjectEntity> finalProjectComponents) {
        if (this.finalProjectComponents != null){
            this.finalProjectComponents.clear();
            this.finalProjectComponents.addAll(finalProjectComponents);
        }else {
            this.finalProjectComponents = finalProjectComponents;
        }
    }

    public Set<ComponentOptionalEntity> getOptionalComponents() {
        return optionalComponents;
    }

    public void setOptionalComponents(Set<ComponentOptionalEntity> optionalComponents) {
        this.optionalComponents = optionalComponents;
    }

    public Set<ComponentMathEntity> getMathComponents() {
        return mathComponents;
    }

    public void setMathComponents(Set<ComponentMathEntity> mathComponents) {
        this.mathComponents = mathComponents;
    }

    public Set<ComponentPhysicsEntity> getPhysicsComponents() {
        return physicsComponents;
    }

    public void setPhysicsComponents(Set<ComponentPhysicsEntity> physicsComponents) {
        this.physicsComponents = physicsComponents;
    }

    public Integer getIdCourse() {
        return idCourse;
    }

    public void setIdCourse(Integer idCourse) {
        this.idCourse = idCourse;
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
        return period.getPeriod();
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CourseTiEntity that)) return false;
        return getIdCourse().equals(that.getIdCourse());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdCourse());
    }

}
