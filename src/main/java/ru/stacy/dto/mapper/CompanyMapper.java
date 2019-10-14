package ru.stacy.dto.mapper;

import org.mapstruct.Mapper;
import ru.stacy.domain.Company;
import ru.stacy.dto.CompanyDTO;

import java.util.List;
import java.util.Set;

@Mapper
public interface CompanyMapper {
    CompanyDTO toDTO(Company entity);
    Company toEntity(CompanyDTO dto);

    List<CompanyDTO> toListDTO(List<Company> listEntity);
    List<Company> toListEntity(List<CompanyDTO> listDTO);

    Set<CompanyDTO> toSetDTO(Set<Company> setEntity);
    Set<Company> toSetEntity(Set<CompanyDTO> setDTO);
}
