package ru.stacy.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class CompanyDTO {
    private Long id;
    private AddressDTO addressDTO;
    private Set<VacancyDTO> vacanciesDTO;
}
