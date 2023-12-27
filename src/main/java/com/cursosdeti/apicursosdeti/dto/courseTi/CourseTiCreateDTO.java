package com.cursosdeti.apicursosdeti.dto.courseTi;

import com.cursosdeti.apicursosdeti.dto.components.create.ComponentComputingDTO;
import com.cursosdeti.apicursosdeti.enums.Modality;
import com.cursosdeti.apicursosdeti.enums.Period;
import com.cursosdeti.apicursosdeti.enums.validation.ValueOfEnum;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import org.hibernate.collection.spi.PersistentList;

import java.util.Set;

public class CourseTiCreateDTO {

    @NotNull
    @NotBlank
    @Size(min = 3, max = 255, message = "O tamanho não pode ser menor que 3 caracteres")
    private String courseName;

    @NotNull
    @NotBlank
    @Size(min = 3, max = 255, message = "O tamanho não pode ser menor que 3 caracteres")
    private String institution;


    @NotNull
    @NotBlank
    @Size(min = 3, max = 255, message = "O tamanho não pode ser menor que 3 caracteres")
    private String city;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    //@ValueOfEnum(enumClass = Modality.class)
    private Modality modality;

    @Schema(accessMode = Schema.AccessMode.READ_ONLY)
    //@ValueOfEnum(enumClass = Period.class)
    private Period period;

    //@Schema(accessMode = Schema.AccessMode.READ_ONLY)
    private Set<ComponentComputingDTO> componentComputingDTOSet;


    public CourseTiCreateDTO() {
    }

    public CourseTiCreateDTO(String courseName, String institution, String city, Modality modality, Period period, Set<ComponentComputingDTO> componentComputingDTOSet) {
        this.courseName = courseName;
        this.institution = institution;
        this.city = city;
        this.modality = modality;
        this.period = period;
        this.componentComputingDTOSet = componentComputingDTOSet;
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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Modality getModality() {
        return modality;
    }

    public void setModality(Modality modality) {
        this.modality = modality;
    }

    public Period getPeriod() {
        return period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    public Set<ComponentComputingDTO> getComponentComputingDTOSet() {
        return componentComputingDTOSet;
    }

    public void setComponentComputingDTOSet(Set<ComponentComputingDTO> componentComputingDTOSet) {
        this.componentComputingDTOSet = componentComputingDTOSet;
    }

    @Override
    public String toString() {
        return "CourseTiCreateDTO{" +
                "courseName='" + courseName + '\'' +
                ", institution='" + institution + '\'' +
                ", city='" + city + '\'' +
                ", modality=" + modality +
                ", period=" + period +
                '}';
    }
}
