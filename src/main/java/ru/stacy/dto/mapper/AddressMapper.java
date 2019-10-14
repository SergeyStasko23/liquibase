package ru.stacy.dto.mapper;

import org.mapstruct.Mapper;
import ru.stacy.domain.Address;
import ru.stacy.dto.AddressDTO;

import java.util.List;
import java.util.Set;

@Mapper
public interface AddressMapper {
    AddressDTO toDTO(Address entity);
    Address toEntity(AddressDTO dto);

    List<AddressDTO> toListDTO(List<Address> listEntity);
    List<Address> toListEntity(List<AddressDTO> listDTO);

    Set<AddressDTO> toSetDTO(Set<Address> setEntity);
    Set<Address> toSetEntity(Set<AddressDTO> setDTO);
}
