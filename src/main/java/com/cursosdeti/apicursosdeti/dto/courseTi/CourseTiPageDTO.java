package com.cursosdeti.apicursosdeti.dto.courseTi;

import java.util.List;

public record CourseTiPageDTO(List<CourseTiDTO> courseTiDTOList, long totalElements, int totalPages) {
}
