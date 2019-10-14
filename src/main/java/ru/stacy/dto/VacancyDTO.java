package ru.stacy.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import ru.stacy.domain.enums.VacancyType;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
public class VacancyDTO {
    private Long id;
    private VacancyType vacancyType;
    private String description;
    private String experience;
    private LocalDateTime publishedAtDate;
    private LocalTime publishedAtTime;
    private LocalDateTime publishedAtDateTime;

    @JsonIgnore
    private CompanyDTO company;
}
