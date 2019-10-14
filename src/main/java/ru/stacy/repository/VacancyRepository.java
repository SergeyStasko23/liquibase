package ru.stacy.repository;

import ru.stacy.domain.Vacancy;

import java.util.Set;

public interface VacancyRepository extends AbstractRepository<Vacancy> {
    Set<Vacancy> findAllByCompanyId(Long id);
}
