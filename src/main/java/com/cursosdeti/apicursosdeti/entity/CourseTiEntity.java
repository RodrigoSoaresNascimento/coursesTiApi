package com.cursosdeti.apicursosdeti.entity;

import com.cursosdeti.apicursosdeti.enums.Modality;
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
    private Integer idCurso;


    @Column(name = "course_name")
    private String courseName;

    @Column(name = "institution")
    private String institution;

    @Column(name = "modality")
    private Modality modality;

    @Column(name = "period")
    private String period;

    @Column(name = "city")
    private String city;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "course")
    private Set<ComponentHumanAndSocialEntity> humanAndSocialComponents;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "course")
    private Set<ComponentComputingEntity> computingComponents;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "course")
    private Set<ComponentFinalProjectEntity> finalProjectComponents;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "course")
    private Set<ComponentOptionalEntity> optionalComponents;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "course")
    private Set<ComponentMathEntity> mathComponents;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "course")
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
        this.finalProjectComponents = finalProjectComponents;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CourseTiEntity that)) return false;
        return getIdCurso().equals(that.getIdCurso());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdCurso());
    }

}
