package ru.stacy.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class AddressDTO {
    private Long id;
    private String city;
    private String street;
    private String house;

    @JsonIgnore
    private CompanyDTO company;
}
