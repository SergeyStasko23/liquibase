package ru.stacy.dto.mapper;

import org.mapstruct.Mapper;
import ru.stacy.domain.Vacancy;
import ru.stacy.dto.VacancyDTO;

import java.util.List;
import java.util.Set;

@Mapper
public interface VacancyMapper {
    VacancyDTO toDTO(Vacancy entity);
    Vacancy toEntity(VacancyDTO dto);

    List<VacancyDTO> toListDTO(List<Vacancy> listEntity);
    List<Vacancy> toListEntity(List<VacancyDTO> listDTO);

    Set<VacancyDTO> toSetDTO(Set<Vacancy> setEntity);
    Set<Vacancy> toSetEntity(Set<VacancyDTO> setDTO);
}
