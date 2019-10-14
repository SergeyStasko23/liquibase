package ru.stacy.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.stacy.domain.Address;
import ru.stacy.domain.Company;
import ru.stacy.domain.Vacancy;
import ru.stacy.dto.AddressDTO;
import ru.stacy.dto.CompanyDTO;
import ru.stacy.dto.VacancyDTO;
import ru.stacy.dto.mapper.AddressMapper;
import ru.stacy.dto.mapper.CompanyMapper;
import ru.stacy.dto.mapper.VacancyMapper;
import ru.stacy.repository.AddressRepository;
import ru.stacy.repository.CompanyRepository;
import ru.stacy.repository.VacancyRepository;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@Slf4j
@Transactional
@Service
public class CompanyService {
    private final CompanyRepository companyRepository;
    private final VacancyRepository vacancyRepository;
    private final AddressRepository addressRepository;

    private final CompanyMapper companyMapper;
    private final AddressMapper addressMapper;
    private final VacancyMapper vacancyMapper;

    public CompanyDTO findById(Long id) {
        log.info("Find company (id: {})", id);

        Company company = companyRepository.getOne(id);
        CompanyDTO companyDTO = companyMapper.toDTO(company);

        Address address = addressRepository.findByCompanyId(id);
        AddressDTO addressDTO = addressMapper.toDTO(address);

        Set<Vacancy> vacancies = vacancyRepository.findAllByCompanyId(id);
        Set<VacancyDTO> vacanciesDTO = vacancyMapper.toSetDTO(vacancies);

        companyDTO.setAddressDTO(addressDTO);
        companyDTO.setVacanciesDTO(vacanciesDTO);

        return companyDTO;
    }

    public List<CompanyDTO> findAll() {
        log.info("Find all companies");
        List<Company> companies = companyRepository.findAll();
        List<CompanyDTO> companiesDTO = new LinkedList<>();

        for(Company company : companies) {
            CompanyDTO companyDTO = findById(company.getId());
            companiesDTO.add(companyDTO);
        }

        return companiesDTO;
    }

    public Long create(CompanyDTO companyDTO) {
        log.info("Create company (id: {})", companyDTO.getId());

        Company company = companyMapper.toEntity(companyDTO);

        Set<Vacancy> vacancies = company.getVacancies();
        vacancies.forEach(vacancyRepository::saveAndFlush);

        Address address = company.getAddress();
        addressRepository.saveAndFlush(address);

        companyRepository.save(company);
        return company.getId();
    }

    public Long updateById(Long id, CompanyDTO updCompanyDTO) {
        log.info("Update company (id: {})", id);
        Company company = companyRepository.getOne(id);

        Address address = addressMapper.toEntity(updCompanyDTO.getAddressDTO());
        company.setAddress(address);

        Set<Vacancy> vacancies = vacancyMapper.toSetEntity(updCompanyDTO.getVacanciesDTO());
        company.setVacancies(vacancies);

        companyRepository.saveAndFlush(company);
        return id;
    }

    public Long deleteById(Long id) {
        log.info("Delete company (id: {})", id);
        Company company = companyRepository.getOne(id);
        companyRepository.delete(company);
        return id;
    }
}
